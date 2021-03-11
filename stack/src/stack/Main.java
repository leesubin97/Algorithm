package stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	//입력 받을 T개의 테스트 데이터
		
	//입력의 첫번째 줄에 나타나는 입력 데이터의 개수
	int T = sc.nextInt();
	
	
	
	
	while(T-- > 0) {
		//에게 받은 랜덤괄호
		String comPeek = sc.next();
		System.out.println( vpsShow(comPeek));
		
		}
}//main

public static String vpsShow(String comPut) {
	Stack<Character> stack = new Stack<Character>();
	// Stack을 Character로 선언하여
	// Stack은 Character 객체만 다루게 되게 함.
	
		/*
		 * 문제 이해후 함수 제작시 필요한 정리
		 
		 * 1. 문제에서 설명되었듯이 ( , )
		 * 괄호가 짝이 맞아야 VPS 이외의 문자열은 
		 * VPS가 아니다
		 * 예시: (() 는 VPS가 아니다
		 * 
		 * 
		 * 2. 괄호들을 스택에 다 넣고 괄호들이 짝이 다 맞으면
		 * 스택공간이 비워져있게 코드 짜기
		 *
		 * 3. 스택에 괄호들이 남으면 VPS가 아니다
		 *
		 * 4. 닫는 괄호들이 많아도 VPS가 아니다
		 * 
		 * 
		 * 5. 스택에는 여는 괄호만 들어가고 닫는괄호가 잇을시 여는괄호를 pop한다
		 *
		 */
	
	for (int i = 0; i < comPut.length(); i++) {
		
		char c = comPut.charAt(i);//문자 출력
		
		//괄호가 여는괄호 ( 일경우
		if(c == '(') {
			stack.push(c);
		}
		
		//스택이 비어있을때 )닫는괄호가 있으면 여는괄호가 부족한 상황임으로
		// VPS가 아님 고로 NO 출력
		else if(stack.isEmpty()) {
			return "NO";
		}else {
			stack.pop();
		}
		
	
		
	}//for
	
	if(stack.isEmpty()) {
		return "YES";
	}else {
		return "NO";
	}
	
	
}

}



