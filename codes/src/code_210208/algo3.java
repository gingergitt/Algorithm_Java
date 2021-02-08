package code_210208;

import java.util.Arrays;
//3. 등굣길
public class algo3 {

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };
		System.out.println("m=" + m + " n=" + n + " puddles" + Arrays.deepToString(puddles));
		System.out.println("return=" + solution(3, 4, new int[][] { { 2, 2 } }));
	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		int[][] road = new int[n][m];

		// puddles만큼 돌면서 road배열의 위치값을 -1로 초기화
		for (int i = 0; i < puddles.length; i++) {
			road[puddles[i][1]][puddles[i][0]] = -1;
		}
		road[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (road[i][j] == -1) {
					road[i][j] = 0;
					continue;
				}
				if (i != 0) {
					road[i][j] += road[i - 1][j] % 1000000007;
				}
				if (j != 0) {
					road[i][j] += road[i][j - 1] % 1000000007;
				}
			}
			answer = road[n - 1][m - 1] % 1000000007;
//	        	return answer;

		}

		return answer;
	}
}
