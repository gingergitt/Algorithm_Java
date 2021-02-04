package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//3. �� �����ϱ� 3
public class Ex3 {

	public static void main(String[] args) throws Exception {
		
		// 1<= N <= 10,000,000 �̹Ƿ� BufferedReader��� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� 10,000���� �۰ų� ���� �ڿ���
		int[] R = new int[10001];
		// N �Է¹ޱ�
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			R[Integer.parseInt(br.readLine())]++;
		}
		br.close();
//		System.out.println("�Է°���=" + Arrays.toString(R));

		StringBuilder sb = new StringBuilder();
		// sort�� ��������ʰ� ���
		System.out.println("--�������� ���--");
		for (int k = 1; k < 10001; k++) {
			while (R[k] > 0) {
				sb.append(k).append('\n');
				R[k]--;
		
			}

		}
		System.out.println(sb);

	}
}
