package codeT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//5. 우수마을
/* 1. 자신이 우수마을이라면, 자기 자신과 인접한 모든 노드는 우수 마을이 될 수 없으며, 
 자기 자신이 우수마을이 아니라면, 자신과 연결된 노드 중 적어도 하나는 우수 마을이 되어야 한다. 
 ** 로직
 1. 자기 자신이 우수 마을 일 때
-> 연결된 노드들은 모두 우수 마을이면 안 된다.
 2. 자기 자신이 우수 마을이 아닐 때
-> 연결된 노드는 우수 마을 일 수도, 우수 마을이 아닐 수도 있다. */
public class Prob5_ex {

	static int n;
	static int[] arr;
	static int[][] dp;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		System.out.println("입력: ");
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		dp = new int[n + 1][2];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}

		dfs(1, -1);
		
		bw.write(String.valueOf(Math.max(dp[1][0], dp[1][1])));
		bw.close();
		br.close();

//		System.out.println("출력: " + Math.max(MaxVal(0, 1, 0), MaxVal(0, 1, 1)));
	}

	static void dfs(int cur, int parent) {
		for (int child : list.get(cur)) {
			if (child != parent) {
				dfs(child, cur);
				dp[cur][1] += dp[child][0];
				dp[cur][0] += Math.max(dp[child][0], dp[child][1]);
			}
		}
		dp[cur][1] += arr[cur];
	}

}
