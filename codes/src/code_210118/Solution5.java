package code_210118;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// 5.ê· í˜•?¡?Œ ?„¸?ƒ
public class Solution5 {


	public static void main(String[] args) {

		Stack<Character> st = new Stack<>();
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();

		// ë¬¸ì?—´ ?…? ¥ë°›ê¸°
		String[] sen = { "So when I die (the [first] I will see in (heaven) is a score list).",
				"[ first in ] ( first out ).", "Half Moon tonight (At least it is better than no Moon at all].",
				"A rope may form )( a trail in a maze.", "Help( I[m being held prisoner in a fortune cookie factory)].",
				"([ (([( [ ] ) ( ) (( ))] )) ]).", " .", "." };



		char[] cc = new char[sen.length];
		char tmp = '0';
		loop: for (int i = 0; i < sen.length; i++) {
			// sen?„ charë¡? ìª¼ê°œê¸?

			for (int j = 0; j < sen[i].length(); j++) {
				char a = sen[i].charAt(j);
//				System.out.println("a="+a);
				

				if (a == '(') {
					st.push('(');
				} else if (a == ')') {
					if (st.contains('(') && !st.isEmpty())
						tmp = st.pop();
					if (tmp == ')') {
						st.push(')');
						st.push(')');
					}
				} else if (a == '[') {
					st.push('[');
				} else if (a == ']') {
					if (st.contains('[') && !st.isEmpty())
						tmp = st.pop();
					if (tmp == ']') {
						st.push(']');
						st.push(']');

					}
				} else if (sen[i].length() == 1) {
					break loop;

				}

			}
			System.out.println(sen[i]);
			//
//			System.out.println("st="+st);
			if (st.isEmpty()) {
				System.out.println("YES");
			} else if (!st.isEmpty()) {
				System.out.println("NO");
			}
			st.clear();
		}
	}
}
