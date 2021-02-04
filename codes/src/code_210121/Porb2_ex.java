package codeT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//2. 트리와 쿼리
public class Porb2_ex {
	/*
	 * 순서 1) 엣지 연결정보 입력 순서 2) 트리 만들기 순서 3) 탐색
	 */
	static int N, R, Q;
	static int[] edge;
	static ArrayList<ArrayList<Integer>> tree; // 2차원

	public static void main(String[] args) throws IOException {
		// 정점(노드) n개, n-1개의 간선

		tree = new ArrayList<>();

		// 값 입력, 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// br로 입력값을 한줄 씩 읽어온 다음, 그 한줄씩 N, R, Q에 저장한다.
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		edge = new int[N+1]; //왜 전역으로 미리 선언하면 안되는지?

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
			// i=0이고 N=5면 , 0,1,2,3,4,5 -> 6개의 배열을 tree안에 넣기
			// tree = [ [x,x],[x,x],[x,x],[x,x],[x,x],[x,x] ]
			
		}
		// 트리 간선 만들기
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			// U, V = (1,3) (4,3), (5,4) ...
			tree.get(U).add(V);
			System.out.println("1번="+tree.get(U));
			tree.get(V).add(U);
			System.out.println("2번="+tree.get(V));
			System.out.println("트리는="+tree);
		}

		// 트리 탐색하기
		findTree(R,-1);
		StringBuilder sb= new StringBuilder();
		for(int i=0; i<Q; i++) {
			int U = Integer.parseInt(br.readLine());
			System.out.println("U="+U);
			sb.append(edge[U]).append("\n");
			System.out.println("edge="+Arrays.toString(edge));
			System.out.println("append="+edge[U]);
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	//
	//이전값, 현재값 (= 부모값, 다음값)

	static int findTree(int prev, int cur) {

		//dp[cur]이 0이 아니면 연결된 노드이므로
		if(edge[prev]!=0) {
			return edge[prev];
		}
		edge[prev]=1;
		
		for(int child: tree.get(prev)) {
			//부모와 자식이 같으면 안됨 //사이클은 x 부모는 무조건 하나
			
			if(cur != child) {
				edge[prev] += findTree(child,prev) ;
				
			}
		}
		return edge[prev];
	}
}
