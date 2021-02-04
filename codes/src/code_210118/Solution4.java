package code_210118;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

//4.���ü���
/*
������ 1����~N����
nũ�⸸ŭ �迭a (n=8�̰� a=4,3,6,8,7,5,2,1 �Է�)
�迭a�� ���ð� ���Ͽ� st.peek()�� a���� ���� �� �ϳ��� ���ְ�(��ġ�°ǻ��� - pop) -ó���Ͽ� ans�� �ְ�
�������� +ó���ؼ� ans�� ����

*/
public class Solution4 {

	public static void main(String[] args) throws Exception {
		int num = 1; // ����: 1~N
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		ArrayList<String> ans = new ArrayList<String>();

		int[] a = new int[n + 1];// 0�� ������� �ʱ� ������ 1����.
		int m = 1;

		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt(); // a = [4,3,6,8,7,5,2,1]
		}
		for (int i = 1; i <= n; i++) { // (ex) n=8�̸� st = [1,2,3,4,5,6,7,8]���� a�� ���� ���� ���ÿ�������
			st.push(i);
			ans.add("+");
			// ���� ������ �ι����ö� (��ġ��) ����
			while (!st.isEmpty() && st.peek() == a[m]) { // st.peek()�� a[1]�̸�
//				System.out.println("a[m]="+a[m]+"�׸��� st.peek()="+st.peek());
				st.pop();
				ans.add("-");
				m++;
				System.out.println("st=" + st);
			}
		}

		if (st.isEmpty()) {
			for (String s : ans) {
				System.out.println(s);
			}
		} else {
			System.out.println("NO");
		}
	}
}
