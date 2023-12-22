package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App { //main 메서드에서 app을 실행시키기 위해 만들어준 클래스

	private byte system_status = 1;//와일 반복문의 조건을 항상 참으로 만들어주기 위해

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");//app().run()을 실행했을때 처음으로 출력되는 문자 실행됬음을 알려주기위해

		SystemController systemController = new SystemController();//시스템컨트롤러로와 연결될 변수를 만들고 시스템컨트롤러를 바탕으로 만든 객체와연결
		WiseSayingController wiseSayingController = new WiseSayingController();
		//와이즈세잉컨트롤러와 연결될 변수를 만들고 그안에 와이즈세잉컨트롤러를 바탕으로한 객체 생성

		while (system_status == 1) {//반복문 안에있는 내용을 반복하기 위해 조건을 시스템스테이터스가 1일때
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();
			//문자열 타입의 변수 cmd를 만들고 그 안에 컨테이너에 있는 겟스캐너메서드를 실행 그안에 있는 sc로 입력을 받고 입력받은 문자열의 앞뒤공백을 없앰
			Rq rq = new Rq(cmd);
			//위에서 만든 cmd를 인자로 넣은 rq타입의 rq변수를 만들어 준다 그리고 존재하지 않는 클래스 Rq를 생성
			switch (rq.getActionCode()) {
			//스위치 반복문 rq에 있는 겟액션코드 메서드의 반환값을 토대로 스위치 반복문을 돌릴 예정
			//입력된 명령어를 조건에 맞게 선별하고 다시 다음 명령어를 받기 위해
			case "종료":
				//종료를 만날때
				systemController.exit();
				//시스템컨트롤러의 엑시트메서드 호출 
				system_status = 0;
				//시스템 스테이터스를 0으로 바꿔주고 브레이크를 만나 스위치문을 탈출한다 탈출하고 나니 스테이터스가 0 이므로 와일반복문에서 조건이 false가 되서 와일 반복문도 탈출
				break;
			case "등록"://입력받은 명령어가 등록일때
				wiseSayingController.write();
				//명령어를 받고 이 명령어를 와이즈세잉컨트롤러에 전달 
				break;
			case "목록":
				wiseSayingController.list();
				//목록~~이라는 명령어를 받으면 이 명령어를 시행하는 와이즈세잉컨트롤러에 전달 그리고 와이즈세잉컨트롤러는 리스트 메서드 실행
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				//입력받은 명령어가 올바른 명령어 삭제인지 판단고 이게 맞다면 컨트롤러에 있는 제거에게 명령을 하달하기 위해
				break;//여기서 멈추고 스위치문을 탈출 그 후 와일반복문 다시 진행
			case "수정"://입력받은 명령어가 수정인지 확인 하고 수정이 맞다면 이를 컨트롤러에게 전해주기 위해
				wiseSayingController.modify(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");//사용자가 올바르지못한 명령어를 입력했을때 다른 명령어를 입력받기 위해
				break;
			}
		}

	}
}