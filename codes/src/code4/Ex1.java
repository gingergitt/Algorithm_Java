package code4;

import java.util.Arrays;
import java.util.Scanner;

// 210125
//1. �� �����ϱ� 1

// 1) ���� ���� N �Է¹ޱ�
// 2) line���� N���� �ٿ� ���� �Է¹ޱ� (�ߺ�x)
// 3) ù°�ٺ��� ������������ �����Ͽ� ���ٿ� �ϳ��� ���

public class Ex1 {
	static int N;
	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		Scanner sc1 = new Scanner(System.in);
		int[] R;

		N = sc1.nextInt();
		R = new int[N];

		for (int i = 0; i < N; i++) {
			R[i] = sc1.nextInt();
		}
		System.out.println("�Է°���=" + Arrays.toString(R));
//		Arrays.sort(R);
//
//		System.out.println("--�������� ���--");
//		for (int j : R) {
//			System.out.println(j);
//		}
		
		//sort�� ��������ʰ� ���
		System.out.println("--sort����������ʰ� ����ϱ�--");
		for(int k=0; k<R.length; k++) {
			for(int i=0; i<R.length; i++) {
				if(R[k]<R[i]) {
					int temp = R[k];
					R[k] = R[i];
					R[i] = temp;
				}
			}
			
		}

		//���������� ���
		for(int i=0; i<R.length; i++) {
			System.out.println(R[i]+" ");
		}
		System.out.println();
		
		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
		long secDiffTime = (afterTime - beforeTime); // �� �ð��� �� ���
		System.out.println("�ð�����(ms) : " + secDiffTime + "ms");
	}
}
