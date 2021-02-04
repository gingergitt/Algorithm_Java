package code3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

//6. 오큰수 *
public class Solution6 {

	/*
	 * Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<>(); //아직 오큰수를 만나지 못한 인덱스를 담는다.
		
		int n = Integer.parseInt(br.readLine());
		String[] sen = br.readLine().split(" ");
		int[] A = new int[n]; //입력받은 숫자를 담을 배열
		int[] answer = new int[n]; //정답을 담을 배열
		
		
		for(int i=0; i<n; i++) {//String 배열을 int 배열로
			A[i] = Integer.parseInt(sen[i]);
		}
		st.push(0); //첫번째 인덱스는 미리 담음
		for(int i=1; i<n; i++) {
			if(st.isEmpty()) {//스택이 비어있으면 현재 차례 인덱스를 담는다.
				st.push(i);
			} 
			// A[i] < A[i+1]이라는 의미 -> 오른쪽 숫자가 더 크면 오큰수니까 오큰수일 경우를 찾는것
			while(!st.isEmpty() && A[st.peek()]<A[i]) {//스택이 비어있지 않고, 오큰수를 찾았다면
				answer[st.pop()] = A[i]; //스택에서 제거하고 정답에 추가
				//스택에서 제거했으니까 그 밑에 있던 인덱스가 가장 위로 오고 반복문 진행
			}
			st.push(i);//반복문 다음 단계를 위해 현재 차례 인덱스를 담음
		}
		System.out.println("오큰수들="+Arrays.toString(answer));
		for(int i=0; i<n; i++) {
			if(answer[i]==0) {//오큰수가 없는 수라면
				bw.write(-1+" ");
			}else {
				bw.write(answer[i]+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}
