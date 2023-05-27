package hello.login;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hello.login.domain.item.Item;
import hello.login.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestDataInit {

	private final ItemRepository itemRepository;

	/**
	 * 테스트용 데이터 추가
	 */
	@PostConstruct
	public void init() {
		itemRepository.save(new Item("itemA", 10000, 10));
		itemRepository.save(new Item("itemB", 20000, 20));
	}

}
