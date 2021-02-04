package code_210121;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//2. 트리와 쿼리
public class Porb2 {
	//트리를 만들면서 배열에 자신의 서브노드 개수를 기록한다..?
	static int n,r,q ;
	static int[] dp;
	static ArrayList<ArrayList<Integer>> trees;
	
	public static void main(String[] args) throws IOException {
		//정점이 n개일때, n-1개의 간선이 존재함
		trees = new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		n=Integer.parseInt(st.nextToken());
		r=Integer.parseInt(st.nextToken());
		q=Integer.parseInt(st.nextToken());
		
		dp= new int[n+1];
		
		for(int i=0; i<=n; i++) {
			trees.add(new ArrayList<>());
		}

		//트리 간선 만들기
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			trees.get(u).add(v);
			trees.get(v).add(u);
		}
		
		//트리만들기
		makeTree(r,-1);
		
		StringBuilder sb  = new StringBuilder();
		for(int i=0; i<q; i++) {
			int u = Integer.parseInt(br.readLine());
			sb.append(dp[u]).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

	 static int makeTree(int cur, int parent) {

		//dp[cur]이 0이 아니면 연결된 노드이므로
		if(dp[cur]!=0) {
			return dp[cur];
		}
		dp[cur]=1;
		
		for(int child: trees.get(cur)) {
			//부모와 자식이 같으면 안됨 //사이클은 x 부모는 무조건 하나
			
			if(parent != child) {
				dp[cur] += makeTree(child,cur) ;
				
			}
		}
		return dp[cur];
	}
	
}
