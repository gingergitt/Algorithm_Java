package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6. 좌표정렬하기 - heap
public class Ex6_ex2 {
	/*
	 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, 
	 * x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오. 
	 * (입력) 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의
	 * 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고,
	 *  위치가 같은 두 점은 없다.
	 * (입력1) 5/ 3 4/ 1 1/ 1 -1/ 2 2/ 3 3 (출력1)1 -1/ 1 1/ 2 2/ 3 3/ 3 4
	 */

	
	// 힙정렬 이용해서 풀기
	
	public static void main(String[] args) throws Exception {
	

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		
		//최대힙 만들기 -> i=1부터?
		for(int i=arr.length/2-1; i>0; i--) {
			heapify(arr, arr.length, i);
		}
		//정렬하기
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
		int parent = pNode; //부모노드
		int lNode = pNode *2+1; //왼쪽자식노드
		int rNode = pNode *2 +2; //오른쪽 자식노드
		

		
	}
}
