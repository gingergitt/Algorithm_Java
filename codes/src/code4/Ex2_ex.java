package code4;


import java.util.Scanner;

//2. �� �����ϱ� 2
public class Ex2_ex {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Integer a = null;
		System.out.println("----�Է�----");
		int N = sc.nextInt();
		
		int[] arr = new int[20000001];
		for (int i = 1; i <= N; i++) {
			// Count Sorting... �ش� ���� ��ġ�� 1�� �ٲ��ش�.
			// ������ �ֱ� ������ 1000000�� �����ش�.
			arr[sc.nextInt() + 1000000] = 1;
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println("--�������� ���--");
		for (int i = 0; i <= arr.length; i++) {
			// ��� ����ߴµ� ����ؼ� �ݺ����� �� �� �����ϱ� N==0�϶� ����ǰ� ���ش�.
			if (N == 0)
				break;
			// Count Sorting�̱� ������ �迭�� 0�̸� �Ѿ��.
			if (arr[i] != 0) {
				System.out.println(i - 1000000);
				N--;
			}
		}

	}
}
