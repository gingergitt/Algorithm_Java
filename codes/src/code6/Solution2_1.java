package code6;

import java.util.ArrayList;
import java.util.Arrays;

//순열과 소수판별 알고리즘이 필요함.
//1. 숫자를 만든다. 2. 소수인지 판별한다.
public class Solution2_1 {

	boolean[] visited;
	ArrayList<Integer> result = new ArrayList<>(); // 답의 개수를 찾기 위한 arrayList

	// 각 자리에 맞는 순열 구하고, 그 수들이 소수인지 판단.
	public int solution(String numbers) {

		visited = new boolean[numbers.length()];
		int[] nums = new int[numbers.length()];

		for (int i = 0; i < nums.length; i++) {
			// String 형의 숫자들을 int형 배열로 변환
			nums[i] = Integer.parseInt(numbers.charAt(i) + "");
		}

		// 자리 수 마다 해당 배열을 permutation(순열) 메서드에 보낸다.
		// 1개 부터 numbers의 길이까지 숫자의 순열을 구한다.
		//
		for (int i = 1; i <= numbers.length(); i++) {
			int[] resultArr = new int[i];
			permutation(nums, resultArr, nums.length, i, 0);
		}
		return result.size(); //소수의 갯수

	}

	public boolean isPrime(int num) { // 소수인지 판별하는 메서드
		if (num <= 1) {
			return false;
		}
		//2와 3은 소수
		if (num == 2 || num == 3) {
			return true;
		}
		
		int end = (int) Math.sqrt(num); //제곱근(루트)구하기 
		
		//제곱근까지만 나눠보면 된다.(2,3,4,5,6,,,)
		for (int i = 2; i <= end; i++) {
			if (num % i == 0) { //몫이0이면 false;
				return false;
			}
		}
		return true;
	}

	// n개중 r개를 뽑는다. (순열) nPr
	public void permutation(int[] nums, int[] resultArr, int n, int r, int idx) {
		if (idx == r) {
			// 0이먼저오는지, 소수인지, 이미 result에 있는지 확인

			String realNum = "";
			for (int i = 0; i < resultArr.length; i++) {
				realNum += resultArr[i];
			}
 
			int num = Integer.parseInt(realNum);
			if (isPrime(num)) {
				if (!result.contains(num)) {
					result.add(num);
				}
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				resultArr[idx] = nums[i];
				permutation(nums, resultArr, n, r, idx + 1);
				resultArr[idx] = 0;
				visited[i] = false;
			}
		}
	}

	//
	
	
	
	public static void main(String[] args) {
		Solution2_1 sol2 = new Solution2_1();
		String numbers = "011";
		String numbers2 = "17";
		System.out.println("numbers=" + numbers + "  return=" + sol2.solution(numbers));
		System.out.println("numbers=" + numbers2 + "  return=" + sol2.solution(numbers2));
	}
}
