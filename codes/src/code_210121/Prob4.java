package code_210121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//4. 사회망 서비스(SNS) - TreeDP이용 문제
/*
 만약 x라는 사람이 얼리어답터가 아니라면, x의 친구들은 모두 얼리어답터여야 한다.
 그러나 x라는 사람이 얼리어답터라면, x의 친구들은 얼리어답터여야 할 수도, 아닐 수도 있다. 
 그러면, dp[x][0]을 x가 얼리어답터가 아닐 때 최소 얼리어답터의 수, dp[x][1]을 x가 얼리어답터일때 
 최소 얼리어답터의 수라고 정의하고 트리를 순회해야한다. 
 트리는 사이클 형태가 아니기 때문에 어느 정점을 시작으로 해도 양방향으로 연결을 해놨기 때문에 모든 노드에 접근이 가능하고,
 이러한 관점이라면 모든 정점이 루트가 될 수 있다. 
 
 가장 쉽게 1을 루트라고 가정하고, 1이 얼리어답터일때, 얼리어답터가 아닐 때 2가지 케이스로 나눠서 확인해주자.
[  위에서 말한 로직처럼 이전이 얼리어답터라면, 현재는 얼리어답터여야 할수도, 아닐수도 있고, 
 이전이 얼리어답터가 아니라면 , 현재는 반드시 얼리어답터여야 한다. ]
 
 그리고 로직 설계가 1을 root라고 가정하고 리프노드로 내려가는 구조이다. 
 
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

public class Prob4 {

	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		// Scanner 쓸 경우 용량초과, bufferreader가져오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // 쪼개기

		// n값 입력받기
		int n = Integer.parseInt(br.readLine());
		// n+1 배열을 list에 담기
		list = new ArrayList[n + 1]; // ? 왜 n+1?
//		System.out.println("list="+Arrays.toString(list));
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
//			System.out.println("list[i]="+list[i]);
		}

		for (int j = 0; j < n - 1; j++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			System.out.println("u= " + u + "and v= " + v);
			list[u].add(v);
			list[v].add(u);
//			System.out.println("list[u]= "+list[u]+"and list[v]= "+list[v]);

		}

		dp = new int[n + 1][2];
//		System.out.println("dp= "+Arrays.deepToString(dp));

		System.out.println("얼리어답터 최소수=" + Math.min(MinVal(0, 1, 0), MinVal(0, 1, 1)));
	}

	//int prev, int cur, int state의미 : 
	static int MinVal(int prev, int cur, int state) {
		if (dp[cur][state] != 0)
			return dp[cur][state];
		int res = 0;

		// B. 만약 현재 cur가 얼리어답터가 아닐 때
		//state == 0 ?? 
		if (state == 0) {
			// foreach loop -> for(type var: iterate)
			// iterate는 루프를 돌릴 객체이고 iterate객체에서 한개씩 순차적으로 var에 대입되어
			// for문 수행 / iterate형태는 loop를 돌릴 수 있는 형태인 배열 및 ArrayLsit등이 가능.
			// 즉, list[cur]배열이 한개씩 순차적으로 next에 대입된다.
			// 배열을 여러번 호출하지않고 한번만 접근하는 효율적인 방법
			for (int next : list[cur]) { // 자식들은 반드시 얼리어답터여야 한다.
//				System.out.println(Arrays.deepToString(list));
				if (prev == next) {
					System.out.println("prev= " + prev);
					continue;
				}
				res += MinVal(cur,next,1);
				System.out.println("res = "+res);
			}
			// A. 현재 cur가 얼리어답터일때
		} else {
			res = 1;
			for (int next : list[cur]) {
				if (prev == next)
					continue;
				res += Math.min(MinVal(cur, next, 0), MinVal(cur, next, 1));
			}
		}
		return dp[cur][state] = res;
	}

}
