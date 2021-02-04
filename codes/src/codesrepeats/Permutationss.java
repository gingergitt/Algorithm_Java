package codesrepeats;

public class Permutationss {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		perm(arr, 0, 4, 4);
	}

	//배열 arr는 계속해서 데이터를 들고다니면서 교환되고 있는 배열이다. 
	// depth는 현재 트리구조에서 어떤 깊이에서 교환작업을 하고 있는지에 대한 변수이다. 
	// 즉, 맨 처음 깊이라면 0의 위치에서 작업하며 이는 첫번째와 첫번째 인자를 교환하거나(1,2,3,4)
	// 첫번째와 두번째 인자를 교환(2,1,3,4) 하거나, 첫번째와 세번째(3,2,1,4) 인자를 교환하거나
	// 첫번째와 네번째(4,2,3,1) 인자를 교환하는 중이다.
	// 물론 프로그램은 재귀적으로 깊이 탐색되므로, depth는 0에대한 것을 다 끝마치고 1로 넘어가는 것이 아니라,
	// 0,1,2,3,2,3,1,2,3 과 같은 형태로 내부적으로 변하고 있다. 물론 프로그램의 시작점에서는 0으로 넣어줘야한다.
	// k는 총 배열안에 들어있는 숫자를 뜻하며 고정값이다. 샘플은 1,2,3,4 네개이므로 4로 고정됨
	// primeList는 몇개를 뽑아내서 순열을 만들 것인지를 뜻하며 고정값이다. 
	public static void perm(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
			print(arr, k); //배열출력
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	} // 자바에서는 포인터가 없기 때문에 아래와 같이, 인덱스 i와 j를 통해 바꿔줌.

	
	
	
	/*
	 * swap()을 두번 쓰는 이유 재귀함수를 쓰면서 어쨌거나 perm() 함수에 자꾸 걸려서 뒤쪽swap()은 호출하지도 못하고 depth만
	 * 깊어지고 있는 도중 depth가 최종적으로 4가되면 perm()아래의 swap()함수가 드디어 호출된다. 바로, 두번째 swap()함수는
	 * 이지점에서 중요한 역할을 한다. 여기서는 swap()함수가 내부적으로 외부의 값들을 막 바꾸고 있다. perm()의 depth가 4가되어
	 * 한번 돌때마다 arr가 내부적으로 가지고있는 배열의 순서는 바뀌어져있다. 두번째 swap()은 전단계의 분기점에서의 배열의 순서를 기억하고
	 * 이를 초기화하는 작업에 지나지 않는다. 트리구조에서 depth는 0,1,2,3,2,3,1,2,3 뭐 이런식으로 한칸 두칸 뒤로 돌아가면서
	 * 다시 계산을 하는데 그 지점에서의 배열 안의 숫자 순서를 기억하고 있어야 한다. swap()없이 바로 사용하고자 한다면, 분기로 돌아가서
	 * 다시 교환을 하는게 아니라 이미 다른 분기에서 망가뜨려버린 배열 순서를 그대로 이용하게 된다. 결론적으로 황당한 순열들이 마구 튀어나오게
	 * 된다.
	 */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			if (i == k - 1)
				System.out.println(arr[i]);
			else
				System.out.print(arr[i] + ",");
		}
	}
}
