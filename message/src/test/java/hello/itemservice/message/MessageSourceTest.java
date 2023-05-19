package hello.itemservice.message;

import static org.assertj.core.api.Assertions.*;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageSourceTest {

	@Autowired
	MessageSource ms;

	@DisplayName("Locale 없는 경우 기본 메시지")
	@Test
	void helloMessage() {
		String result = ms.getMessage("hello", null, null);

		assertThat(result).isEqualTo("안녕");
	}

	@DisplayName("메시지가 없는 경우: NoSuchMessageException")
	@Test
	void notFoundMessageCode() {
		assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
			.isInstanceOf(NoSuchMessageException.class);
	}

	@DisplayName("메시지가 없는 경우: 기본 메시지")
	@Test
	void notFoundMessageCodeDefault() {
		String defaultMessage = "기본 메시지";
		String result = ms.getMessage("no_code", null, defaultMessage, null);

		assertThat(result).isEqualTo(defaultMessage);
	}

	@DisplayName("매개변수 사용: Object 배열 사용")
	@Test
	void argumentMessage() {
		String result = ms.getMessage("hello.name", new Object[] {"Spring"}, null);

		assertThat(result).isEqualTo("안녕 Spring");
	}

	@DisplayName("국제화 파일 선택 1: 기본값, 한국")
	@Test
	void defaultLang() {
		assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
		assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
	}

	@DisplayName("국제화 파일 선택2: 영어")
	@Test
	void enLang() {
		assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
	}

}
