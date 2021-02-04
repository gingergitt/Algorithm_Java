package codeT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//4. ��ȸ�� ����(SNS) - TreeDP�̿� ����
/*
 *** ���� ���� 
 cur�� �θ���, next�� �ڽĳ��� �����Ѵ�.
 	A. cur�� �󸮾������ ��
 	�켱 cur�� �󸮾���Ͱ� Ȯ���̹Ƿ�, ���� �󸮾���� ���� +1�� ���ش�.
 	�׸��� �ڽ��� �ΰ��� ���¸� ���� �� �ִ�. (�ڽ��� �󸮾�����ϼ���, �ƴҼ��� ����)
 		1) next�� �󸮾���Ͱ� �ƴ� ���� �ּ� �󸮾���� �� 
 		2) next�� �󸮾������ ���� �ּ� �󸮾���� ��
 	�ΰ��� ���¿� ���� �ּ� �󸮾���� ���� �θ� �ʿ� �����ָ� �ȴ�. 
 	B. cur�� �󸮾���Ͱ� �ƴ� �� (�ڽ��� ��� �󸮾���;�߸� ��!)
 	cur�� �󸮾���Ͱ� �ƴϹǷ�, �ڽĵ��� ��� �󸮾���Ϳ��� �Ѵ�. 
 	���� cur�� �ڽĵ��� ��� �󸮾������ ���� �ּ� �󸮾������ ���� �������ش�. 
 */

public class Prob4_ex {

	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		// Scanner �� ��� �뷮�ʰ�, bufferreader��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // �ɰ���
		
		System.out.print("�Է�: ");
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1]; // ? �� n+1?
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

		System.out.println("�ּ� �󸮾���� ��= "+Math.min(go(0, 1, 0), go(0, 1, 1)));
		
	}

	static int go(int prev, int cur, int state) {
		if (dp[cur][state] != 0)
			return dp[cur][state];
		int res = 0;

		// B. ���� ���� cur�� �󸮾���Ͱ� �ƴ� ��
		//state == 0 ?? 
		if (state == 0) {
			for (int next : list[cur]) { // �ڽĵ��� �ݵ�� �󸮾���Ϳ��� �Ѵ�.
				if (prev == next) {
					continue;
				}
				res += go(cur,next,1);
			}
			// A. ���� cur�� �󸮾�����϶�
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
