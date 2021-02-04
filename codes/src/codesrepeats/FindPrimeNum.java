package codesrepeats;

import java.util.HashSet;

public class FindPrimeNum {

	public static void main(String[] args) {
		String[] nums = {"17","011"};
		System.out.println("number="+nums[0]+"   "+"return="+solution(nums[0]));
		System.out.println("number="+nums[1]+"   "+"return="+solution(nums[1]));

	}

	public static int solution(String nums) {
		int ans = 0;
		int[] numList = new int[nums.length()];
		for (int i = 0; i < nums.length(); i++) {
			numList[i] = Integer.parseInt(String.valueOf(nums.charAt(i)));
		}

		for (int i = 0; i < numList.length; i++) {
			for (int j = 0; j < numList.length - i - 1; j++) {
				if (numList[j] > numList[j + 1]) {
					int temp = numList[j];
					numList[j] = numList[j + 1];
					numList[j + 1] = temp;
				}
			}
		}
		// 중복을 허용하지 않는 HashSet 사용
		HashSet<Integer> primeList = new HashSet<>();
		for (int i = 1; i <= numList.length; i++) {
			perm(numList, 0, i, primeList);
		}

		return primeList.size();
	}


	public static void perm(int[] arr, int depth, int k, HashSet primeList) {
		if (depth == k) { //한번 depth가 k에 도달하면 사이클이 돈 것이다. 출력한다
			returnNumber(arr, k, primeList);
			return;
		} else {
			for (int i = depth; i < arr.length; i++) {

				swap(arr, i, depth);
				perm(arr, depth + 1, k, primeList);
//				System.out.println(primeList.toString());
				// primeList= [ 17,7,71 ];
				swap(arr, i, depth);
			}

		}

	}

	public static void returnNumber(int[] arr, int k, HashSet primeList) {
		int resultNumber = 0;
		for (int i = 0; i < k; i++) {
			resultNumber += arr[i] * Math.pow(10, k - 1 - i);
		}
		prime(primeList, resultNumber);
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void prime(HashSet primeList, int resultNumber) {
		boolean isPrime = true; // 소수인지 판별하기
		if (resultNumber <= 1) {
			return;
		}
		for (int j = 2; j <= Math.sqrt(resultNumber); j++) {
			if (resultNumber % j == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			primeList.add(resultNumber);
		}
	}

}
