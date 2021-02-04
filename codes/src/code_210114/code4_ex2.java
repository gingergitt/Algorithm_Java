package code_210114;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code4_ex2 {

	// 교집합
	public <T> List<T> intersection(List<T> str11, List<T> str22) {
		List<T> list = new ArrayList<T>();

		for (T t : str11) {
			if (str22.contains(t)) {
				list.add(t);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// str 11,22를 배열로 받아보면?

//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";

		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		ArrayList<String> newsword = new ArrayList<String>();
		// str = [ str11, str22, str33, str44 ,, ] ;

		System.out.println("str1=" + str1 + " str2=" + str2);
		List<String> str11 = new ArrayList<String>();
		List<String> str22 = new ArrayList<String>();
		for (int i = 0; i < str1.length() - 1; i++) {
			char first = str1.charAt(i);
			char second = str1.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {

				str11.add(first + "" + second);
			}

		}
		System.out.println(str11); // str11=[fr,ra,an,nc,ce]
		for (int i = 0; i < str2.length() - 1; i++) {
			char first = str2.charAt(i);
			char second = str2.charAt(i + 1);

			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				str22.add(first + "" + second);
				// String temp = first+""+second;

				// --

			}

		}

		System.out.println(str22); // str11=[fr,ra,an,nc,ce]

		System.out.println("교집합" + new code4_ex2().intersection(str11, str22));
//		System.out.println("합집합" + new Code4().union(str11, str22));
		System.out.println(new code4_ex2().intersection(str11, str22).size());
		// double unisize = new Code4().union(str11, str22).size();
		double intersize = new code4_ex2().intersection(str11, str22).size();
		// 합집합
		double union = str11.size() + str22.size() - intersize;
		System.out.println(union);
		System.out.println(Math.floor(intersize / union * 65536));

		// --------------------------test case 4번 해결 하기

		int answer = 0;
		if (union == 0) {
			answer = 65536;
		} else {
			answer = (int) Math.floor(intersize / union) * 65536;
		}
//		

		System.out.println(Math.floor(intersize / union) * 65536);

		System.out.println("answer is= " + answer);
	}

}
