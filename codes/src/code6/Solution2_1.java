package code6;

import java.util.ArrayList;
import java.util.Arrays;

//������ �Ҽ��Ǻ� �˰����� �ʿ���.
//1. ���ڸ� �����. 2. �Ҽ����� �Ǻ��Ѵ�.
public class Solution2_1 {

	boolean[] visited;
	ArrayList<Integer> result = new ArrayList<>(); // ���� ������ ã�� ���� arrayList

	// �� �ڸ��� �´� ���� ���ϰ�, �� ������ �Ҽ����� �Ǵ�.
	public int solution(String numbers) {

		visited = new boolean[numbers.length()];
		int[] nums = new int[numbers.length()];

		for (int i = 0; i < nums.length; i++) {
			// String ���� ���ڵ��� int�� �迭�� ��ȯ
			nums[i] = Integer.parseInt(numbers.charAt(i) + "");
		}

		// �ڸ� �� ���� �ش� �迭�� permutation(����) �޼��忡 ������.
		// 1�� ���� numbers�� ���̱��� ������ ������ ���Ѵ�.
		//
		for (int i = 1; i <= numbers.length(); i++) {
			int[] resultArr = new int[i];
			permutation(nums, resultArr, nums.length, i, 0);
		}
		return result.size(); //�Ҽ��� ����

	}

	public boolean isPrime(int num) { // �Ҽ����� �Ǻ��ϴ� �޼���
		if (num <= 1) {
			return false;
		}
		//2�� 3�� �Ҽ�
		if (num == 2 || num == 3) {
			return true;
		}
		
		int end = (int) Math.sqrt(num); //������(��Ʈ)���ϱ� 
		
		//�����ٱ����� �������� �ȴ�.(2,3,4,5,6,,,)
		for (int i = 2; i <= end; i++) {
			if (num % i == 0) { //����0�̸� false;
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
