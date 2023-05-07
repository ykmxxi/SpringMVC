package hello.servlet.web.frontcontroller.v5;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;

public interface MyHandlerAdapter {

	/**
	 * 어댑터가 해당 컨트롤러를 처리할 수 있는지 판단하는 메서드
	 * @param handler, 컨트롤러
	 * @return 처리할 수 있으면 true, 없으면 false
	 */
	boolean supports(Object handler);

	/**
	 * 해당 어댑터가 실제 컨트롤러를 호출하고 그 결과로 ModelView 반환
	 * @param request, 클라이언트 요청
	 * @param response, 요청에 대한 응답
	 * @param handler, 컨트롤러
	 * @return ModelView
	 * @throws ServletException
	 * @throws IOException
	 */
	ModelView handler(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
