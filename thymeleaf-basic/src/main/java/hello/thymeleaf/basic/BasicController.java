package hello.thymeleaf.basic;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Controller
@RequestMapping("/basic")
public class BasicController {

	@GetMapping("/text-basic")
	public String textBasic(Model model) {
		model.addAttribute("data", "Hello Spring!");
		return "basic/text-basic";
	}

	/**
	 * unescape 사용
	 */
	@GetMapping("/text-unescaped")
	public String textUnescaped(Model model) {
		model.addAttribute("data", "Hello <b>Spring!</b>");
		return "basic/text-unescaped";
	}

	/**
	 * SpringEL 변수 표현식
	 */
	@GetMapping("/variable")
	public String variable(Model model) {
		User userA = new User("userA", 20);
		User userB = new User("userB", 22);

		List<User> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);

		Map<String, User> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);

		model.addAttribute("user", userA);
		model.addAttribute("users", list);
		model.addAttribute("userMap", map);

		return "/basic/variable";
	}

	/**
	 * 스프링 부트 3.0 미만 기본 객체 사용 가능
	 */
	@GetMapping("/basic-objects")
	public String basicObjects(HttpSession session) {
		session.setAttribute("sessionData", "Hello Session");

		return "basic/basic-objects";
	}

	/**
	 * 스프링 부트 3.0 이상 기본 객체 사용 불가능
	 * 직접 model에 해당 객체를 추가해서 사용해야 함
	 */
	/*
	@GetMapping("/basic-objects")
	public String basicObjects(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		session.setAttribute("sessionData", "Hello Session");
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		model.addAttribute("servletContext", request.getServletContext());

		return "basic/basic-objects";
	}
	*/
	@GetMapping("/date")
	public String date(Model model) {
		model.addAttribute("localDateTime", LocalDateTime.now());

		return "basic/date";
	}

	@GetMapping("/link")
	public String link(Model model) {
		model.addAttribute("param1", "data1");
		model.addAttribute("param2", "data2");

		return "basic/link";
	}

	@GetMapping("/literal")
	public String literal(Model model) {
		model.addAttribute("data", "Spring!");

		return "basic/literal";
	}

	/**
	 * Sample data
	 */
	@Data
	static class User {
		private String username;
		private int age;

		public User(String username, int age) {
			this.username = username;
			this.age = age;
		}
	}

	@Component("helloBean")
	static class HelloBean {

		public String hello(String data) {
			return "Hello " + data;
		}
	}

}
