package superman;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.entity.EmailUser;
import com.baidu.entity.Page;
import com.baidu.entity.User;
import com.baidu.service.EmailUserService;
import com.baidu.service.UserService;
import com.baidu.util.PageUtil;

public class ShowTest {
	@Resource
	private UserService service=null;
	@Autowired
	private EmailUserService emailUserService;
	@Test
	public void test1(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		service = ac.getBean("userService",UserService.class);
		User user=service.login("13157408899","7bef1dd55184281a9986e0b97092f08f");
	   System.out.println(user);
	}
	
	@Test
	public void test2(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		service = ac.getBean("userService",UserService.class);
		User us=new User();
		List<User> user=service.findCheck(us);
		for(User u:user){
			 System.out.println(u);
		}
	  
	}
	
	@Test
	public void findAll(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		service = ac.getBean("userService",UserService.class);
		int count=service.getAll();
		System.out.println(count);
	  
	}
	
	@Test
	public void findPage(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		service = ac.getBean("userService",UserService.class);
		int currentPage=2;
		int count=service.getAll();
		Page page=PageUtil.createPage(10, count, currentPage);
		System.out.println(page.getBeginIndex());
		System.out.println(page.getEveryPage());
		List<User> all=service.showPage(page);
		for(User user:all){
			System.out.println(user);
		}
		System.out.println(count);
	  
	}
	//注册
	@Test
	public void regist(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		service = ac.getBean("userService",UserService.class);
		Boolean flag=service.registCheck("15356152343", "18086518450");
		
	}
	
	@Test
	public void email(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		emailUserService = ac.getBean("emailUserService",EmailUserService.class);
        EmailUser user=new EmailUser("g009sss","passwords","s657182420@ss","657433ss");
		boolean flag=emailUserService.addUser(user);
	    System.out.println(flag);
	}
	
	@Test
	public void change(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		emailUserService = ac.getBean("emailUserService",EmailUserService.class);
		emailUserService.changeState("sscode");		
	}
	
}
