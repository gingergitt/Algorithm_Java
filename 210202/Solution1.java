package code6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//210201- 1. 모의고사
class Solution1 {

	public static void main(String[] args) {

		Solution1 sol = new Solution1();
		int[] ans = new int[5];
		sol.solution(ans);
		;
	}

	public int[] solution(int[] answer) {

//		int[] ans = { 1, 2, 3, 4, 5 };
		int[] ans = { 1, 3, 2, 4, 2 };
		System.out.println("answers=" + Arrays.toString(ans));
		// 수포자들이 찍는 방식들
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// 학생당 맞은 갯수 저장하기 { p1이맞은갯수, p2가 맞은갯수, p3가 맞은갯수 }
		int[] corrects = new int[3];

		// ans = {1,2,3,4,5};
		// 매칭돌리기
		// ans[0] = p1[0] 인지
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == p1[i % p1.length]) {
				corrects[0]++;
			}
			if (ans[i] == p2[i % p2.length]) {
				corrects[1]++;
			}
			if (ans[i] == p3[i % p3.length]) {
				corrects[2]++;
			}
		}

		// 가장 높은 점수 찾기
		int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));

		List<Integer> lists = new ArrayList<Integer>();


		// 가장 높은 점수를 받는 사람 찾기
		// i = 0,1,2
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
