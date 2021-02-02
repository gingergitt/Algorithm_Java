package code6;

import java.util.Arrays;
/* ����� �ڵ� */
public class Solution10_ref {
	public static void main(String[] args) {

		int[] people = { 70, 50, 80, 50 };
		int limit = 100;
		System.out.println("people  limit return");
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(people) + " " + limit + " " + solution(people, limit));

	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		/*
		 * (1) ���� �־��� �迭�� ������ �Ѵ�. 
		 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 kg �� ������� ����ϰ��ְ�, 
		 ����Ʈ�� Limit�� 100kg�̶�� ���� �� 100kg�� ����� ȥ��Ÿ�� �������� 100kg�� �� ä���� Ÿ�°�
		  ���� ���� ����Ʈ�� ����ϴ� ����̴�. ���� ���, 80kg�� ����� 10kg�� ����� �Բ�Ÿ�� ������,
		   �׷� 90kg, 100kg�� ����� ȥ��Ÿ�� �ϹǷ� ����Ʈ�� ����ϴ� Ƚ���� �����ϰ� �ȴ�.
		 */
		Arrays.sort(people); // ����

		//�迭�� �糡��
		int i = 0;
		int j = people.length - 1; 
		
		//�迭�� �糡���� limit ���� �۰ų� ������
		while (i < j) {
			if (people[i] + people[j] <= limit) {
				i++;
			}
			j--;
			answer++;
		}

		if (i == j) {
			answer++;
		}

		return answer;
	}
}
