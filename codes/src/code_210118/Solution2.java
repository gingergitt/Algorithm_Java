package code_210118;

import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
	/*
	 * ù ��° �ٿ� ���� K�� �־�����. (1 �� K �� 100,000) ���� K���� �ٿ� ������ 1���� �־�����. ������ 0����
	 * 1,000,000 ������ ���� ������, ������ "0" �� ��쿡�� ���� �ֱٿ� �� ���� �����, �ƴ� ��� �ش� ���� ����. ������
	 * "0"�� ��쿡 ���� �� �ִ� ���� ������ ������ �� �ִ�.
	 * 
	 * ����̰� ���������� ���� �� ���� ���� ����Ѵ�. ���������� ��� ���� ���� 231-1���� �۰ų� ���� �����̴�.
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
			//0�� ��� ���ְ�, �� ���� �� ����
			if (input == 0) {
				st.pop();
//				System.out.println("0");
			} else if (input != 0) {
				st.push(input);
				
//				System.out.println(input);
			}
			

		}
	
		//st�� ���� �������� ���, ���� ������ �ϳ��� ���� cnt�� �־��ֱ�
		while(!st.isEmpty()) {
			cnt += st.pop();
			
		}
		System.out.println("���� ��="+cnt);

	}
}
