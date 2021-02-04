package code6;

import java.util.Arrays;

// 9.단속카메라 
/*
 고속도로를 이동하는 차량의 경로 routes가 매개변수로 주어질 때, 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 
 최소 몇 대의 카메라를 설치해야 하는지를 return 하도록 solution 함수를 완성하세요.
 */
public class Solution9 {

	public static void main(String[] args) {
		
		int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println("routes="+Arrays.deepToString(routes));
		System.out.println("return="+solution(routes));
	}

	public static int solution(int[][] routes) {
		// 끝나는 시간 순 대로 오름차순 정렬
		Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
		int cnt = 0;

		int min = Integer.MIN_VALUE;
		for (int[] route : routes) {
			if (min < route[0]) {
				// 전 거의 끝나는 시간 보다 시작 시간이 큰 경우
				// 안 겹치니까 변경하고, 숫자 더하기
				min = route[1];
				++cnt;
			}
		}
		return cnt;
	}
}