package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//3. 수 정렬하기 3
public class Ex3 {

	public static void main(String[] args) throws Exception {
		
		// 1<= N <= 10,000,000 이므로 BufferedReader사용 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 수는 10,000보다 작거나 같은 자연수
		int[] R = new int[10001];
		// N 입력받기
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			R[Integer.parseInt(br.readLine())]++;
		}
		br.close();
//		System.out.println("입력값은=" + Arrays.toString(R));

		StringBuilder sb = new StringBuilder();
		// sort를 사용하지않고 출력
		System.out.println("--오름차순 출력--");
		for (int k = 1; k < 10001; k++) {
			while (R[k] > 0) {
				sb.append(k).append('\n');
				R[k]--;
		
			}

		}
		System.out.println(sb);

	}
}
