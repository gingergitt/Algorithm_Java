package code_210208;

import java.util.Arrays;
// 4. ������
public class algo4 {

	public static void main(String[] args) {
		int[] money = { 1, 2, 3, 1 };
		int ans = solution(money);
		System.out.println("money="+Arrays.toString(money)+" "+"return="+ans);
	}

	public static int solution(int[] money) {
		int ans = 0;

		int[] dp1 = new int[money.length - 1]; // ó����~��������x
		int[] dp2 = new int[money.length]; // �ι�°�� ~ ��������

		// dp[0][n] = > ù��° ���� �о��� �� ���� ������ ���� ���� �ʾ��� �� �ִ�
		// dp[1][n] => �ι�° ���� �о��� �� ���� ������ ���� �о��� ���� �ִ� ���� �� ��

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
		//dp1��dp2�� ������ �ε��� ���� ���� max���� �����´�. 
		ans = Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
		return ans;
 
	}
}
