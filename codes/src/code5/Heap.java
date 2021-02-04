package code5;

public class Heap {
/*
 힙 배열은 정렬되어 있지 않은 배열이다.
힙을 내림차순 혹은 오름차순으로 정렬하기 위해선 힙의 삭제 연산을 이용하면 된다.
최대 힙을 내림차순으로 정렬해보자.
루트 노드와 마지막 노드를 교환한다. 교환된 마지막 노드를 제외한 나머지 노드 간의 최대 힙을 만족시킨다.
이 과정을 반복하여 내림차순으로 정렬하면 된다.
힙의 삽입, 삭제 연산의 시간 복잡도는 힙 트리의 높이와 노드의 개수에 비례한다.
노드가 n개일 때 힙 트리의 높이는 log2(n)이므로 시간 복잡도는 O(n*log2(n))이다.
따라서 힙 정렬은 구현하기에는 복잡하지만 효율적인 정렬 방식이라 할 수 있다.
 */
	int[] arr;

	public Heap(int[] arr) {
		this.arr = arr;
	}

	public void max_Heapify(int i) {

		if (arr == null || arr.length < 1)
			return;

		int leftChild = i * 2;
		int rightChild = leftChild + 1;
		int largest;

		if (leftChild < arr.length && arr[leftChild] > arr[i])
			largest = leftChild;
		else
			largest = i;

		if (rightChild < arr.length && arr[rightChild] > arr[largest])
			largest = rightChild;

		if (largest != i) {
			swap(i, largest);
			max_Heapify(largest);
		}
	}

	public void buildMaxHeap() {

		if (arr == null || arr.length < 1)
			return;

		for (int i = arr.length / 2; i > 0; i--) {
			max_Heapify(i);
		}
	}

	private void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void printArr() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
			if (i == 0 || i == 1 || i == 3 || i == 7) {
				System.out.println();
			}
		}
	}

	public static void main(String args[]) {

		int[] arr = { 0, 16, 42, 15, 14, 67, 39, 13, 92, 18 };

		Heap heap = new Heap(arr);

		heap.buildMaxHeap();
		heap.printArr();

		System.out.println();
		System.out.println();

	}
}
