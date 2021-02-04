package code_210121;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//4. ��ȸ�� ����(SNS) - TreeDP�̿� ����
/*
 ���� x��� ����� �󸮾���Ͱ� �ƴ϶��, x�� ģ������ ��� �󸮾���Ϳ��� �Ѵ�.
 �׷��� x��� ����� �󸮾���Ͷ��, x�� ģ������ �󸮾���Ϳ��� �� ����, �ƴ� ���� �ִ�. 
 �׷���, dp[x][0]�� x�� �󸮾���Ͱ� �ƴ� �� �ּ� �󸮾������ ��, dp[x][1]�� x�� �󸮾�����϶� 
 �ּ� �󸮾������ ����� �����ϰ� Ʈ���� ��ȸ�ؾ��Ѵ�. 
 Ʈ���� ����Ŭ ���°� �ƴϱ� ������ ��� ������ �������� �ص� ��������� ������ �س��� ������ ��� ��忡 ������ �����ϰ�,
 �̷��� �����̶�� ��� ������ ��Ʈ�� �� �� �ִ�. 
 
 ���� ���� 1�� ��Ʈ��� �����ϰ�, 1�� �󸮾�����϶�, �󸮾���Ͱ� �ƴ� �� 2���� ���̽��� ������ Ȯ��������.
[  ������ ���� ����ó�� ������ �󸮾���Ͷ��, ����� �󸮾���Ϳ��� �Ҽ���, �ƴҼ��� �ְ�, 
 ������ �󸮾���Ͱ� �ƴ϶�� , ����� �ݵ�� �󸮾���Ϳ��� �Ѵ�. ]
 
 �׸��� ���� ���谡 1�� root��� �����ϰ� �������� �������� �����̴�. 
 
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

public class Prob4 {

	static int[][] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		// Scanner �� ��� �뷮�ʰ�, bufferreader��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // �ɰ���

		// n�� �Է¹ޱ�
		int n = Integer.parseInt(br.readLine());
		// n+1 �迭�� list�� ���
		list = new ArrayList[n + 1]; // ? �� n+1?
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

		System.out.println("�󸮾���� �ּҼ�=" + Math.min(MinVal(0, 1, 0), MinVal(0, 1, 1)));
	}

	//int prev, int cur, int state�ǹ� : 
	static int MinVal(int prev, int cur, int state) {
		if (dp[cur][state] != 0)
			return dp[cur][state];
		int res = 0;

		// B. ���� ���� cur�� �󸮾���Ͱ� �ƴ� ��
		//state == 0 ?? 
		if (state == 0) {
			// foreach loop -> for(type var: iterate)
			// iterate�� ������ ���� ��ü�̰� iterate��ü���� �Ѱ��� ���������� var�� ���ԵǾ�
			// for�� ���� / iterate���´� loop�� ���� �� �ִ� ������ �迭 �� ArrayLsit���� ����.
			// ��, list[cur]�迭�� �Ѱ��� ���������� next�� ���Եȴ�.
			// �迭�� ������ ȣ�������ʰ� �ѹ��� �����ϴ� ȿ������ ���
			for (int next : list[cur]) { // �ڽĵ��� �ݵ�� �󸮾���Ϳ��� �Ѵ�.
//				System.out.println(Arrays.deepToString(list));
				if (prev == next) {
					System.out.println("prev= " + prev);
					continue;
				}
				res += MinVal(cur,next,1);
				System.out.println("res = "+res);
			}
			// A. ���� cur�� �󸮾�����϶�
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
