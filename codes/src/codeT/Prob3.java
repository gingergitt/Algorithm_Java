package codeT;

import java.util.ArrayList;
import java.util.List;

//3. 트리의 독립 집합
/*
<트리 만들기>
-> 주어진 배열을 LIST에 2차원배열로 담고, 그 배열을 자식노드만 담긴 구조로 새롭게 트리 2차원배열에 담기
1) 엣지(연결)정보 저장(노드를잇는선)
2) tree 그리기(재귀함수)
3) 탐색(재귀함수)
 */
public class Prob3 {

	static int n;
	static int[][] edge;
	static List<Integer> list;

	public static void main(String[] args) {

		edge = new int[n - 1][];
		list = new ArrayList<Integer>();
	list = new ArrayList<>();
		int f, s;
		// 1. 엣지정보 저장
		for (int i = 0; i < edge.length; i++) {
			f = edge[i][0];
			s = edge[i][1];
		}
		
	}
}
