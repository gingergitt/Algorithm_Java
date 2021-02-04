package code5;


public class Heap2 {
	/*
	 * ���� ������ �迭�� ǥ�� �����ϴ�. : A[1...n] 
	 * - ��Ʈ ��� A[1] 
	 * - A[i]�� �θ� = A[i/2] 
	 * - A[i]�� ���� �ڽ�= A[2i] 
	 * - A[i]�� ������ �ڽ� = A[2i + 1]
	 */

	int[] heapsort(int[] data) {
		int len = data.length;
		for (int i = len / 2; i > 0; i--) {
			downHeap(data, i, len);
		}
		do {
			int temp = data[0];
			data[0] = data[len - 1];
			data[len - 1] = temp;
			len = len - 1;
			downHeap(data, 1, len);
			// len -> ������ ��ġ�� ��Ÿ��

		} while (len > 1);
		return data;

	}

	private void downHeap(int[] data, int i, int len) {
		int j;
		int temp = data[i - 1];
		while (i <= len / 2) { // �ڽ��� ���翩�θ� Ȯ��
			j = 2 * i; // j -> ������ �ڽ�
			// ���� �ڽİ� ������ �ڽ��� ���� �� ū ���� ������ �ڽĵ�
			if ((j < len) && (data[j - 1] < data[j])) { 
				j++;
			}
			// temp�� ���Ѵ�. temp�� ũ�� ������ ��ġ �̹Ƿ� ���ǹ� ��
			if (temp >= data[j - 1]) {
				break;
			}
			data[i - 1] = data[j - 1];
			i = j;
		}
		data[i - 1] = temp;
	}

	public static void main(String[] args) {
		// �� ���� ��
		int[] data = { 4, 54, 2, 8, 63, 7, 55, 56 }; 
		System.out.println("# �� ���� ��");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println(); 
		// �� ���� ��
		Heap2 test = new Heap2();
		test.heapsort(data);
		System.out.println("# �� ���� ��");
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}

}