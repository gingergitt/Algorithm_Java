package code4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//7. �ܾ�����
public class Ex7_ex1 {
	
	public static void main(String[] args) throws Exception {
		// 1.���ڿ��� �迭�� �޾Ƽ�, 1)���̰� ª�� �ͺ���, 2) ���̰� ���� ��� ����������, 3)�׸��� �ߺ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] sen = new String[N+1];
		String[] txt1; String[] txt2;
		int size=0;
		for(int i=0; i<N; i++) {
			sen[i]=br.readLine();
			sen[i] = sen[i].toLowerCase();
		
		}
//		System.out.println("���ڿ� �迭="+Arrays.toString(sen));
		//1. ��Ʈ�� ����
		
		for(int i=1; i< sen.length; i++) {
			int c= i; //������
			while( c>0 ) {
				int p = (c-1) /2; //�θ���
				if(compare_txt(sen[p], sen[i]) == 1) {
					//�θ��尡 ���� ���
					swap(sen,p,i);
					c=p;
					continue;
				}
			}
		}
		
	
		
	}

	

	private static int compare_txt(String sen, String sen2) {
		return 0;
	}



	public static void swap(String[] sen, int p, int i) {
		// TODO Auto-generated method stub
		
	}

	
}
