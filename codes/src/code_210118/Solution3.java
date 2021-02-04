package code_210118;

import java.util.Scanner;
import java.util.Stack;

//3. 괄호
public class Solution3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		char f1 = '(';
		char s2 = ')';

		int T = 0;
		char tmp = '0';
		T = Integer.parseInt(sc.nextLine());
		// T갯수만큼 입력받기
		String[] vps = new String[T];
		
		
		for (int j = 0; j < T; j++) {
			vps[j] = sc.nextLine();
			for (int i = 0; i < vps[j].length(); i++) {
				// '('일 때 st.push("(") ,
				// ')'이면 tmp = st.pop();
				char p = vps[j].charAt(i);
				if (p == f1) {
					st.push(f1);
				} else if (p == s2) {
					char tmp2 ='0';
					if(!st.isEmpty())
						tmp2 = st.pop();
					if (tmp2 != f1) {
						st.push(s2);
						st.push(s2);
					}
				}
				
			}
			System.out.println("st="+st);
			if (st.isEmpty()) {
				System.out.println("YES");
			} else if (!st.isEmpty()) {
				System.out.println("NO");				
			}
			st.clear();
			
		}

	}
}
