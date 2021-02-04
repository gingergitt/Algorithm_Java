package codesrepeats;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class �����˰������ {
	private TreeSet<String> set = new TreeSet<>();
	private int count;

	public static void main(String[] args) {

		String numbers = "11112";
		�����˰������ s = new �����˰������();
		System.out.println(s.solution(numbers));

	}

	public int solution(String numbers) {

		int size = numbers.length();

		// ����Ʈ�� �����
		List<Character> arr = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			arr.add(numbers.charAt(i));
		}

		// ����� ������ ����Ʈ
		List<Character> result = new ArrayList<>();

		// nPr���� r�� ��� �ø��鼭 ���� �˰��� ����
		for (int i = 0; i < size; i++) {
			permutation(arr, result, size, i + 1);
		}

		return count;
	}

	/**
	 * �Ҽ� �Ǻ�
	 * 
	 * @param n : �Ǻ��� ����
	 * @return
	 */
	private boolean isPrime(int n) {

		int i;
		int sqrt = (int) Math.sqrt(n);

		// 2�� ������ ¦�� �Ҽ�
		if (n == 2)
			return true;

		// ¦���� 1�� �Ҽ��� �ƴ�
		if (n % 2 == 0 || n == 1)
			return false;

		// �����ٱ����� Ȧ���� �������� ��
		for (i = 3; i <= sqrt; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	/**
	 * ���� �˰���
	 * 
	 * @param arr    : ���� ����Ʈ
	 * @param result : ��� ���� ����Ʈ
	 * @param n      : ��ü ����
	 * @param r      : ������ ����
	 */
	public void permutation(List<Character> arr, List<Character> result, int n, int r) {

		if (r == 0) {

			// 0���� �����ϴ� �κ������� ����
			if (result.get(0) != '0') {

				String str = "";
				int size = result.size();
				for (int i = 0; i < size; i++) {
					str += result.get(i);
				}

				int num = 0;

				// �̹� ���� ���� ������ �ƴ� ���
				if (!set.contains(str)) {
					num = Integer.parseInt(str);
					set.add(str);

					// �Ҽ� �Ǻ�
					if (isPrime(num)) {
						System.out.println(num);
						count++;
					}
				}
			}

			return;
		}

		for (int i = 0; i < n; i++) {

			result.add(arr.remove(i));
			permutation(arr, result, n - 1, r - 1);
			arr.add(i, result.remove(result.size() - 1));
		}

	}
}