package code6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//210201- 1. 모의고사
class Solution1 {

	public static void main(String[] args) {

		Solution1 sol = new Solution1();

		int[][] ansArr = { { 1, 3, 2, 4, 2 }, { 1, 2, 3, 4, 5 } };
		for (int i = 0; i < 2; i++) {
			System.out.println("answers=" + Arrays.toString(ansArr[i]));
			sol.solution(ansArr[i]);
			System.out.println("-------------");
		}

	}

	public int[] solution(int[] answers) {
		int[] ans = {};

		// 수포자들이 찍는 방식들 (반복 패턴)
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
	
		// 학생당 맞은 갯수 저장하기 { p1이맞은갯수, p2가 맞은갯수, p3가 맞은갯수 }
		int[] corrects = new int[3];

		// answers = {1,2,3,4,5}, {1,3,2,4,2}
		// 매칭돌리기
		// ans[0] = p1[0] 인지
		// 찍은 문제가 맞았는지 한문제씩 확인
		for (int i = 0; i < answers.length; i++) {
			if (p1[i % p1.length]== answers[i]) {
				corrects[0]++;
			}
			if (p2[i % p2.length]== answers[i]) {
				corrects[1]++;
			}
			if (p3[i % p3.length]== answers[i]) {
				corrects[2]++;
			}
		}
		// 가장 높은 점수 찾기 (가장 많이 맞은 사람 찾기)
		int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));
		List<Integer> lists = new ArrayList<>();
		
		//max값이 같은 경우를 == 로 비교해주면 max값을 정답수로 갖는 사람을 골라낼 수 있다.
		//가장 많이 맞은 문제수가 max니까
		if (max == corrects[0]) {
			lists.add(1);
		}
		if (max == corrects[1]) {
			lists.add(2);
		}
		if (max == corrects[2]) {
			lists.add(3);
		}
		ans = new int[lists.size()];
		for (int j = 0; j < lists.size(); j++) {
			ans[j] = lists.get(j);
		}
		System.out.println("return=" + Arrays.toString(ans));

		return ans;
	}

}
