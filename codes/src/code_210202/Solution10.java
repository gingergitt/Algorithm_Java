package code_210202;
// 10. 구명보트
import java.util.Arrays;

//최솟값+최대값이 limit보다 작거나 같아야 두명이서 탈 수 있고, 아닌경우에는 혼자 탄다. 

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
		Arrays.sort(people); // 일단 사람들을 정렬
//		System.out.println("정렬하면->"+Arrays.toString(people));

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
