package code6;

import java.util.Arrays;

public class Solution5 {
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words2 = { "hot", "dot", "dog", "lot", "log" };
		boolean[] visitedNode = new boolean[words.length];
//		dfs(visitedNode, 0, begin, target, words);
		dfs(visitedNode, 0, begin, target, words2);
		// �ش� �ܾ ���� ��� 0�� ����Ѵ�.
		if (minCnt == Integer.MAX_VALUE) {
			minCnt = 0;
		}
		System.out.println("begin="+begin+" "+"target="+target);
		System.out.println("words="+Arrays.toString(words2)+"  return="+minCnt);

	}

	public static void dfs(boolean[] visitedNode, int cnt, String begin, String target, 
			String[] words) {
 
		// target�� ��ġ�ϸ� minCnt����
		if (begin.equals(target)) {
			if (minCnt > cnt)
				minCnt = cnt;
			return;
		}

		// �ܾ����տ� �����ϴ� �ܾ��� ��� dfs(���)
		for (int i = 0; i < words.length; i++) {
			if (!visitedNode[i] && checkingDiff(begin, words[i])) {
				visitedNode[i] = true;
				dfs(visitedNode, cnt + 1, words[i], target, words);
				visitedNode[i] = false;
			}
		}

	}

	// words�ȿ� ���� ���ϴ� �ܾ� �� �ѱ��ھ��� �ٲٴ��� üũ�ϱ� (�ѱ��ھ��� �ٲ�)
	public static boolean checkingDiff(String begin, String target) {
		char[] wd1 = begin.toCharArray();
		char[] wd2 = target.toCharArray();

		int change = 0;
		for (int i = 0; i < wd1.length; i++) {
			if (wd1[i] != wd2[i])
				change++;
		}
		if (change == 1)
			return true;

		return false;
	}

}
