package codeT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

//5. �������
/* 1. �ڽ��� ��������̶��, �ڱ� �ڽŰ� ������ ��� ���� ��� ������ �� �� ������, 
 �ڱ� �ڽ��� ��������� �ƴ϶��, �ڽŰ� ����� ��� �� ��� �ϳ��� ��� ������ �Ǿ�� �Ѵ�. 
 ** ����
 1. �ڱ� �ڽ��� ��� ���� �� ��
-> ����� ������ ��� ��� �����̸� �� �ȴ�.
 2. �ڱ� �ڽ��� ��� ������ �ƴ� ��
-> ����� ���� ��� ���� �� ����, ��� ������ �ƴ� ���� �ִ�. */
public class Prob5_ex {

	static int n;
	static int[] arr;
	static int[][] dp;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		System.out.println("�Է�: ");
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

//		System.out.println("���: " + Math.max(MaxVal(0, 1, 0), MaxVal(0, 1, 1)));
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
