package code6;

import java.util.Arrays;

//4. ��Ʈ��ũ
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
			visitedNode[i] = false; // ��� ���� �ʱ�ȭ
		}

		for (int i = 0; i < computers.length; i++) {
			// ���� �湮���� ���� ��� ������ ��� - �Ǵٸ� ��Ʈ��ũ�� �߰� �� -> ��Ʈ��ũ�� +1 (answer)
			if (visitedNode[i] == false) {
				answer++;
				// Ž��
				dfs(i, visitedNode, computers);
			}
		}
		return answer;
	}

	public void dfs(int node, boolean[] visitedNode, int[][] computers) {
		visitedNode[node] = true; // ��� �湮

		for (int i = 0; i < computers.length; i++) {
			if (visitedNode[i] == false && computers[node][i] == 1) {
				// �ش� ������ ����Ǿ��ִ� ������ ǥ�õǾ� ������(1) �湮 �迭���� �湮���� ���� ����(false)�� ���
				dfs(i, visitedNode, computers);
			}
		}
	}

}
