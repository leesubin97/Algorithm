자료구조의 큐와 비교되는 형태로 LIFO ( Last In First Out ) 후입선출 의 구조를 가지고 있습니다.

그래프의 DFS( 깊이우선탐색 )에 사용
재귀적 함수 호출 시 사용


Stack 자료구조를 사용하기 전 import java.util.* 필수!
```
import java.util.*; 

```
Stack 선언
```
import java.util.*; 
```
```
Stack<Integer> stack = new Stack<>(); //int형 스택 선언
```

Stack 값 삽입
```
Stack<Integer> stack = new Stack<>(); // int형 스택 선언

stack.push(2);     // stack에 2 추가
stack.push(4);     // stack에 4 추가
stack.push(5);     // stack에 5 추가

// 2, 4, 5
```

 Stack 값 삭제
 ```
Stack<Integer> stack = new Stack<>(); 

stack.push(1);     // stack에 1 추가
stack.push(2);     // stack에 2 추가

stack.pop();       // stack에 맨 위의 값 제거
stack.clear();     // stack의 전체 값 제거 (초기화)
```

Stack의 맨 위 값 출력
```
Stack<Integer> stack = new Stack<>(); 
stack.push(1);     // stack에 1 추가
stack.push(2);     // stack에 2 추가

stack.peek();     // stack의 가장 상단의 값 출력 -> 2
```

기타
```
Stack<Integer> stack = new Stack<>();

stack.push(1);     // stack에 1 추가
stack.push(2);     // stack에 2 추가

stack.contains(5); // stack에 5가 있는지 확인 -> false
stack.size();      // stack의 크기 출력 : 2
stack.empty();     // stack이 비어있는지 확인 (비어있다면 true)
```
Stack 구현

```
package stack;

public class ArrayStack {
	
	private int top;
	private int maxSize;
	
	private Object stackArray[];
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new Object[maxSize];
		top = -1;
	}
	
	// 스택공간이 비어 있는지 
	public boolean isEmpty() {
		return (this.top == -1);
	}
	
	// 스택공간이 가득 차있는지 
	public boolean full() {
		return (this.top == maxSize-1);
	}
	
	// 추가
	public void push(Object item) {
		if(full()) {
			System.out.println("스택 공간이 가득 차 있습니다");
			return;
		}
		
		top++;
		stackArray[top] = item;
	}
	
	// 삭제
	public Object pop() {
		Object item = peek();
		top--;
		return item;
	}
	
	// 최상위에 데이터(공)
	public Object peek() {
		if(isEmpty()) {
			System.out.println("스택 공간이 비어 있습니다");
			return null;
		}
		
		return stackArray[top];
	}
	
	

}


```


java Stack 구현

 

java.util.Stack 클래스를 이용하여 스택을 구현 해 봅시다.

 

Stack은 마지막에 들어간 데이터가 가장 먼저 꺼내지는 LIFO (Last In First Out) 입니다.

 

아래 코드에서는 push 메서드를 이용해 스택 객체에 A, B, C 를 순서대로 넣고, 

 

pop 메서드를 이용해 하나씩 꺼내 볼 것입니다.

 

 

<코드>

 

import java.util.*;



public class StackTest {



    public static void main(String[] args) {

        Stack stk = new Stack();

        

        stk.push("A");

        stk.push("B");

        stk.push("C");

                

        System.out.println("## Stack");

        while(!stk.empty()) {

            System.out.println(stk.pop());

        }

    }



}
<결과>

 

## Stack

C

B

A
