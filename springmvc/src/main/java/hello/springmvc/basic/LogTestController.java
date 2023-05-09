package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @Slf4j
@RestController
public class LogTestController {

	// 롬복을 사용하면 log 선언 없이 사용 가능
	private final Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/log-test")
	public String logTest() {
		String name = "spring";

		log.trace("trace log={}", name);
		log.debug("debug log={}", name);
		log.info("info log={}", name);
		log.warn("warn log={}", name);
		log.error("error log={}", name);

		// 로그를 사용하지 않아도 a + b 계산 로직이 먼저 실행됨(필요없는 연산이 진행), 이런 방식으로 사용하면 X
		// log.debug("String concat log=" + name);

		return "ok";
	}

}
