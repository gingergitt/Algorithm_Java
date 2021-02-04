package code4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 4. 통계학 - counting sort
/*
 * 1. 산술평균 : N개의 수들의 합을 N으로 나눈 값 2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 3. 최빈값 : N개의 수들 중 가장 많이 나타나는 값 4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이 N개의 수가 주어졌을 때, 네
 * 가지 기본 통계값을 구하는 프로그램을 작성하시오
 */
public class Ex4_ex {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		int[] countArr = new int[8001];
		for (int n : arr) {
			countArr[n + 4000]++;
		}
		// arr[]와 countArr[]를 통해 ansArr를 만든다.
		int[] ansArr = new int[N];

		int tempMax = 0;
		int temp = 0;
		int idx = 0;

		for (int i = 0; i < countArr.length; i++) {
			temp = countArr[i];
			if (temp > 0) {
				if (temp > tempMax) {
					tempMax = temp;
				}

				while (temp > 0) {
					ansArr[idx] = i - 4000;
					temp--;
					idx++;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		int most;
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] == tempMax) {
				list.add(i - 4000);
			}
		}

		if (list.size() > 1) {
			most = list.get(1);
		} else {
			most = list.get(0);
		}

		bw.write((int) Math.round((double) sum / N) + "\n"); // 산술평균
		bw.write(ansArr[ansArr.length / 2] + "\n"); // 중앙값
		bw.write(most + "\n"); // 최빈값
		bw.write(ansArr[ansArr.length - 1] - ansArr[0] + "\n"); // 범위

		bw.flush();
	}
}
