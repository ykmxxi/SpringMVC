package hello.servlet.web.frontcontroller.v1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿과 비슷한 모양의 컨트롤러 인터페이스
 * 각 컨트롤러가 이 인터페이스를 구현
 * 프론트 컨트롤러는 이 인터페이스를 호출: 로직의 일관성
 */
public interface ControllerV1 {

	void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
