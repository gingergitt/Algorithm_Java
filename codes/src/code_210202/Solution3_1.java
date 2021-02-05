package code_210202;

import java.util.Arrays;

//3.ī��
// ��� �� ���ϰ� ���� ���� ���ϱ� 
public class Solution3_1 {
	public static void main(String[] args) {
		int[] brown = { 10, 8, 24 };
		int[] yellow = { 2, 1, 24 };

		for (int i = 0; i < 3; i++) {
			String ans = Arrays.toString(solution(brown[i], yellow[i]));
			System.out.println("brown=" + brown[i] + " yellow=" + yellow[i] + " return=" + ans);

		}
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		int sum = brown + yellow;

		for (int i = 3; i <= sum; i++) {
			// ����� ��� ���Ѵ�.
			if (sum % i == 0) {
				int col = sum / i;
				int row = sum / col;
				// (col,row) �̸� ��� ��

				int yelCol = col - 2; // ����� ������ ���� 
				int yelRow = row - 2; // ����� ������ ����
				// ����� ������ ũ�� = ����� ������ ���� 
				if (yelCol * yelRow == yellow && col >= row) {
					return new int[] { col, row };
				}

			}
		}

		return answer;
	}
}
