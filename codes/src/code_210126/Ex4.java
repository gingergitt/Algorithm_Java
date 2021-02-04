package code_210126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 4. 통계학
/*
 * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이 N개의 수가 주어졌을 때, 네
 * 가지 기본 통계값을 구하는 프로그램을 작성하시오
 */
public class Ex4 {

	public static void main(String[] args) {

		int N;
		Scanner sc1 = new Scanner(System.in);
		int[] R;
		int[] Result = new int[4]; // 산술평균 중앙값 최빈값 범위
		int sum = 0;
		N = sc1.nextInt();
		R = new int[N];
		int[] idx = new int[8001]; // 인덱스의 카운트 :절대값 4000까지의 정수 저장 -> 음수포함 8000+1

		// 1. 산술평균 출력

		for (int i = 0; i < N; i++) {
			R[i] = sc1.nextInt();
			sum += R[i]; // R[0]+R[1]+...+R[4]
		}
		System.out.println("입력값은=" + Arrays.toString(R));

		// 2. 중앙값
		Arrays.sort(R);
		int res;
		int m = R.length / 2;
		res = R[m]; // 중앙값

		// 3. 최빈값 - 여러개일 경우 최빈값 중 두번째로 작은 값 출력
		int mode = 0; // 최빈값

		int max = Integer.MIN_VALUE; // 최대값을 저장하기 위한 변수
		ArrayList<Integer> arr2 = new ArrayList<>(); // 최빈값이 여러개일때를 위한 배열

		for (int x : R) {
			if (x < 0) {
				// 음수인경우 4000더해서 인덱스 ++
				idx[Math.abs(x) + 4000]++;
			} else
				idx[x]++;
		}

		for (int i = 0; i < idx.length; i++) {
			if (max < idx[i] && idx[i] != 0) {
				max = idx[i]; // max값
				mode = i; // 최빈값 = mode
			}
		}

		for (int i = 0; i < idx.length; i++) {
			int a = i;
			if (idx[i] == max) { // 카운트배열의 값들과 최빈값이 일치한다면
				if (i > 4000) { // 4000이상은 음수를 바꿔준것이므로 원래대로 바꿔주기(음수로)
					a -= 4000; // a = a-4000;
					a *= -1; // a = a*-1;
					arr2.add(a); // 최빈값 배열에 추가하기
				} else {
					arr2.add(i); // 나머지는 i값을 넣기
				}
			}
		} // 추가 된 최빈값들이 여러개 있을 경우, 오름차순으로 정렬 한 뒤에 2번째로 작은 값 가져온다.
		Collections.sort(arr2);
		System.out.println("최빈값들의배열을 오름차순으로=" + arr2);

		if (arr2.size() > 1) {
			mode = arr2.get(1);// 여러개 존재시 가장 작은숫자에서 두번째 숫자 반환하기
		} else {
			mode = arr2.get(0);// 그외의경우 그냥 최빈값 리턴
		}

		// 정리
		Result[0] = (int) Math.round((double) sum / N); // 1.산술평균
		Result[1] = res; // 중앙값
		Result[2] = mode;
		Result[3] = R[N - 1] - R[0]; // 범위
		System.out.println("----------출력 값 -----------");
		System.out.println("산술평균=" + Result[0]);
		System.out.println("중앙값=" + Result[1]);
		System.out.println("최빈값=" + Result[2]);
		System.out.println("범위=" + Result[3]);
	}
}
