package code3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

//6. ��ū�� *
public class Solution6 {

	/*
	 * Ai�� ��ū���� �����ʿ� �����鼭 Ai���� ū �� �߿��� ���� ���ʿ� �ִ� ���� �ǹ��Ѵ�. �׷��� ���� ���� ��쿡 ��ū���� -1�̴�.
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<>(); //���� ��ū���� ������ ���� �ε����� ��´�.
		
		int n = Integer.parseInt(br.readLine());
		String[] sen = br.readLine().split(" ");
		int[] A = new int[n]; //�Է¹��� ���ڸ� ���� �迭
		int[] answer = new int[n]; //������ ���� �迭
		
		
		for(int i=0; i<n; i++) {//String �迭�� int �迭��
			A[i] = Integer.parseInt(sen[i]);
		}
		st.push(0); //ù��° �ε����� �̸� ����
		for(int i=1; i<n; i++) {
			if(st.isEmpty()) {//������ ��������� ���� ���� �ε����� ��´�.
				st.push(i);
			} 
			// A[i] < A[i+1]�̶�� �ǹ� -> ������ ���ڰ� �� ũ�� ��ū���ϱ� ��ū���� ��츦 ã�°�
			while(!st.isEmpty() && A[st.peek()]<A[i]) {//������ ������� �ʰ�, ��ū���� ã�Ҵٸ�
				answer[st.pop()] = A[i]; //���ÿ��� �����ϰ� ���信 �߰�
				//���ÿ��� ���������ϱ� �� �ؿ� �ִ� �ε����� ���� ���� ���� �ݺ��� ����
			}
			st.push(i);//�ݺ��� ���� �ܰ踦 ���� ���� ���� �ε����� ����
		}
		System.out.println("��ū����="+Arrays.toString(answer));
		for(int i=0; i<n; i++) {
			if(answer[i]==0) {//��ū���� ���� �����
				bw.write(-1+" ");
			}else {
				bw.write(answer[i]+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}
