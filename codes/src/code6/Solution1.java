package code6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//210201- 1. ���ǰ��
class Solution1 {

	public static void main(String[] args) {

		Solution1 sol = new Solution1();

		int[][] ansArr = { { 1, 3, 2, 4, 2 }, { 1, 2, 3, 4, 5 } };
		for (int i = 0; i < 2; i++) {
			System.out.println("answers=" + Arrays.toString(ansArr[i]));
			sol.solution(ansArr[i]);
			System.out.println("-------------");
		}

	}

	public int[] solution(int[] answers) {
		int[] ans = {};

		// �����ڵ��� ��� ��ĵ� (�ݺ� ����)
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
	
		// �л��� ���� ���� �����ϱ� { p1�̸�������, p2�� ��������, p3�� �������� }
		int[] corrects = new int[3];

		// answers = {1,2,3,4,5}, {1,3,2,4,2}
		// ��Ī������
		// ans[0] = p1[0] ����
		// ���� ������ �¾Ҵ��� �ѹ����� Ȯ��
		for (int i = 0; i < answers.length; i++) {
			if (p1[i % p1.length]== answers[i]) {
				corrects[0]++;
			}
			if (p2[i % p2.length]== answers[i]) {
				corrects[1]++;
			}
			if (p3[i % p3.length]== answers[i]) {
				corrects[2]++;
			}
		}
		// ���� ���� ���� ã�� (���� ���� ���� ��� ã��)
		int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));
		List<Integer> lists = new ArrayList<>();
		
		//max���� ���� ��츦 == �� �����ָ� max���� ������� ���� ����� ��� �� �ִ�.
		//���� ���� ���� �������� max�ϱ�
		if (max == corrects[0]) {
			lists.add(1);
		}
		if (max == corrects[1]) {
			lists.add(2);
		}
		if (max == corrects[2]) {
			lists.add(3);
		}
		ans = new int[lists.size()];
		for (int j = 0; j < lists.size(); j++) {
			ans[j] = lists.get(j);
		}
		System.out.println("return=" + Arrays.toString(ans));

		return ans;
	}

}
