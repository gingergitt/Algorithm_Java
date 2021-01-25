package codes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class code4 {
	/*
	 * str1 = france이면 일단 toLowercase 정렬 후 두글자씩 나눠 배열로 저장하고, 이때, 예외처리 (특수문자,공백,숫자가
	 * 들어있는 경우 그 글자 쌍을 버린다 -> 그 인덱스를 버린다.) str1, str2를 같은방식으로 배열로 저장하고 , 교집합과 합집합을
	 * 구해야한다. (중복허용) --> List --
	 * 
	 * 교집합크기(size) / 합집합크기 = 자카드유사도 로 구한다음, 65536곱하고 소수점아래버린다.
	 */

	public static int clustering(String str1, String str2) {
		int answer = 0;
//		List<String> str11 = new ArrayList<String>();
//		List<String> str22 = new ArrayList<String>();
//		for (int i = 0; i < str1.length(); i++) {
//			if (i + 2 <= str1.length()) {
//				str11.add(str1.substring(i, i + 2));
//				System.out.println(str11); // str11=[fr,ra,an,nc,ce]
//			}
//		}
//		for (int i = 0; i < str2.length(); i++) {
//			if (i + 2 <= str2.length()) {
//				str22.add(str2.substring(i, i + 2));
//				System.out.println(str22); // str11=[fr,ra,an,nc,ce]
//			}
//		}
//		System.out.println("합집합" + new Code4().union(str11, str22));

		return answer;
	}



	
	
	public <T> List<T> intersection(List<T> str11, List<T> str22) {
		List<T> list = new ArrayList<T>();

		for (T t : str11) {
			if (str22.contains(t)) {
				list.add(t);
				//-----
				
			}
		}

		return list;
	}

	public static void main(String[] args) {
		
		
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";
		
		str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
     
		System.out.println("str1="+str1+" str2="+str2);
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
				//String temp = first+""+second;
				
				//--
				 
			}

		}
		
		
		
		System.out.println(str22); // str11=[fr,ra,an,nc,ce]

		System.out.println("교집합" + new code4().intersection(str11, str22));
//		System.out.println("합집합" + new Code4().union(str11, str22));
		System.out.println(new code4().intersection(str11, str22).size());
		//double unisize = new Code4().union(str11, str22).size();
		double intersize = new code4().intersection(str11, str22).size();
		//합집합
		double union = str11.size()+str22.size() - intersize;
		System.out.println(union);
		System.out.println(Math.floor(intersize/union*65536));
		
		//--------------------------test case 4번 해결 하기
		
		int answer = 0;
		if(union == 0 ) {
			 answer=65536;
		}else {
			 answer =(int) Math.floor(intersize/union)*65536;
		}
//		

		 System.out.println(Math.floor(intersize/union)*65536);
		
		System.out.println("answer is= "+ answer);
	}

}
