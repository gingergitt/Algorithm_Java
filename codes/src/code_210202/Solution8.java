package code_210202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 8. º∂ ø¨∞·«œ±‚ 
public class Solution8 {

	public static void main(String[] args) {
		int n=4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println("cost="+Arrays.deepToString(costs)+" "+"return="+solution(n, costs));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int[][] mapArr = new int[n][n]; 
		for (int i = 0; i < costs.length; i++) {
			mapArr[costs[i][0]][costs[i][1]] = mapArr[costs[i][1]][costs[i][0]] = costs[i][2];
		}
		boolean[] visitedNode = new boolean[n];
		List<Integer> connect = new ArrayList<>(n + 1);
		connect.add(0);
		visitedNode[0] = true;
		while (connect.size() < n) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			for (int island = 0; island < connect.size(); island++) {
				int i = connect.get(island);
				for (int j = 0; j < n; j++) {
					if (!visitedNode[j] && i != j && mapArr[i][j] > 0 && mapArr[i][j] < min) {
						min = mapArr[i][j];
						minIdx = j;
					}
				}
			}
			visitedNode[minIdx] = true;
			connect.add(minIdx);
			answer += min;
		}
		return answer;
	}
}