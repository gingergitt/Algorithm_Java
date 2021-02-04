package code4;

import java.util.Arrays;
import java.util.Scanner;

// 210125
//1. 수 정렬하기 1

// 1) 수의 개수 N 입력받기
// 2) line별로 N개의 줄에 숫자 입력받기 (중복x)
// 3) 첫째줄부터 오름차순으로 정렬하여 한줄에 하나씩 출력

public class Ex1 {
	static int N;
	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis();
		Scanner sc1 = new Scanner(System.in);
		int[] R;

		N = sc1.nextInt();
		R = new int[N];

		for (int i = 0; i < N; i++) {
			R[i] = sc1.nextInt();
		}
		System.out.println("입력값은=" + Arrays.toString(R));
//		Arrays.sort(R);
//
//		System.out.println("--오름차순 출력--");
//		for (int j : R) {
//			System.out.println(j);
//		}
		
		//sort를 사용하지않고 출력
		System.out.println("--sort를사용하지않고 출력하기--");
		for(int k=0; k<R.length; k++) {
			for(int i=0; i<R.length; i++) {
				if(R[k]<R[i]) {
					int temp = R[k];
					R[k] = R[i];
					R[i] = temp;
				}
			}
			
		}

		//작은값부터 출력
		for(int i=0; i<R.length; i++) {
			System.out.println(R[i]+" ");
		}
		System.out.println();
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
		System.out.println("시간차이(ms) : " + secDiffTime + "ms");
	}
}
