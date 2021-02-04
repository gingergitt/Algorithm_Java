package code6;

import java.util.Arrays;

public class Solution10_1 {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int left = 0;
		int right = people.length - 1;

		while (left != right && left < right) {
			int weight = people[right];
			for (int i = left; i < right; i++) {
				weight += people[i];
				if (weight == limit) {
					left = i + 1;
					right--;
					answer++;
					break;
				} else if (weight > limit) {
					left = i;
					right--;
					answer++;
					break;
				} else {
					if (i == right - 1) {
						// 마지막까지 더했는데도 limit보다 작으면
						left = i;
						right--;
					}
				}
			}
		}

		return left == right ? answer + 1 : answer;
	}
}
