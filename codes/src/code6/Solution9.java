package code6;

import java.util.Arrays;

// 9.�ܼ�ī�޶� 
/*
 ��ӵ��θ� �̵��ϴ� ������ ��� routes�� �Ű������� �־��� ��, ��� ������ �� ���� �ܼӿ� ī�޶� �������� �Ϸ��� 
 �ּ� �� ���� ī�޶� ��ġ�ؾ� �ϴ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 */
public class Solution9 {

	public static void main(String[] args) {
		
		int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println("routes="+Arrays.deepToString(routes));
		System.out.println("return="+solution(routes));
	}

	public static int solution(int[][] routes) {
		// ������ �ð� �� ��� �������� ����
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
		int cnt = 0;

		int min = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (min < route[0]) {
				// �� ���� ������ �ð� ���� ���� �ð��� ū ���
				// �� ��ġ�ϱ� �����ϰ�, ���� ���ϱ�
				min = route[1];
				++cnt;
			}
		}
		return cnt;
	}
}