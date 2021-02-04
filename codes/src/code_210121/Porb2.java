package code_210121;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//2. Ʈ���� ����
public class Porb2 {
	//Ʈ���� ����鼭 �迭�� �ڽ��� ������ ������ ����Ѵ�..?
	static int n,r,q ;
	static int[] dp;
	static ArrayList<ArrayList<Integer>> trees;
	
	public static void main(String[] args) throws IOException {
		//������ n���϶�, n-1���� ������ ������
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

		//Ʈ�� ���� �����
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			trees.get(u).add(v);
			trees.get(v).add(u);
		}
		
		//Ʈ�������
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

		//dp[cur]�� 0�� �ƴϸ� ����� ����̹Ƿ�
		if(dp[cur]!=0) {
			return dp[cur];
		}
		dp[cur]=1;
		
		for(int child: trees.get(cur)) {
			//�θ�� �ڽ��� ������ �ȵ� //����Ŭ�� x �θ�� ������ �ϳ�
			
			if(parent != child) {
				dp[cur] += makeTree(child,cur) ;
				
			}
		}
		return dp[cur];
	}
	
}
