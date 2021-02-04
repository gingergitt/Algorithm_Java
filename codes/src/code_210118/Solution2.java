package code_210118;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	/*
	 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000) 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서
	 * 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다. 정수가
	 * "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
	 * 
	 * 재민이가 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 231-1보다 작거나 같은 정수이다.
	 * 
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		int cnt=0;
		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {
			int input = sc.nextInt();
			//0일 경우 빼주고, 맨 위의 값 삭제
			if (input == 0) {
				st.pop();
//				System.out.println("0");
			} else if (input != 0) {
				st.push(input);
				
//				System.out.println(input);
			}
			

		}
	
		//st에 값이 남아있을 경우, 남은 값들을 하나씩 빼서 cnt에 넣어주기
		while(!st.isEmpty()) {
			cnt += st.pop();
			
		}
		System.out.println("최종 합="+cnt);

	}
}
