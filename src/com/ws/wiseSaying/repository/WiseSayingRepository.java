package com.ws.wiseSaying.repository;

import java.util.ArrayList;
import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;

public class WiseSayingRepository {

	private int lastWiseSayingId;
	
	private List<WiseSaying> wiseSayings;

	public WiseSayingRepository() {

		lastWiseSayingId = 0;
		wiseSayings = new ArrayList<>();
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayings.remove(wiseSaying);
	}

	public WiseSaying findById(int id) {
		//명언객체의 번호를 찾기 위해서 만들었다
		for (WiseSaying wiseSaying : wiseSayings) {
			//명언객체타입의 변수를 만들고 그게 명언객체를 순회한다
			if (wiseSaying.getId() == id) {
				//그 몀언객체의 번호가 아이디와 같다면
				return wiseSaying;// 이 명언 객체를 반환하겠다
			}
		}

		return null;//하지만 그런 객체를 찾지 못했으면 그런 객체는 없다 그래서 null을 반환 왜 참조 타입이니까
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSaying.setContent(content);//수정 wisesaying 타입의 객체와 연결된 wisesaying 그리고 문자열타입의 명언 문자열 타입의 작가를 인자로받고 매개변수를 사용해서 객체에 넣는중
		wiseSaying.setAuthor(author);
	}

	public int write(String content, String author) {
		int id = lastWiseSayingId + 1;

		WiseSaying wiseSaying = new WiseSaying(id, content, author);
		wiseSayings.add(wiseSaying);

		lastWiseSayingId = id; // 방금 전에 새 명언이 생겼으니, lastWiseSayingId의 값을 갱신

		return id;
	}

	public List<WiseSaying> findAll() {
		//명언객체를 반환
		return wiseSayings;
	}

}