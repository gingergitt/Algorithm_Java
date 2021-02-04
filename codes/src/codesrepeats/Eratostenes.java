package codesrepeats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//�Ҽ� ã��(�Ǻ�) �˰��� - �����佺�׳׽��� ü
public class Eratostenes {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int num = Integer.parseInt(st.nextToken());
		
		if (num <= 1)
			return;

		boolean[] arr = new boolean[num + 1]; // true �̸� �ش� �ε��� �Ҽ�.
		arr[0] = arr[1] = false;
		for (int i = 2; i <= num; i += 1) {
			arr[i] = true;
		}
 
		// 2 ���� ���ڸ� Ű������ ������� ����(false �Ҵ�)
		
		// for(int i=2; i * i <= num; i+1)
		for (int i = 2; i * i <= num; i ++) {
			for (int j = i * i; j <= num; j += i) {
				arr[j] = false; // 2�� ������ 2�� ��� false
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
