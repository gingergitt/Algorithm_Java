package code4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//7. 단어정렬
public class Ex7_ex1 {
	
	public static void main(String[] args) throws Exception {
		// 1.문자열을 배열로 받아서, 1)길이가 짧은 것부터, 2) 길이가 같을 경우 사전순으로, 3)그리고 중복제거
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] sen = new String[N+1];
		String[] txt1; String[] txt2;
		int size=0;
		for(int i=0; i<N; i++) {
			sen[i]=br.readLine();
			sen[i] = sen[i].toLowerCase();
		
		}
//		System.out.println("문자열 배열="+Arrays.toString(sen));
		//1. 힙트리 생성
		
		for(int i=1; i< sen.length; i++) {
			int c= i; //현재노드
			while( c>0 ) {
				int p = (c-1) /2; //부모노드
				if(compare_txt(sen[p], sen[i]) == 1) {
					//부모노드가 작을 경우
					swap(sen,p,i);
					c=p;
					continue;
				}
			}
		}
		
	
		
	}

	

	private static int compare_txt(String sen, String sen2) {
		return 0;
	}



	public static void swap(String[] sen, int p, int i) {
		// TODO Auto-generated method stub
		
	}

	
}
