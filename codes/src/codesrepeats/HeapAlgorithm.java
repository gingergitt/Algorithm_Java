package codesrepeats;

public class HeapAlgorithm {

	private static int num = 9;
	private static int[] heap = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };

	public static void main(String[] args) {
		// 1. 전체 구조를 최대 힙 구조로 바꾸기
		for (int i = 1; i < num; i++) {
			int c = i;
			do {
				int root = (c - 1) / 2;
				if (heap[root] < heap[c]) { // 자식노드가 부모노드보다 크면 -> 바꿔주기
					int temp = heap[c];
					heap[c] = heap[root];
					heap[root] = temp;
				}
				c = root;
			} while (c != 0);
		}
		// 2. 크기를 줄여가며 반복적으로 힙을 구성한다.
		for (int i = num - 1; i >= 0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			int root = 0;
			int c = 1;
			do {
				c = 2 * root + 1;
				try {
					// 자식 중 더 큰 값 찾기
					if (heap[c] < heap[c + 1] && c < i - 1) {
						c++;
					}
					// 루트보다 자식이 더 크다면 교환
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
	 * 다른 사람의 소스는 어떻게 보나요?
맞은 사람 페이지, 채점 현황 페이지에서 링크 있는 언어 이름을 누르면 됩니다.
유저 A가 볼 수 있는 소스는 다음과 같습니다.
A가 제출한 소스
A가 만든 문제에 제출한 소스
A가 관리자인 대회에 제출한 소스
A가  또는 를 받은 문제 중에서
소스 코드의 공개 설정이 "공개"인 소스
소스 코드의 공개 설정이 "맞았을 때만 공개"이면서 채점 결과가  또는 인 소스
부분 점수 서브태스크 전체 채점 A의 최고점보다 작거나 같은 점수를 받은 소스

	 */

}