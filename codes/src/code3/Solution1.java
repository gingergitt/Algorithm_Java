package code3;

import java.util.Scanner;
import java.util.Stack;

public class Solution1 {


	// 구현할 스택 
	public static void main(String[] args) {

		//입력받기
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		
		//N번만큼 실행
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			String input = sc.next();
			if(input.contains("push")) {
				int input2 = sc.nextInt();
				st.push(input2);
			}else if (input.contains("pop")) {
				if(st.size()==0) {
					System.out.println("-1");
				} else {
					int del = st.pop();
					System.out.println(del);
				}
			}else if(input.contains("size")) {
				System.out.println(st.size());
			}else if(input.contains("empty")) {
				if(st.size()==0) {
					System.out.println("1");
				} else  {
					System.out.println("0");
				}
			}else if(input.contains("top")) {
				if(st.size()!=0) {
					
					System.out.println(st.peek());
				}else {
					System.out.println("-1");
				}
				
			}
			
		}

	}

	
}
