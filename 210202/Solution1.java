package code6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//210201- 1. ���ǰ��
class Solution1 {

	public static void main(String[] args) {

		Solution1 sol = new Solution1();
		int[] ans = new int[5];
		sol.solution(ans);
		;
	}

	public int[] solution(int[] answer) {

//		int[] ans = { 1, 2, 3, 4, 5 };
		int[] ans = { 1, 3, 2, 4, 2 };
		System.out.println("answers=" + Arrays.toString(ans));
		// �����ڵ��� ��� ��ĵ�
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// �л��� ���� ���� �����ϱ� { p1�̸�������, p2�� ��������, p3�� �������� }
		int[] corrects = new int[3];

		// ans = {1,2,3,4,5};
		// ��Ī������
		// ans[0] = p1[0] ����
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == p1[i % p1.length]) {
				corrects[0]++;
			}
			if (ans[i] == p2[i % p2.length]) {
				corrects[1]++;
			}
			if (ans[i] == p3[i % p3.length]) {
				corrects[2]++;
			}
		}

		// ���� ���� ���� ã��
		int max = Math.max(corrects[0], Math.max(corrects[1], corrects[2]));

		List<Integer> lists = new ArrayList<Integer>();


		// ���� ���� ������ �޴� ��� ã��
		// i = 0,1,2
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
