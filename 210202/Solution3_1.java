package code6;

import java.util.Arrays;

/* ��� �� ���ϰ� ���� ���� ���ϱ� 
1. ī���� ������ ������ �������� ������ ���Ͽ� ī�꿡�� �� ������ ������ ���մϴ�.
2. �� ���� ������ ����� ���� ���մϴ�. brown=10, yellow=2 �� ��� �� ������ ������ 12�Դϴ�.
�̶� ī���� ������ ���� �����մϴ�
(1,12), (2,6), (3,4), (4,3), (6,2), (12,1)
������ ���� ���̰� 3���� �۰� �Ǹ� ��� ����� ���ڰ� �� �� ���� ������ ��(=����)�� ���̰� 3�̻��̾�� �մϴ�.
(3,4)�� ��� 3�� ������ ��(��)�� 4�� ������ ����(��)��� �սô�. 
3. ����� ������ ��(����), ��(����)�� ���̴� �׵θ� ���̰� 2�� ������ �ǹǷ� ������ �����ϴ�.
����� ������ ���� ���� = 4-2 = 2
����� ������ ���� ���� = 3-2 = 1
�� ����� ������ �� = 2 x 1 = 2
4. ������ �� ����� ������ ���̸� ���Ͽ����ϴ�. �־��� ���� �����Ƿ� (3,4)�� ���� �� �� �ֽ��ϴ�. 
���⼭ ���ο� ������ ���̸� ���մϴ�. ������ �̴� ������ ���̰� �� ��Ƿ� ���̵� �� �����ϴ�. 
(4,3)�� ���� �˴ϴ�.
 */
public class Solution3_1 {
	public static void main(String[] args) {
		Solution3 sol3 = new Solution3();
		int[] brown = {10,8,24};
		int[] yellow = {2,1,24};
		
		for(int i=0; i<3; i++) {
			String ans = Arrays.toString(sol3.solution(brown[i], yellow[i]));
			System.out.println("brown="+brown[i]+" yellow="+yellow[i]+" return="+ans);
			
		}
	}
 
	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		int sum = brown + yellow; // ����� ���ϱ� ���� sum

		// i=3��������, ���ΰ� 3�̻��̾�� ����� ���ڰ� �� �� �ִ�.
		for (int i = 3; i <= sum; i++) {
			// ��� ��� ���ϱ�
			if (sum % i == 0) {
				int garo = sum / i; // ����
				int sero = sum / garo; // ����

				int x = garo - 2; // ����� ������ ����
				int y = sero - 2; // ����� ������ ����
				if (x * y == yellow && garo >= sero) {
					return new int[] { garo, sero }; 
				}
			}
		}
 
		return answer;
	}
}
