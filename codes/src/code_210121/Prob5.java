package code_210121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//5. �������
/* 1. �ڽ��� ��������̶��, �ڱ� �ڽŰ� ������ ��� ���� ��� ������ �� �� ������, 
 �ڱ� �ڽ��� ��������� �ƴ϶��, �ڽŰ� ����� ��� �� ��� �ϳ��� ��� ������ �Ǿ�� �Ѵ�. 
 ** ����
 1. �ڱ� �ڽ��� ��� ���� �� ��
-> ����� ������ ��� ��� �����̸� �� �ȴ�.
 2. �ڱ� �ڽ��� ��� ������ �ƴ� ��
-> ����� ���� ��� ���� �� ����, ��� ������ �ƴ� ���� �ִ�. */
public class Prob5 {

	static int n;
	static int[] arr;
	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		System.out.println("�Է�: ");
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());

		dp = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}
		System.out.println("���: " + Math.max(MaxVal(0, 1, 0), MaxVal(0, 1, 1)));
	}

	static int MaxVal(int prev, int now, int state) {
		if (dp[now][state] != -1)
			return dp[now][state];
		dp[now][state] = 0;

		int res = 0;
		// �θ� ��������� �ƴ϶�� �ڽ� �� �ϳ��� ��������̾�� ��
		if (state == 0) {
			for (int next : list[now]) {
				if (next == prev)
					continue;
				res += Math.max(MaxVal(now, next, 0), MaxVal(now, next, 1));
			}
		} else {// �θ� ��������̶�� �ڽ��� ��������� �� ����
			res = arr[now];
			for (int next : list[now]) {
				if (next == prev)
					continue;
				
				res += MaxVal(now, next, 0);
			}
		}
		return dp[now][state] = res;
	}

}
