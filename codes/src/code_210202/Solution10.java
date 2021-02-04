package code_210202;
// 10. ����Ʈ
import java.util.Arrays;

//�ּڰ�+�ִ밪�� limit���� �۰ų� ���ƾ� �θ��̼� Ż �� �ְ�, �ƴѰ�쿡�� ȥ�� ź��. 

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
		int min=0;

		for (int max = people.length - 1; min <= max; max--) {
			if (people[min] + people[max] <= limit)
				min++;
			answer++;
		}


		return answer;
	}
}
