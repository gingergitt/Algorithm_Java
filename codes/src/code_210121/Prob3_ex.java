package codeT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//3. 트리의 독립 집합
/*
  동적 프로그래밍 또는 동적 계획법은 주어진 문제를 세분화하여 최적의 해법을 찾아내는 방법이다.
  이는 중복된 부분을 줄이고 불필요한 요소를 배제함으로써 연산의 효율을 높일 수 있다
 */
public class Prob3_ex {

	static int N;
	static int W[];
	static int dp[][];

	static class Pair {
		int node;
		int t;

		public Pair(int node, int t) {
			super();
			this.node = node;
			this.t = t;
		}
	}

	static ArrayList<Integer> edge[];
	static ArrayList<Pair> p[][];
	static ArrayList<Integer> ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// ---------------------Input------------------------
		N = Integer.parseInt(br.readLine());
		W = new int[N + 1];
		dp = new int[2][N + 1];
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++)
			W[i] = Integer.parseInt(st.nextToken());

		edge = new ArrayList[N + 1];
		p = new ArrayList[N + 1][2];

		// 0 은 false 1 은 true
		for (int n = 1; n <= N; n++) {
			edge[n] = new ArrayList<Integer>();
			p[n][0] = new ArrayList<Pair>();
			p[n][1] = new ArrayList<Pair>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edge[u].add(v);
			edge[v].add(u);
		}

		// ---------------------------------------------

		int start = Solve();
		// start로 시작해서 ans에 답리스트를 채우기
		ans = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();

		sb.append(getValue(1, start)).append('\n');
		Collections.sort(ans);
		for (int n : ans) {
			sb.append(n).append(' ');
		}
		System.out.print(sb.toString());
	}

	public static int getValue(int n, int t) {
		int sum = 0;
		if (t == 1) {
			ans.add(n);
			sum = W[n];
		}
		for (Pair next : p[n][t]) {
			sum += getValue(next.node, next.t);
		}

		return sum;
	}

	static boolean visit[];

	public static int Solve() {
		Arrays.fill(dp[0], -1);
		Arrays.fill(dp[1], -1);
		visit = new boolean[N + 1];
		if (dfs(1, true) > dfs(1, false)) {
			return 1;
		} else {
			return 0;
		}

	}

	public static int dfs(int n, boolean t) {
		int tt = t ? 1 : 0;
		if (dp[tt][n] != -1) {
			return dp[tt][n];
		}
		int sum = t ? W[n] : 0;

		visit[n] = true;

		if (t) {
			// that t is true is next node only pick false
			for (int next : edge[n]) {
				if (visit[next])
					continue;
				p[n][tt].add(new Pair(next, 0));
				sum += dfs(next, false);
			}
		} else {
			// that t is false is next node pick true or false
			for (int next : edge[n]) {
				if (visit[next])
					continue;
				if (dfs(next, false) > dfs(next, true)) {
					p[n][tt].add(new Pair(next, 0));
					sum += dfs(next, false);
				} else {
					p[n][tt].add(new Pair(next, 1));
					sum += dfs(next, true);
				}

			}

		}

		visit[n] = false;
		return dp[tt][n] = sum;

	}
}
