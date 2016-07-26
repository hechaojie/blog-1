package test.blog.user.service.server;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.blog.user.core.entity.User;
import com.blog.user.core.service.UserService;
import com.blog.user.service.dao.UserDao;

/**
 * Server
 */
public class Server {

	public static final Log log = LogFactory.getLog(Server.class);

	public static void main(String[] args) {
		String[] configs = new String[] { "spring/spring-*.xml" };
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configs);
		try {

			UserService ud = (UserService)context.getBean("userService");
			System.out.println(ud.findAll().size());
			
			UserDao udao = (UserDao)context.getBean("userDao");
			List<User> users = udao.findUsersByConditions(new HashMap(), 1, 5);
			for (int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				System.out.println(u.getEmail());
			}
			
		} catch (Exception e) {
			log.error("server start error : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
