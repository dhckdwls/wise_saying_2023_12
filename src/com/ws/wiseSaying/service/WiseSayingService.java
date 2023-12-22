package com.ws.wiseSaying.service;

import java.util.List;

import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.repository.WiseSayingRepository;

public class WiseSayingService {//서비스를 제공하기 위해 만들어진 클래스

	private WiseSayingRepository wiseSayingRepository; //데이터를 저장및 관리하는 리포지터리와 연결될 변수 리포지터리 생성

	public WiseSayingService() {//서비스 생성자 서비스를 객체화 했을때 리포지터리라는 객체화된 변수를 전달해 주기 위해서

		wiseSayingRepository = new WiseSayingRepository();
	}

	public List<WiseSaying> findAll() {
		//객체들의 리스트들을 찾기 위해서
		//
		return wiseSayingRepository.findAll();
	}

	public int write(String content, String author) {

		return wiseSayingRepository.write(content, author);
	}

	public WiseSaying findById(int id) {
		return wiseSayingRepository.findById(id);
	}

	public void remove(WiseSaying wiseSaying) {
		wiseSayingRepository.remove(wiseSaying);
	}

	public void modify(WiseSaying wiseSaying, String content, String author) {
		wiseSayingRepository.modify(wiseSaying, content, author);

	}

}