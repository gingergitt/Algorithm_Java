package code4;

public class ���� {
	/*
	 * ī���� ���� �ϱ� - arr, countArr, resultArr 1. input �迭 0 ~ n Ž��.
	 * (index[input[i]]++;) 2. index �迭 ������. -> temp�� ��Ƽ� ���� -> index[i] !=0 ->
	 * index[i] += temp -> temp = index[i] 3. input �迭 Ž�� -> index[input[i]]--
	 * (--�����ص� �ǰ�, �������� -- ���൵ �ȴ�.) -> answer[index[input[i]] = input[i]
	 * 
	 */

	int[] heap;
	int size = 0;
	int cur = 1;

	����(int n) {
		heap = new int[n + 1];
	}

	public void add(int n) {
		heap[cur] = n;
		int cNode = cur;
		size++;
		cur++;

		while (cNode != 1) {
			int fNode = cNode / 2;
			if (heap[fNode] > heap[cNode]) {
				int tmp = heap[fNode];
				heap[fNode] = heap[cNode];
				heap[cNode] = tmp;
				cNode = fNode;
			} else
				break;
		}
	}

	public int pop() {
		int top = heap[1];
		heap[1] = heap[size];
		heap[size] = 1001;
		size--;
		int tNode = 1;
		while (tNode * 2 <= size) {
			int cNode;
			if (tNode * 2 + 1 > size)
				cNode = tNode * 2;
			else {
				cNode = (heap[tNode * 2] < heap[tNode * 2 + 1]) ? tNode * 2 : tNode * 2 + 1;
			}
			if (heap[cNode] < heap[tNode]) {
				int tmp = heap[cNode];
				heap[cNode] = heap[tNode];
				heap[tNode] = tmp;
				tNode = cNode;
			} else
				break;
		}
		return top;
	}

	public int get(int i) {
		return heap[i];
	}

	public static void main(String[] args) {

	}
}
