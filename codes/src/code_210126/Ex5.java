package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 5. 소트인사이드
public class Ex5 {

	public static void main(String[] args) throws Exception {

		String N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 2143 -> 4321 (내림차순) 
		//String으로 입력받아 한글자씩 자르고, int 변환하여 배열에 넣기
		// 1글자씩 자르고 parseInt
		N = br.readLine();
		int[] arr = new int[N.length()];
		for (int i = 0; i < N.length(); i++) {
			arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));

		}

		System.out.println("쪼개서 배열로=" + Arrays.toString(arr));
		// sort를 사용하지않고 출력
		System.out.println("--출력하기--");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // arr[0] < arr[1] 이면
					int temp = arr[i]; // temp에 arr[0]넣고
					arr[i] = arr[j]; // arr[1]값을 arr[0]에 넣고(맨앞으로)
					arr[j] = temp; // arr[1]자리에 temp를 넣는다.(arr[0]값을 뒤로) -> 내림차순
				}
			}

		}

		// 작은값부터 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
