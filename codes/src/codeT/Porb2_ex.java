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

//2. Ʈ���� ����
public class Porb2_ex {
	/*
	 * ���� 1) ���� �������� �Է� ���� 2) Ʈ�� ����� ���� 3) Ž��
	 */
	static int N, R, Q;
	static int[] edge;
	static ArrayList<ArrayList<Integer>> tree; // 2����

	public static void main(String[] args) throws IOException {
		// ����(���) n��, n-1���� ����

		tree = new ArrayList<>();

		// �� �Է�, �о����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// br�� �Է°��� ���� �� �о�� ����, �� ���پ� N, R, Q�� �����Ѵ�.
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		edge = new int[N+1]; //�� �������� �̸� �����ϸ� �ȵǴ���?

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
			// i=0�̰� N=5�� , 0,1,2,3,4,5 -> 6���� �迭�� tree�ȿ� �ֱ�
			// tree = [ [x,x],[x,x],[x,x],[x,x],[x,x],[x,x] ]
			
		}
		// Ʈ�� ���� �����
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			// U, V = (1,3) (4,3), (5,4) ...
			tree.get(U).add(V);
			System.out.println("1��="+tree.get(U));
			tree.get(V).add(U);
			System.out.println("2��="+tree.get(V));
			System.out.println("Ʈ����="+tree);
		}

		// Ʈ�� Ž���ϱ�
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
	//������, ���簪 (= �θ�, ������)

	static int findTree(int prev, int cur) {

		//dp[cur]�� 0�� �ƴϸ� ����� ����̹Ƿ�
		if(edge[prev]!=0) {
			return edge[prev];
		}
		edge[prev]=1;
		
		for(int child: tree.get(prev)) {
			//�θ�� �ڽ��� ������ �ȵ� //����Ŭ�� x �θ�� ������ �ϳ�
			
			if(cur != child) {
				edge[prev] += findTree(child,prev) ;
				
			}
		}
		return edge[prev];
	}
}
