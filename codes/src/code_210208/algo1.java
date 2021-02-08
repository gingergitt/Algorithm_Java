package code_210208;

//1. N 사용횟수 최솟값 구하기 210208
public class algo1 {
 
	static int ans = -1;

	public static void solution(int n, int number) {
		
		calculation(n, number, 0, 0);
	}

	public static void calculation(int n, int number, int cnt, int acc) {

		int NN = n;
		if (cnt > 8) {
			ans = -1; // 종료
			return;
		}
 
		// 답과 같고 최소의 답인 경우
		if (acc == number) {
			if (ans == -1 || ans > cnt) {
				ans = cnt;
			}
			return;
		}
		// 9-cnt -> 남은 횟수 까지만 N을 붙일 수 있도록 설정
		// i= 1~9-cnt => 자릿수
		for (int i = 1; i < 9 - cnt; i++) { // i=1,2,3,,,
			calculation(n, number, cnt + i, acc + NN); // 5, 55, 555, 5555..
			calculation(n, number, cnt + i, acc - NN);
			calculation(n, number, cnt + i, acc * NN);
			calculation(n, number, cnt + i, acc / NN);
			NN += n * (Math.pow(10, i));
  
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int number = 12;
		int[] nArr = {5,2};
		int[] numArr= {12,11};
		for(int i=0; i<2; i++) {
			solution(nArr[i], numArr[i]);
			System.out.println("N="+nArr[i]+" number="+numArr[i]+" return="+ans);
			
		}
	}

}