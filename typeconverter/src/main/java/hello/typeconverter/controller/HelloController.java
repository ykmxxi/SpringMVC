package hello.typeconverter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.typeconverter.type.IpPort;

@RestController
public class HelloController {

	@GetMapping("/hello-v1")
	public String helloV1(HttpServletRequest request) {
		String data = request.getParameter("data"); // 요청 파라미터는 문자 타입으로 조회
		Integer intValue = Integer.valueOf(data); // 요청 파라미터를 숫자 타입으로 변환

		System.out.println("intValue = " + intValue);
		return "ok";
	}

	@GetMapping("/hello-v2")
	public String helloV1(@RequestParam Integer data) {
		System.out.println("data = " + data);

		return "ok";
	}

	@GetMapping("/ip-port")
	public String ipPort(@RequestParam IpPort ipPort) {
		System.out.println("Ip = " + ipPort.getIp());
		System.out.println("Port = " + ipPort.getPort());

		return "ok";
	}

}
