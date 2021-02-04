package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//2. 수 정렬하기 2
public class Ex2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N;
		// Collections 사용을 위해 list 생성
		ArrayList<Integer> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());

		// 한줄씩 받아오기
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// Collections.sort 사용
		System.out.println("입력값은=" + list.toString());
		Collections.sort(list);
		System.out.println("list=" + list);

		System.out.println("--오름차순 출력--");
		for (int j : list) {
			System.out.println(j);
		}

	}
}
