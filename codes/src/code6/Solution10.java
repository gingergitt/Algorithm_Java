package code6;

import java.util.Arrays;

//보트에 두명만 탈 수 있다는 것이 포인트. (최대x최소의 짝)
/*
 이 문제는 결국 보트에 두명만 탈 수 있다는 것이 포인트이다!
 그리고 아무나 둘씩 짝지어 태우는 것이 아니다! '최대 + 최소' 가 짝이 되어야 한다.
만약에 최대 무게를 가진 사람이 최소 무게를 가진 사람이랑 짝을 이루어도 구명보트를 타지 못한다면 그 사람은 무조건 혼자 타야한다!
이 방법을 이용하면 O(n^2) 복잡도를 더 최소화할 수 있다.
풀이의 반복문을 보면, 오름차순으로 정렬을 해서 최소 무게는 인덱스 0부터 오름차순, 
최대 무게는 people.length - 1부터 내림차순으로 접근을 한다.
그래서 인덱스를 앞 뒤로 해서 비교를 한다. 

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
		Arrays.sort(people); // 일단 사람들을 정렬
//		System.out.println("정렬하면->"+Arrays.toString(people));

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
