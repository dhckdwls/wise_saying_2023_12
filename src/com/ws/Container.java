package com.ws;

import java.util.Scanner;

public class Container {//모든 클래스에서 공공재로 사용될 데이터들을 관리하기 위해
	private static Scanner sc;//접근제한자 타입의 스캐너 타입의 변수 sc를 만들어 놓는다

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {// 이 메서드를 실행하면 접근제한자 sc에 스캐너 객체를 객체화 해서 연결해준다 
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {// 무한정 입력받는 상태를 만들면 오류가 날 수 있기에 스캐너에 사용이 종료됫을때 사용하기 위한 메서드
		sc.close();
	}

	public static Scanner getScanner() {//컨테이너 필드에 있는 스캐너는 접근제한자가 붙어있기 때문에 sc에 접근하고 그 sc를 재활용할수있게 값을 반환해준다
		return sc;//sc를 남겨주기위해
	}
}