package codesrepeats;

public class HeapAlgorithm {

	private static int num = 9;
	private static int[] heap = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };

	public static void main(String[] args) {
		// 1. ��ü ������ �ִ� �� ������ �ٲٱ�
		for (int i = 1; i < num; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2;
				if (heap[root] < heap[c]) { // �ڽĳ�尡 �θ��庸�� ũ�� -> �ٲ��ֱ�
					int temp = heap[c];
					heap[c] = heap[root];
					heap[root] = temp;
				}
				c = root;
			} while (c != 0);
		}
		// 2. ũ�⸦ �ٿ����� �ݺ������� ���� �����Ѵ�.
		for (int i = num - 1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				try {
					// �ڽ� �� �� ū �� ã��
					if (heap[c] < heap[c + 1] && c < i - 1) {
						c++;
					}
					// ��Ʈ���� �ڽ��� �� ũ�ٸ� ��ȯ
					if (heap[root] < heap[c] && c < i) {
						temp = heap[root];
						heap[root] = heap[c];
						heap[c] = temp;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				root = c;
			} while (c < i);
		}
		for (int i = 0; i < num; i++) {
			System.out.println(heap[i] + " ");
		}
	}
	/*
	 * �ٸ� ����� �ҽ��� ��� ������?
���� ��� ������, ä�� ��Ȳ ���������� ��ũ �ִ� ��� �̸��� ������ �˴ϴ�.
���� A�� �� �� �ִ� �ҽ��� ������ �����ϴ�.
A�� ������ �ҽ�
A�� ���� ������ ������ �ҽ�
A�� �������� ��ȸ�� ������ �ҽ�
A��  �Ǵ� �� ���� ���� �߿���
�ҽ� �ڵ��� ���� ������ "����"�� �ҽ�
�ҽ� �ڵ��� ���� ������ "�¾��� ���� ����"�̸鼭 ä�� �����  �Ǵ� �� �ҽ�
�κ� ���� �����½�ũ ��ü ä�� A�� �ְ������� �۰ų� ���� ������ ���� �ҽ�

	 */

}