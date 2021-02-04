package code6;

import java.util.Arrays;

//4. 네트워크
public class Solution4 {

	public static void main(String[] args) {
		Solution4 sol4 = new Solution4();
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int[][] computers2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };
		System.out.println("n=" + 3);
		System.out.println("computers=" + Arrays.deepToString(computers));
		System.out.println("return=" + sol4.solution(3, computers));
		System.out.println("---------------------");
		System.out.println("n=" + 3);
		System.out.println("computers=" + Arrays.deepToString(computers2));
		System.out.println("return=" + sol4.solution(3, computers2));
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		// visitedNode[3]
		boolean[] visitedNode = new boolean[computers.length];

		
		for (int i = 0; i < computers.length; i++) {
			visitedNode[i] = false; // 노드 정보 초기화
		}

		for (int i = 0; i < computers.length; i++) {
			// 아직 방문하지 않은 노드 존재할 경우 - 또다른 네트워크가 추가 됨 -> 네트워크수 +1 (answer)
			if (visitedNode[i] == false) {
				answer++;
				// 탐색
				dfs(i, visitedNode, computers);
			}
		}
		return answer;
	}

	public void dfs(int node, boolean[] visitedNode, int[][] computers) {
		visitedNode[node] = true; // 노드 방문

		for (int i = 0; i < computers.length; i++) {
			if (visitedNode[i] == false && computers[node][i] == 1) {
				// 해당 정점이 연결되어있는 것으로 표시되어 있으나(1) 방문 배열에서 방문하지 않은 상태(false)인 경우
				dfs(i, visitedNode, computers);
			}
		}
	}

}
