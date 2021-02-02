package code6;

import java.util.Arrays;

//��Ʈ�� �θ� Ż �� �ִٴ� ���� ����Ʈ. (�ִ�x�ּ��� ¦)
/*
 �� ������ �ᱹ ��Ʈ�� �θ� Ż �� �ִٴ� ���� ����Ʈ�̴�!
 �׸��� �ƹ��� �Ѿ� ¦���� �¿�� ���� �ƴϴ�! '�ִ� + �ּ�' �� ¦�� �Ǿ�� �Ѵ�.
���࿡ �ִ� ���Ը� ���� ����� �ּ� ���Ը� ���� ����̶� ¦�� �̷� ����Ʈ�� Ÿ�� ���Ѵٸ� �� ����� ������ ȥ�� Ÿ���Ѵ�!
�� ����� �̿��ϸ� O(n^2) ���⵵�� �� �ּ�ȭ�� �� �ִ�.
Ǯ���� �ݺ����� ����, ������������ ������ �ؼ� �ּ� ���Դ� �ε��� 0���� ��������, 
�ִ� ���Դ� people.length - 1���� ������������ ������ �Ѵ�.
�׷��� �ε����� �� �ڷ� �ؼ� �񱳸� �Ѵ�. 

 */
public class Solution10 {

	public static void main(String[] args) {

		int[] people = { 70, 50, 80, 50 };
		int[] people2 = { 70, 80, 50 };
		int limit = 100;
		System.out.println("people  limit return");
		System.out.println("-------------------------------");
		System.out.println(Arrays.toString(people)+" "+limit+" "+solution(people, limit));
		System.out.println(Arrays.toString(people2)+" "+limit+" "+solution(people2, limit));
		
	}

	public static int solution(int[] people, int limit) {
		Arrays.sort(people); // �ϴ� ������� ����
//		System.out.println("�����ϸ�->"+Arrays.toString(people));

		int answer = 0;
		int idx = people.length - 1;
		for (int i = 0; i <= idx; i++, answer++) {
			while (idx > i && people[i] + people[idx--] > limit) {
				answer++;
			}
		}
		

		return answer;
	}
}
