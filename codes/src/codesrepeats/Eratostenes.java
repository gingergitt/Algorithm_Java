package codesrepeats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//소수 찾기(판별) 알고리즘 - 에라토스테네스의 체
public class Eratostenes {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
		
		if (num <= 1)
			return;

		boolean[] arr = new boolean[num + 1]; // true 이면 해당 인덱스 소수.
		arr[0] = arr[1] = false;
		for (int i = 2; i <= num; i += 1) {
			arr[i] = true;
		}
 
		// 2 부터 숫자를 키워가며 배수들을 제외(false 할당)
		
		// for(int i=2; i * i <= num; i+1)
		for (int i = 2; i * i <= num; i ++) {
			for (int j = i * i; j <= num; j += i) {
				arr[j] = false; // 2를 제외한 2의 배수 false
			}
		}
		System.out.println("Prime number list from 2 to " + num + " : ");
		for (int i = 0; i <= num; i += 1) {
			if (true == arr[i]) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}
