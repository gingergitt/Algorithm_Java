package code_210121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//5. 우수마을
/* 1. 자신이 우수마을이라면, 자기 자신과 인접한 모든 노드는 우수 마을이 될 수 없으며, 
 자기 자신이 우수마을이 아니라면, 자신과 연결된 노드 중 적어도 하나는 우수 마을이 되어야 한다. 
 ** 로직
 1. 자기 자신이 우수 마을 일 때
-> 연결된 노드들은 모두 우수 마을이면 안 된다.
 2. 자기 자신이 우수 마을이 아닐 때
-> 연결된 노드는 우수 마을 일 수도, 우수 마을이 아닐 수도 있다. */
public class Prob5 {

	static int n;
	static int[] arr;
	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		System.out.println("입력: ");
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());

		dp = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		System.out.println("출력: " + Math.max(MaxVal(0, 1, 0), MaxVal(0, 1, 1)));
	}

	static int MaxVal(int prev, int now, int state) {
		if (dp[now][state] != -1)
			return dp[now][state];
		dp[now][state] = 0;

		int res = 0;
		// 부모가 우수마을이 아니라면 자식 중 하나는 우수마을이어야 함
		if (state == 0) {
			for (int next : list[now]) {
				if (next == prev)
					continue;
				res += Math.max(MaxVal(now, next, 0), MaxVal(now, next, 1));
			}
		} else {// 부모가 우수마을이라면 자식은 우수마을일 수 없음
			res = arr[now];
			for (int next : list[now]) {
				if (next == prev)
					continue;
				
				res += MaxVal(now, next, 0);
			}
		}
		return dp[now][state] = res;
	}

}
