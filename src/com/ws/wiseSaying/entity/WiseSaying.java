package com.ws.wiseSaying.entity;

public class WiseSaying {//와이즈세잉 클래스 명언의 관련된 정보들의 객체를 만들기 위해서
	private int id;//객체의 번호를 저장할 공간 사용자가 입력한
	private String content;//만든 객체의 명언을 저장할 공간
	private String author;//만든 객체의 작가를 저장할 공간

	public WiseSaying(int id, String content, String author) {
		//생성자 어디선가 와이즈세잉 객체를 만나면 인자로 받은 매개변수를 활용해 필드에 접근하기위해
		this.id = id;//매개변수를 필드에 전달
		this.content = content;//매개변수를 필드에 전달
		this.author = author;//매개변수를 필드에 전달
	}

	public int getId() {
		return id;//접근제한이 있는 아이디의 값을 반환하기 위해
	}

	public void setId(int id) {
		this.id = id;//접근제한 필드에 전달받은 값을 넣어주기 위해
	}

	public String getContent() {
		return content;//접근제한 필드에 값을 반환하기위해
	}

	public void setContent(String content) {
		this.content = content;//접근제한 필드에 전달받은 값을 넣어주기 위해
	}

	public String getAuthor() {
		return author;//접근제한 필드에 값을 반환하기위해
	}

	public void setAuthor(String author) {
		this.author = author;//접근제한 필드에 전달받은 값을 넣어주기 위해
	}

}