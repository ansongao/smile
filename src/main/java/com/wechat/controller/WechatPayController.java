package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.controller.BaseController;
import com.baidu.entity.OrderPayLog;
import com.baidu.util.QRCodeUtil;
import com.google.zxing.WriterException;

import net.sf.json.JSONObject;


@Controller
public class WechatPayController extends BaseController{

   /**
    * 发起支付保证金	
    */
	   @RequestMapping("/webpc/order/startPayDeposit")
	    public void startPayDeposit(HttpServletRequest request, 
	            HttpServletResponse response) throws IOException {
	        //SessionUser su = getCurrentUser(request);
		    String su=null;
	        String id = request.getParameter("id");
	        //获取用户请求的主机IP地址
	        String ip=getIpAddress(request);
	        System.out.println(ip);
	        OrderPayLog payLog = new OrderPayLog();
	        payLog.setTradeType("NATIVE");
	        payLog.setSpbillCreateIp(ip);
	        payLog.setBody("M-超人-支付保证金");
	        payLog.setAttach("deposit");
	        payLog.setOpenid("");
	        payLog.setExpenseType(0);
	 //       payLog = orderPayService.startWechatPay(id, payLog, su);
	        Map<String, Object> resultMap =new HashMap();
	        if (payLog.getPayStatus() == 2) {
	            //提交成功
	            try {
	                //生成二维码
	                String imageBase64 = QRCodeUtil.createQRCodeOfBase64(payLog.getCodeUrl());
	                resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_TRUE);
	                resultMap.put(RESULTMAP_KEY_DATA, imageBase64);
	            } 
	            catch (WriterException e) {
	                e.printStackTrace();
	                resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_FALSE);
	                resultMap.put(RESULTMAP_KEY_MSG, "二维码生成错误，请稍后再试。");
	            }
	        }
	        else if(payLog.getPayStatus() == 3){
	            resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_FALSE);
	            resultMap.put(RESULTMAP_KEY_MSG, "订单已支付保证金");
	        }
	        else {
	           // resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_FALSE);
	           // resultMap.put(RESULTMAP_KEY_MSG, payLog.getErrCodeDes());
	        	 try {
	                 //生成二维码
	                 String imageBase64 = QRCodeUtil.createQRCodeOfBase64("weixin://wxpay/bizpayurl?pr=nNDrhXB");
	                 resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_TRUE);
	                 resultMap.put(RESULTMAP_KEY_DATA, imageBase64);
	             } 
	             catch (WriterException e) {
	                 e.printStackTrace();
	                 resultMap.put(RESULTMAP_KEY_SUCCESS, RESULTMAP_SUCCESS_FALSE);
	                 resultMap.put(RESULTMAP_KEY_MSG, "二维码生成错误，请稍后再试。");
	             }
	        }
	        resultMap.put("pay_status", payLog.getPayStatus());
	        //orderService.startPayDeposit(id, "", su);
	   //     renderJson(response, resultMap);
	        JSONObject j=new JSONObject();
	        j.put(response, resultMap);
	        
	    }
	
	
    /**
     * 支付保证金	
     */
	 @RequestMapping("/webpc/order/payDeposit")
	    public String payDeposit(HttpServletRequest request) {
	        String id = request.getParameter("id");
	   //     Order order = orderService.queryById(id);
	   //     List<OrderDetail> details = detailService.queryByOrderNo(order.getOrderNo());
	   //     request.setAttribute("order", order);
	   //     request.setAttribute("details", details);
	        return "pc/payDeposit";
	    }
	 
	 
	 /**
	  *获取用户真实ip地址 
	  * @param request
	  * @return
	  */
	 public static String getIpAddress(HttpServletRequest request) {     
	        String ip = request.getHeader("x-forwarded-for");   
	        //System.out.println("x-forwarded-for:"+ ip);
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	            ip = request.getHeader("Proxy-Client-IP");     
	        }     
	        //System.out.println("Proxy-Client-IP:"+ ip);
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {       
	            ip = request.getHeader("WL-Proxy-Client-IP");     
	        }     
	        //System.out.println("WL-Proxy-Client-IP:"+ ip);
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {       
	            ip = request.getHeader("HTTP_CLIENT_IP");     
	        }     
	        //System.out.println("HTTP_CLIENT_IP:"+ ip);
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {       
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");     
	        }     
	        //System.out.println("HTTP_X_FORWARDED_FOR:"+ ip);
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {       
	            ip = request.getRemoteAddr();     
	        }     
	        //System.out.println("getRemoteAddr:"+ ip);
	        //System.out.println("getRemoteAddr():"+ request.getRemoteAddr());
	        if (ip != null || ip.indexOf(", ") > 0){
	            String[] ips = ip.split(", ");
	            for (String i : ips) {
	                if(i != null && i.length() > 0 && !"unknown".equalsIgnoreCase(i)){
	                    ip = i;
	                    break;
	                }
	            }
	        }
	        System.out.println("ip:"+ ip);
	        return ip;   
	    } 
	 
	 
	 

}
