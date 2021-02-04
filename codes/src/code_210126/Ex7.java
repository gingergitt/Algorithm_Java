package code_210126;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

//7. �ܾ�����
public class Ex7 {
	
	public static void main(String[] args) throws Exception {
		// 1.���ڿ��� �迭�� �޾Ƽ�, 1)���̰� ª�� �ͺ���, 2) ���̰� ���� ��� ����������, 3)�׸��� �ߺ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] sen = new String[N];
		for(int i=0; i<N; i++) {
			sen[i]=br.readLine();
			sen[i] = sen[i].toLowerCase();
			
		}
		System.out.println("���ڿ� �迭="+Arrays.toString(sen));
		//1. ���̰� ª�� �ͺ���
		Arrays.sort(sen, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) return 1;
				else if(o1.length() == o2.length()) return 0;
				else return -1;
			}
			
	
		});
		//2. ���̰� ������ ���� ������
		for(int i=0; i< N; i++) {
			int k;
			for(k=i+1; k<N; k++) {
				if(sen[i].length() != sen[k].length()) 
					break; 
			}
			Arrays.sort(sen,i,k);
		}
		
		//�ߺ�����
		System.out.println(sen[0]);
		for(int i=1; i<N; i++) {
			if(sen[i-1].equals(sen[i])) {
				continue;
			}
			System.out.println(sen[i]);
		}
		
		
	}
}
