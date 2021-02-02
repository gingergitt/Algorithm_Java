package code6;

import java.util.ArrayList;

//������ �Ҽ��Ǻ� �˰����� �ʿ���.
public class Solution2_1 {
	ArrayList<Integer> result;
	boolean[] visited;

	public static void main(String[] args) {
		Solution2_1 sol2 = new Solution2_1();
		String numbers = "011";
		String numbers2= "17";
		System.out.println("numbers="+numbers+"  return="+sol2.solution(numbers));
		System.out.println("numbers="+numbers2+"  return="+sol2.solution(numbers2));
	}

	// �� �ڸ��� �´� ���� ���ϰ�, �� ������ �Ҽ����� �Ǵ�.
	public int solution(String numbers) {
		result = new ArrayList<Integer>(); // ���� ������ ã�� ���� arrayList
		visited = new boolean[numbers.length()];
		int[] nums = new int[numbers.length()];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numbers.charAt(i) + ""); // String ���� ���ڵ��� int�� �迭�� ��ȯ
		}

		// �ڸ� �� ���� �ش� �迭�� permutation �޼��忡 ������.
		for (int i = 1; i <= numbers.length(); i++) { // 1�� ���� numbers�� ���̱��� ������ ������ ���Ѵ�.
			int[] resultArr = new int[i];
			permutation(nums, resultArr, nums.length, i, 0);
		}

		return result.size();

	}

	public boolean isPrime(int num) { // �Ҽ����� �Ǻ��ϴ� �޼���
		if (num <= 1) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}

		int end = (int) Math.sqrt(num);
		for (int i = 2; i <= end; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// n���� r���� �̴´�. (����) nPr
	public void permutation(int[] nums, int[] resultArr, int n, int r, int idx) {
		if (idx == r) {
			// 0�̸���������, �Ҽ�����, �̹� result�� �ִ��� Ȯ��

			String realNum = "";
			for (int i = 0; i < resultArr.length; i++) {
				realNum += resultArr[i];
//				System.out.println("resultArr="+resultArr[i]);
			}

			int num = Integer.parseInt(realNum);
//			System.out.println("num="+num);
			if (isPrime(num)) {
				if (!result.contains(num)) {
					result.add(num);
				}
			}
//			System.out.println("rn="+realNum);
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
}
