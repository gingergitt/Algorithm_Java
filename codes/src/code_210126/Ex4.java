package code_210126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 4. �����
/*
 * 1. ������ : N���� ������ ���� N���� ���� �� 2. �߾Ӱ� : N���� ������ �����ϴ� ������ �������� ��� �� �߾ӿ� ��ġ�ϴ� ��
 * 3. �ֺ� : N���� ���� �� ���� ���� ��Ÿ���� �� 4. ���� : N���� ���� �� �ִ񰪰� �ּڰ��� ���� N���� ���� �־����� ��, ��
 * ���� �⺻ ��谪�� ���ϴ� ���α׷��� �ۼ��Ͻÿ�
 */
public class Ex4 {

	public static void main(String[] args) {

		int N;
		Scanner sc1 = new Scanner(System.in);
		int[] R;
		int[] Result = new int[4]; // ������ �߾Ӱ� �ֺ� ����
		int sum = 0;
		N = sc1.nextInt();
		R = new int[N];
		int[] idx = new int[8001]; // �ε����� ī��Ʈ :���밪 4000������ ���� ���� -> �������� 8000+1

		// 1. ������ ���

		for (int i = 0; i < N; i++) {
			R[i] = sc1.nextInt();
			sum += R[i]; // R[0]+R[1]+...+R[4]
		}
		System.out.println("�Է°���=" + Arrays.toString(R));

		// 2. �߾Ӱ�
		Arrays.sort(R);
		int res;
		int m = R.length / 2;
		res = R[m]; // �߾Ӱ�

		// 3. �ֺ� - �������� ��� �ֺ� �� �ι�°�� ���� �� ���
		int mode = 0; // �ֺ�

		int max = Integer.MIN_VALUE; // �ִ밪�� �����ϱ� ���� ����
		ArrayList<Integer> arr2 = new ArrayList<>(); // �ֺ��� �������϶��� ���� �迭

		for (int x : R) {
			if (x < 0) {
				// �����ΰ�� 4000���ؼ� �ε��� ++
				idx[Math.abs(x) + 4000]++;
			} else
				idx[x]++;
		}

		for (int i = 0; i < idx.length; i++) {
			if (max < idx[i] && idx[i] != 0) {
				max = idx[i]; // max��
				mode = i; // �ֺ� = mode
			}
		}

		for (int i = 0; i < idx.length; i++) {
			int a = i;
			if (idx[i] == max) { // ī��Ʈ�迭�� ����� �ֺ��� ��ġ�Ѵٸ�
				if (i > 4000) { // 4000�̻��� ������ �ٲ��ذ��̹Ƿ� ������� �ٲ��ֱ�(������)
					a -= 4000; // a = a-4000;
					a *= -1; // a = a*-1;
					arr2.add(a); // �ֺ� �迭�� �߰��ϱ�
				} else {
					arr2.add(i); // �������� i���� �ֱ�
				}
			}
		} // �߰� �� �ֺ󰪵��� ������ ���� ���, ������������ ���� �� �ڿ� 2��°�� ���� �� �����´�.
		Collections.sort(arr2);
		System.out.println("�ֺ󰪵��ǹ迭�� ������������=" + arr2);

		if (arr2.size() > 1) {
			mode = arr2.get(1);// ������ ����� ���� �������ڿ��� �ι�° ���� ��ȯ�ϱ�
		} else {
			mode = arr2.get(0);// �׿��ǰ�� �׳� �ֺ� ����
		}

		// ����
		Result[0] = (int) Math.round((double) sum / N); // 1.������
		Result[1] = res; // �߾Ӱ�
		Result[2] = mode;
		Result[3] = R[N - 1] - R[0]; // ����
		System.out.println("----------��� �� -----------");
		System.out.println("������=" + Result[0]);
		System.out.println("�߾Ӱ�=" + Result[1]);
		System.out.println("�ֺ�=" + Result[2]);
		System.out.println("����=" + Result[3]);
	}
}
