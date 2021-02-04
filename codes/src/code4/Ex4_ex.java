package code4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 4. ����� - counting sort
/*
 * 1. ������ : N���� ������ ���� N���� ���� �� 2. �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
 * 3. �ֺ� : N���� ���� �� ���� ���� ��Ÿ���� �� 4. ���� : N���� ���� �� �ִ񰪰� �ּڰ��� ���� N���� ���� �־����� ��, ��
 * ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
 */
public class Ex4_ex {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		int[] countArr = new int[8001];
		for (int n : arr) {
			countArr[n + 4000]++;
		}
		// arr[]�� countArr[]�� ���� ansArr�� �����.
		int[] ansArr = new int[N];

		int tempMax = 0;
		int temp = 0;
		int idx = 0;

		for (int i = 0; i < countArr.length; i++) {
			temp = countArr[i];
			if (temp > 0) {
				if (temp > tempMax) {
					tempMax = temp;
				}

				while (temp > 0) {
					ansArr[idx] = i - 4000;
					temp--;
					idx++;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		int most;
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] == tempMax) {
				list.add(i - 4000);
			}
		}

		if (list.size() > 1) {
			most = list.get(1);
		} else {
			most = list.get(0);
		}

		bw.write((int) Math.round((double) sum / N) + "\n"); // ������
		bw.write(ansArr[ansArr.length / 2] + "\n"); // �߾Ӱ�
		bw.write(most + "\n"); // �ֺ�
		bw.write(ansArr[ansArr.length - 1] - ansArr[0] + "\n"); // ����

		bw.flush();
	}
}
