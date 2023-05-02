package hello.servlet.basic;

/*
  JSON 형식으로 파싱할 수 있게 객체를 생성
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloData {

	private String username;
	private int age;
}
