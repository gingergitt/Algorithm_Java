package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6. ��ǥ�����ϱ� - heap
public class Ex6_ex2 {
	/*
	 * 2���� ��� ���� �� N���� �־�����. ��ǥ�� x��ǥ�� �����ϴ� ������, 
	 * x��ǥ�� ������ y��ǥ�� �����ϴ� ������ ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	 * (�Է�) ù° �ٿ� ���� ���� N (1 �� N �� 100,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� i������
	 * ��ġ xi�� yi�� �־�����. (-100,000 �� xi, yi �� 100,000) ��ǥ�� �׻� �����̰�,
	 *  ��ġ�� ���� �� ���� ����.
	 * (�Է�1) 5/ 3 4/ 1 1/ 1 -1/ 2 2/ 3 3 (���1)1 -1/ 1 1/ 2 2/ 3 3/ 3 4
	 */

	
	// ������ �̿��ؼ� Ǯ��
	
	public static void main(String[] args) throws Exception {
	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		
		//�ִ��� ����� -> i=1����?
		for(int i=arr.length/2-1; i>0; i--) {
			heapify(arr, arr.length, i);
		}
		//�����ϱ�
		for(int i=arr.length-1; i>0; i--) {
			swap(arr,i,0);
		}
	}

	public static void swap(int[][] arr, int i, int j) {
		int tmp = arr[j][2];
		arr[j][2] = arr[i][2];
		arr[i][2] = tmp; 
	}

	public static void heapify(int[][] arr, int size, int pNode) {
		int parent = pNode; //�θ���
		int lNode = pNode *2+1; //�����ڽĳ��
		int rNode = pNode *2 +2; //������ �ڽĳ��
		

		
	}
}
