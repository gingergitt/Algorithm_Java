package codeT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//4. 사회망 서비스(SNS) - TreeDP이용 문제
/*
 *** 로직 정리 
 cur은 부모노드, next는 자식노드로 정의한다.
 	A. cur가 얼리어답터일 때
 	우선 cur가 얼리어답터가 확정이므로, 현재 얼리어답터 수에 +1을 해준다.
 	그리고 자식은 두가지 상태를 가질 수 있다. (자식은 얼리어답터일수도, 아닐수도 있음)
 		1) next가 얼리어답터가 아닐 때의 최소 얼리어답터 수 
 		2) next가 얼리어답터일 때의 최소 얼리어답터 수
 	두가지 상태에 대해 최소 얼리어답터 수를 부모 쪽에 더해주면 된다. 
 	B. cur가 얼리어답터가 아닐 때 (자식은 모두 얼리어답터어야만 함!)
 	cur가 얼리어답터가 아니므로, 자식들은 모두 얼리어답터여야 한다. 
 	따라서 cur의 자식들이 모두 얼리어답터일 때의 최소 얼리어답터의 수를 리턴해준다. 
 */

public class Prob4_ex {

	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		// Scanner 쓸 경우 용량초과, bufferreader가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 쪼개기
		
		System.out.print("입력: ");
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1]; // ? 왜 n+1?
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int j = 0; j < n - 1; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);

		}

		dp = new int[n + 1][2];

		System.out.println("최소 얼리어답터 수= "+Math.min(go(0, 1, 0), go(0, 1, 1)));
		
	}

	static int go(int prev, int cur, int state) {
		if (dp[cur][state] != 0)
			return dp[cur][state];
		int res = 0;

		// B. 만약 현재 cur가 얼리어답터가 아닐 때
		//state == 0 ?? 
		if (state == 0) {
			for (int next : list[cur]) { // 자식들은 반드시 얼리어답터여야 한다.
				if (prev == next) {
					continue;
				}
				res += go(cur,next,1);
			}
			// A. 현재 cur가 얼리어답터일때
		} else {
			res = 1;
			for (int next : list[cur]) {
				if (prev == next)
					continue;
				res += Math.min(go(cur, next, 0), go(cur, next, 1));
			}
		}
		
		return dp[cur][state] = res;
	}

}
