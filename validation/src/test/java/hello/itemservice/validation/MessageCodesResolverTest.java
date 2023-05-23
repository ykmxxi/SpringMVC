package hello.itemservice.validation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

public class MessageCodesResolverTest {

	MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

	@DisplayName("Object Error")
	@Test
	void messageCodesResolverObject() {
		String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");

		assertThat(messageCodes).containsExactly("required.item", "required");
	}

	@DisplayName("Field Error")
	@Test
	void messageCodesResolverField() {
		String[] messageCodes = codesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

		assertThat(messageCodes).containsExactly(
			"required.item.itemName",
			"required.itemName",
			"required.java.lang.String",
			"required"
		);
	}

}
