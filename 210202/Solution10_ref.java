package code6;

import java.util.Arrays;
/* 참고용 코드 */
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
		 * (1) 먼저 주어진 배열을 정렬을 한다. 
		 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 kg 인 사람들이 대기하고있고, 
		 구명보트의 Limit가 100kg이라고 했을 때 100kg인 사람은 혼자타고 나머지는 100kg를 꽉 채워서 타는게
		  가장 적게 구명보트를 사용하는 방법이다. 예를 들어, 80kg인 사람과 10kg인 사람이 함께타도 되지만,
		   그럼 90kg, 100kg인 사람은 혼자타야 하므로 구명보트를 사용하는 횟수가 증가하게 된다.
		 */
		Arrays.sort(people); // 정렬

		//배열의 양끝값
		int i = 0;
		int j = people.length - 1; 
		
		//배열의 양끝값이 limit 보다 작거나 같으면
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
