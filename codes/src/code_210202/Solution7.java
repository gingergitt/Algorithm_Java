package code_210202;

import java.util.Arrays;

//7. 타겟넘버
public class Solution7 {

	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		Solution7 sol7 = new Solution7();
		System.out.println("   numbers   target  return");
		System.out.println(Arrays.toString(numbers)+" "+target+" "
				+ "    "+solution(numbers,target));
	}

	static int answer = 0;
	
	static public void dfs(int numbers[], int idx, int sum, int target) {
		//기저 조건
		if(idx == numbers.length) {
			if(sum == target)
				answer ++;
		}
		
		else if(idx<numbers.length) {
			dfs(numbers,idx+1, sum+numbers[idx], target);
			dfs(numbers,idx+1, sum-numbers[idx], target);
		}
		
	}
	
	
	static public int solution(int[] numbers, int target) {
		
		dfs(numbers,0,0,target);
		
		return answer;
	}
	
}
