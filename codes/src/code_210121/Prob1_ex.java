package codeT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1. ����ƺ��� ����

public class Prob1_ex {
	static int b;// ������ ��ġ
	static int c; // �ڴ��� ��ġ
	// �湮�ߴ� ���ڸ� üũ�ϱ� ���� �迭 �ʱ�ȭ�ϰ� �ּҽð��� ����ϱ� ���� ������ġ������ �ð�+1�� �迭���ִ´�.
	static int[] check = new int[200001];
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�Է�: ");
        c = sc.nextInt();
        b = sc.nextInt();

        if (b == c) {
            System.out.println(0);
        } else {
            brown(check[b]);
           
         
        }
    }

	/*
	 ������ �̽ʸ��̻��� ��ġ�� ���� ���ϱ⶧����, pos[20��] ���� ����
	���� �ڴ��� ��ġ�� �̸� ���س�������, pos[���� ��ġ] �� ����ִ� ���� ������ �� ��ġ���� ���� �� �ִ� ���� ���� ���̱⶧����
	������ ������ ��, �ڴ��� ��ġ��
	num = ������ ��ġ
	time = pos[num] = ������ ��ġ���� ������ �ð�
	cony = �ڴ��� �ð��� (1+2+3+��.+time)�� �ڽ��� �ð� ���� ���̰�
	if(num == cony + co) ������ ��ġ�� �ڴ��� ��ġ�� ���ٸ�
	���� ������ ��ġ�� ������ �ð�(�ּ� �ð�).
	 */
	static void brown(int num) {
		
		Queue<Integer> q = new LinkedList<Integer>(); //ť ����(��ũ�帮��Ʈ)
		q.add(b); //(���������ġ�ֱ�)
		
		int check[] = new int[200001]; //�迭�Ѱ����� 1�����
		int ans = -1;
		//check[b��ġ] = ������ �� ��ġ���� ���� �� �ִ� ���� ���� ��(��������ð�)
		
		
		while(!q.isEmpty()){
			 num = q.poll(); //����ְ� �����
			int time = check[num];
			int cony = 0;
			for(int k=1; k<=time; k++) 
				cony +=k; //cony: �ڴ��� �ð�
//			System.out.println("cony�ǽð�="+cony);
			
			
			if(num == c +cony) { //�ڴ���ġ = ������ġ+�ڴ��ǽð�?
				ans = check[num];
//			System.out.println("�ڴ�����ġ��="+num);
		
				break;
			}
			
			
			
			int next=0;
			for(int i=0; i<3; i++ ) {
				
				if(i==0) {
					next = num-1;
					
				} else if(i==1) {
					next = num+1;
				} else if(i==2){
					next = num*2;
				}

				//next�� �����ȿ� �ְ�, ������ �湮�� �̷��� ������(check[next]==0) ť�� �ֱ�
				if(next >=0 && next <check.length && check[next]==0) {
					q.add(next);
					//next�� �ڴϿ� ������ ��ġ�� ���� ��. ?
//					System.out.println(next);
					check[next] = check[num]+1;
//					System.out.println(check[next]);
				}
			}
			
		}
		System.out.println("���: "+ans);
	}


}
