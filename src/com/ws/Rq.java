package com.ws;

import java.util.HashMap;
import java.util.Map;

// Rq == Request(요청)
public class Rq {
	private String actionCode;//접근제한자 타입의 문자열 변수 액션코드라는 공간만 만들어놓음
	private Map<String, String> params;//접근제한자 타입의 맵타입의 파람스라는 변수를 만들어 놓음;

	public Rq(String cmd) {
		//Rq의 생성자 이면서 cmd를 인자로 받음 매개변수가 된 cmd를 활용
		String[] cmdBits = cmd.split("\\?", 2);
		//문자열객체와 연결될 cmdbit 변수 생성 그 안에 매개변수 cmd를 ?를 기준으로 2조각으로 나눈다

		actionCode = cmdBits[0];
		//나뉘어진 조각중 첫번째 조각을 액션코드에 집어넣는다

		params = new HashMap<>();
		//필드에 생성해 놓은 파람스에 해쉬맵을 객체화 시켜 집어넣는다

		if (cmdBits.length == 1) {
			return;
			//2조각으로 나누어서 cmdbits에 넣엇지만 조각이 한개일 경우 그대로 메서드를 종료 시키기 위해
		}

		String[] paramBits = cmdBits[1].split("&");
		//문자열 타입과 연결될 변수 파람빗츠를 만들고 여기에 cmd빗츠에들어간 두번째 조각을 &를 기준으로 또 나누어 준다
		for (String paramStr : paramBits) {
			//순회 반복문 파람열이 파람비츠를 순회하는 동안
			String[] paramStrBits = paramStr.split("=", 2);
			//문자열 타입 파람빗츠를 만들고 파람열을 =을 기준으로 두조각으로 나눈다
			if (paramStrBits.length == 1) {
				continue;
				//=을 기준으로 나눈 조각이 한조각일때 조건문의 컨디션체크부분으로 돌아간다
				
			}

			String key = paramStrBits[0];//해쉬맵에 저장할 키값으로 첫번째 조각을 사용하기 위해
			String value = paramStrBits[1];//해쉬맵에 저장할 키값으로 두번째 조각을 사용하기 위해
			params.put(key, value);
		}

	}

	public String getActionCode() {
		return actionCode;//생성자에서 전달받은 명령어를 액션코드에 넣어주엇고 그 값을 다시 app에 돌려줘야 하기 때문에
	}

	public String getParam(String name) {
		return params.get(name);//파람이라는 맵형태의 객체에서 키를 통해 가져온 밸류를 반환하기 위해 이는 아이디 번호
	}

	public int getIntParam(String name, int defaultValue) {
		try {//키값을 통한 name = id 인데 id의 벨류값인 숫자모양의 문자들을 정수형으로 바꾸기 위해

			return Integer.parseInt(getParam(name));
			//시도 했는데 잘 됏다면 받은 벨류를 정수형으로 형변환
		} catch (NumberFormatException e) {
			//실패 했을때 아무것도 실행하지 않는다 이유는 여기서 return 디폴트벨류를 해도 try문을 나가면 또 디폴트벨류를 리턴해준다 어차피 둘다 같은값을 리턴하기에 
			//여기서 만나든 저기서 만나든 코드에 중복도 막고 리턴이 두번쓰이는 이상한 상황도 방지
		}
		return defaultValue;
		//인자로 받은 -1을 디폴트벨류에 저장하고 이 값을 반환
	}
	
	public int getIntParam(String name) {
		try {
			return Integer.parseInt(getParam(name));
		}catch(NumberFormatException e) {
		}
		return -1;
	}
}