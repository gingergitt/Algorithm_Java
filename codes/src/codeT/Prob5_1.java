package codeT;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Prob5_1 {
	static int n, u, v, a[] = new int[10001], dp[][] = new int[10001][2];
	static String ins[];
	static ArrayList<Integer>[] g = new ArrayList[10001];
	static boolean visited[] = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		ins = br.readLine().split(" ");
		System.out.println("ins= "+Arrays.toString(ins));

		long ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += a[i] = Integer.parseInt(ins[i - 1]);
			System.out.println("ans= "+ans);					
			g[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++)
			for (int j = 0; j < 2; j++)
				dp[i][j] = -1;

		for (int i = 1; i < n; i++) {
			ins = br.readLine().split(" ");
			System.out.println("ins2= "+Arrays.toString(ins));
			//ins = [1,2],[2,3],[4,3],[4,5],[6,2],[6,7]
			u = Integer.parseInt(ins[0]); //u= 1,2,4,4,6,6
			v = Integer.parseInt(ins[1]);//v= 2,3,3,5,2,7
			g[u].add(v);
			g[v].add(u);
			System.out.println("g[u]="+g[u]);
			System.out.println("g[v]="+g[v]);
		}
		int p = dp(1, 1, 1);
		Arrays.fill(visited, false);
		int q = dp(1, 0, 1);
		System.out.println("p="+p+"q"+q);
		
		bw.write(Math.max(p, q) + "\n");
		bw.flush();
		bw.close();
	}

	public static int dp(int v, int b, int prev) {
		if (dp[v][b] != -1)
			return dp[v][b];
		visited[v] = true;
		dp[v][b] = (b == 1) ? a[v] : 0;
		for (int i = 0; i < g[v].size(); i++) {
			int next = g[v].get(i);
			if (next != prev)
				dp[v][b] += (b == 1) ? dp(next, 0, v) : Math.max(dp(next, 0, v), dp(next, 1, v));
		}
		return dp[v][b];
	}
}
