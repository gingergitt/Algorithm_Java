package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 5. ��Ʈ�λ��̵�
public class Ex5 {

	public static void main(String[] args) throws Exception {

		String N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 2143 -> 4321 (��������) 
		//String���� �Է¹޾� �ѱ��ھ� �ڸ���, int ��ȯ�Ͽ� �迭�� �ֱ�
		// 1���ھ� �ڸ��� parseInt
		N = br.readLine();
		int[] arr = new int[N.length()];
		for (int i = 0; i < N.length(); i++) {
			arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));

		}

		System.out.println("�ɰ��� �迭��=" + Arrays.toString(arr));
		// sort�� ��������ʰ� ���
		System.out.println("--����ϱ�--");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // arr[0] < arr[1] �̸�
					int temp = arr[i]; // temp�� arr[0]�ְ�
					arr[i] = arr[j]; // arr[1]���� arr[0]�� �ְ�(�Ǿ�����)
					arr[j] = temp; // arr[1]�ڸ��� temp�� �ִ´�.(arr[0]���� �ڷ�) -> ��������
				}
			}

		}

		// ���������� ���
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
