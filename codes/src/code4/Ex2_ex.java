package code4;


import java.util.Scanner;

//2. 수 정렬하기 2
public class Ex2_ex {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Integer a = null;
		System.out.println("----입력----");
		int N = sc.nextInt();
		
		int[] arr = new int[20000001];
		for (int i = 1; i <= N; i++) {
			// Count Sorting... 해당 값의 위치를 1로 바꿔준다.
			// 음수가 있기 때문에 1000000을 더해준다.
			arr[sc.nextInt() + 1000000] = 1;
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println("--오름차순 출력--");
		for (int i = 0; i <= arr.length; i++) {
			// 모두 출력했는데 계속해서 반복문을 돌 수 있으니깐 N==0일때 종료되게 해준다.
			if (N == 0)
				break;
			// Count Sorting이기 때문에 배열이 0이면 넘어간다.
			if (arr[i] != 0) {
				System.out.println(i - 1000000);
				N--;
			}
		}

	}
}
