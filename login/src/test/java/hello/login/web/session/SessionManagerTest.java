package hello.login.web.session;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import hello.login.domain.member.Member;

class SessionManagerTest {

	SessionManager sessionManager = new SessionManager();

	@Test
	void sessionTest() {

		// 세션 생성: Server to Client
		MockHttpServletResponse response = new MockHttpServletResponse();
		Member member = new Member();
		sessionManager.createSession(member, response);

		// 요청에 응답 쿠키 저장: Client to Server
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setCookies(response.getCookies());

		// 세션 조회: Server to Client
		Object result = sessionManager.getSession(request);
		assertThat(result).isEqualTo(member);

		// 세션 만료
		sessionManager.expire(request);
		Object expired = sessionManager.getSession(request);
		assertThat(expired).isNull();
	}

}
