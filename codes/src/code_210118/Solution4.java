package code_210118;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//4.스택수열
/*
수열은 1부터~N까지
n크기만큼 배열a (n=8이고 a=4,3,6,8,7,5,2,1 입력)
배열a와 스택값 비교하여 st.peek()이 a값과 같을 때 하나씩 빼주고(겹치는건빼고 - pop) -처리하여 ans에 넣고
나머지는 +처리해서 ans에 넣음

*/
public class Solution4 {

	public static void main(String[] args) throws Exception {
		int num = 1; // 수열: 1~N
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<String> ans = new ArrayList<String>();

		int[] a = new int[n + 1];// 0을 사용하지 않기 떄문에 1부터.
		int m = 1;

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt(); // a = [4,3,6,8,7,5,2,1]
		}
		for (int i = 1; i <= n; i++) { // (ex) n=8이면 st = [1,2,3,4,5,6,7,8]에서 a와 같은 값을 스택에서빼기
			st.push(i);
			ans.add("+");
			// 같은 정수가 두번나올때 (겹치면) 삭제
			while (!st.isEmpty() && st.peek() == a[m]) { // st.peek()이 a[1]이면
//				System.out.println("a[m]="+a[m]+"그리고 st.peek()="+st.peek());
				st.pop();
				ans.add("-");
				m++;
				System.out.println("st=" + st);
			}
		}

		if (st.isEmpty()) {
			for (String s : ans) {
				System.out.println(s);
			}
		} else {
			System.out.println("NO");
		}
	}
}
