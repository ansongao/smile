package com.baidu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.Base64;
import com.baidu.utilOne.ChinaCharacter;
import com.google.common.collect.Maps;

/**
 * 生成验证码的服务端控制类
 * 
 * @author Administrator
 *
 */
@Controller
public class CodeController {

	private static final int WIDTH = 120;// 生成图片的宽度
	private static final int HEIGHT = 30;// 生成图片的高度

	@RequestMapping("/admin/createCode")
	public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 接受客户端传递的数据
		String createTypeFlag = request.getParameter("createTypeFlag");
		// 在内存中创建一张图片
	    System.out.println("验证码"+createTypeFlag);
		BufferedImage bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		// 得到图片
		Graphics g = bi.getGraphics();
		// 设置图片的背景色
	    setBackGround(g);
		// 设置图片边框
	    setBorder(g);
	    // 在图片上花干扰线
	    drawRandomLine(g);
	    //根据客户端传来的数据生成对应验证码
	    String random=drawRandomNum((Graphics2D) g,createTypeFlag);
	    //将随机数存入session
	    request.getSession().setAttribute("checkcode", random);
	    System.out.println(random);
	    //设置响应头通知浏览器以图片形式打开
	    response.setContentType("image/jpeg");
	    //设置响应头控制浏览器不要缓存
	    response.setDateHeader("expries", -1);
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
	
	    //将图片写给浏览器
	    ImageIO.write(bi, "PNG", response.getOutputStream());
	    
	}

	/**
	 * 设置图片背景色
	 */
	private void setBackGround(Graphics g) {
		// 设置颜色
		g.setColor(Color.WHITE);
		System.out.println("设置图片背景色");
		// 填充区域
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);

	}

	/**
	 * 设置图片的边框
	 */
	private void setBorder(Graphics g) {
		// 设置边框颜色
		g.setColor(Color.BLUE);
		// 边框区域
		System.out.println("设置图片边框");
		g.drawRect(1, 1, WIDTH - 2, HEIGHT - 2);

	}

	/**
	 * 在图片上划随机线条
	 */
	private void drawRandomLine(Graphics g) {
		// 设置颜色
		g.setColor(Color.GREEN);
		// 设置线条个数并画线
		for (int i = 0; i < 5; i++) {
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 画随机字符 * String... createTypeFlag是可变参数，
	 * Java1.5增加了新特性：可变参数：适用于参数个数不确定，类型确定的情况， java把可变参数当做数组处理。注意：可变参数必须位于最后一项
	 */
	private String drawRandomNum(Graphics2D g, String... createTypeFlag) {
		// 设置颜色
		g.setColor(Color.RED);
		// 设置字体
		g.setFont(new Font("宋体", Font.BOLD, 20));
		// 常用中国汉字
		String baseChineseChar = ChinaCharacter.baseChineseChar;
		// 数字和字母的组合
		String baseNumLetter = "0123456789ABCDEFGHJKLMNOPQRSTUVWXYZ";
		// 纯数字
		String baseNum = "0123456789";
		// 纯字母
		String baseLetter = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
		// createTypeFlag[0]==null表示没有传递参数
		if (createTypeFlag.length > 0 && null != createTypeFlag[0]) {
			if (createTypeFlag[0].equals("ch")) {
				// 截取汉字
				return createRandomChar(g, baseChineseChar);
			} else if (createTypeFlag[0].equals("nl")) {
				// 截取数字和字母的组合
				return createRandomChar(g, baseNumLetter);
			} else if (createTypeFlag[0].equals("n")) {
				// 截取数字
				return createRandomChar(g, baseNum);
			} else if (createTypeFlag[0].equals("l")) {
				// 截取字母
				return createRandomChar(g, baseLetter);
			}
		} else {
			// 默认截取数字和字母的组合
			//return createRandomChar(g, baseNumLetter);
			return createRandomChar(g, baseChineseChar);
		}

		return "";
	}

	/**
	 * 创建随机字符
	 */
	private String createRandomChar(Graphics2D g, String baseChar) {
		StringBuffer sb = new StringBuffer();
		int x = 5;
		String ch = "";
		// 控制字数
		for (int i = 0; i < 4; i++) {
			// 设置字体旋转角度
			int degree = new Random().nextInt() % 30;
			ch = baseChar.charAt(new Random().nextInt(baseChar.length())) + "";
			sb.append(ch);
			// 正向角度
			g.rotate(degree * Math.PI / 180, x, 20);
			g.drawString(ch, x, 20);
			// 反向角度
			g.rotate(-degree * Math.PI / 180, x, 20);
			x += 30;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String provider="MTM4Njc0NzUzMTE=";
		String code="MTEzNTc0";
		String url="http://sys.linshaolong.cn/index/addCode";
		JSONArray j=new JSONArray();
	    JSONObject params=new JSONObject();
	    params.put("card_id", "PO-20171019142643066");
	    params.put("product", "J01");
	    params.put("mobile", "18019031119");
	    j.add(params);
	    String result=sendPost(url,j);
		System.out.println(result);
	}
	
	
	
	 public static String sendPost(String url, JSONArray param) {
	        PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	            conn.setRequestProperty("WWW-Authenticate", "Basic MTM4Njc0NzUzMTE6MTEzNTc0");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！" + e);
	            e.printStackTrace();
	        }
	        // 使用finally块来关闭输出流、输入流
	        finally {
	            try {
	                if (out != null) {
	                    out.close();
	                }
	                if (in != null) {
	                    in.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
	        return result;
	    }
	    
	
}
