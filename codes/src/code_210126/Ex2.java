package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//2. �� �����ϱ� 2
public class Ex2 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N;
		// Collections ����� ���� list ����
		ArrayList<Integer> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());

		// ���پ� �޾ƿ���
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}

		// Collections.sort ���
		System.out.println("�Է°���=" + list.toString());
		Collections.sort(list);
		System.out.println("list=" + list);

		System.out.println("--�������� ���--");
		for (int j : list) {
			System.out.println(j);
		}

	}
}
