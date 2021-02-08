package code_210208;

import java.util.Arrays;
// 4. 도둑질
public class algo4 {

	public static void main(String[] args) {
		int[] money = { 1, 2, 3, 1 };
		int ans = solution(money);
		System.out.println("money="+Arrays.toString(money)+" "+"return="+ans);
	}

	public static int solution(int[] money) {
		int ans = 0;

		int[] dp1 = new int[money.length - 1]; // 처음집~마지막진x
		int[] dp2 = new int[money.length]; // 두번째집 ~ 마지막집

		// dp[0][n] = > 첫번째 집을 털었을 때 부터 마지막 집을 털지 않았을 때 최댓값
		// dp[1][n] => 두번째 집을 털었을 때 부터 마지막 집을 털었을 때의 최댓값 구한 후 비교

		dp1[0] = money[0];
		dp1[1] = money[0];
		dp2[0] = 0;
		dp2[1] = money[1];

		for (int i = 2; i < dp1.length; i++) {
			dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
		}

		for (int i = 2; i < dp2.length; i++) {
			dp2[i] = Math.max(dp2[i - 2] + money[i], dp2[i - 1]);
		}
		//dp1과dp2의 마지막 인뎃스 값을 비교해 max값을 가져온다. 
		ans = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
		return ans;
 
	}
}
