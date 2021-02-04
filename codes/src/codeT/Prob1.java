package codeT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//����ƺ��� ����
/*
 ������ �̽ʸ��̻��� ��ġ�� ���� ���ϱ⶧����, pos[20��] ���� ����
���� �ڴ��� ��ġ�� �̸� ���س�������, pos[���� ��ġ] �� ����ִ� ���� ������ �� ��ġ���� ���� �� �ִ� ���� ���� ���̱⶧����
������ ������ ��, �ڴ��� ��ġ��
num = ������ ��ġ
time = pos[num] = ������ ��ġ���� ������ �ð�
cony = �ڴ��� �ð��� (1+2+3+��.+time)�� �ڽ��� �ð� ���� ���̰�
if(num == cony + co) ������ ��ġ�� �ڴ��� ��ġ�� ���ٸ�
���� ������ ��ġ�� ������ �ð�(�ּ� �ð�)�̴�!
 */
public class Prob1 {
	static int b;// ������ ��ġ
	static int c; // �ڴ��� ��ġ
	// �湮�ߴ� ���ڸ� üũ�ϱ� ���� �迭 �ʱ�ȭ�ϰ� �ּҽð��� ����ϱ� ���� ������ġ������ �ð�+1�� �迭���ִ´�.
	static int[] check = new int[200001];
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b = sc.nextInt();
        c = sc.nextInt();

        if (b == c) {
            System.out.println(0);
        } else {
            brown(c);
        }
    }

	// ������ B+1,B-1,B*2 �� �ϳ��� ������ �� �ִ�. ������ ��� �� �� ����.
	/* ť�� �ش� ��ġ�� �־��ְ� check[������ġ]�� ���� 1�� �����Ѵ�. 
	 * ť�� �������� ���� while���� ���鼭 ������ �� ��ġ(next)�� �����Ѵ�. 
	 * next�� �����ȿ� �ְ� ������ �湮�� �̷��� ������ ť�� �־��ش�.
	 * BFS�� �����ϱ� ���� N�� K�� ���� �� 0���� ������������ ó���ؾ��Ѵ�.*/
	static void brown(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(b);

		
		while(!q.isEmpty()){
			int temp = q.poll();
			//poll: Retrieves and removes the head of this queue,
			//or returns null if this queue is empty.
			
			
			
			for(int i=0; i<3; i++ ) {
				int next;
				
				if(i==0) {
					next = temp+1;
					
				} else if(i==1) {
					next = temp-1;
				} else {
					next = temp*2;
				}
				
				if(next == b) {
					System.out.println(check[temp]);
					return ;
				}
				//next�� �����ȿ� �ְ�, ������ �湮�� �̷��� ������(check[next]==0) ť�� �ֱ�
				if(next >=0 && next < check.length && check[next]==0) {
					q.add(next);
					check[next] = check[temp]+1;
				}
			}
		}
	}

	static void cony(int num) {

	}
}
