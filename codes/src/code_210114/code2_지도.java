package code_210114;

import java.util.LinkedList;
import java.util.*;

class code2_���� {
//LRU : ������� ���� ������ ���� ������ �˰��� (Least Recently Used)
// ũ�� 3������ ���� ������. 1) ĳ�ÿ� ���� ���� ���� ��� -> ��������Ȱ� ����, ���� �ڿ� �ֱ�(b,c,d,e)
	//2) ĳ�ÿ� �ִ� ���� ��� �� ���(���Ͼ�O) -> (a,b,c,d)���� a���� -> a�� ���¸� ���� �ֽ����� ���� (�ǵ�)(b,c,d,a)
	//3) ĳ�ÿ� �ִ� ���� ���� ��� (���� ��X) -> (a,b,c,d)���� b ����-> a�� ���¸� ���� �ֽ����� �ٲ��ش�. (a,c,d,b)
	//3) - �տ������� ���� ���� �ִ��� Ž�� -> ������ �ε��� ���� ��ĭ�� ����ش�. -> ���Ե� ��Ҹ� �迭�� ���� �ڿ� �־��ֱ�.

	public static int code2(int cacheSize, String[] cities) {
		
		//ĳ�û���� 0�� ��� : ��� ĳ�� �̽��� �߻��ϱ� ������ *5�� ������Ѵ�. 
		if(cacheSize == 0 ) {
			return 5 * cities.length; 
		}
		int answer = 0;
		
		//linked list�� ����
		//linked list: �� ���(������Ʈ)�� ���ٷ� ����Ǿ� �ִ� ����� ���ڷᱸ�� , �߰��� ����/�߰��ص� �ε����� �и�������
		LinkedList<String> caches = new LinkedList<String>();
		
		for(int i=0; i<cities.length; i++) {
			String city = cities[i].toLowerCase(); //��ҹ��ڱ���x�ϱ� �ҹ��ڷ� �ϰ������ϱ�
			
			
			//1) ĳ�ÿ� ���� �̹� ��� ���� �� (cachehit=1)
			//���� ������ �� ���� (remove) //���� �տ� ������ �߰�
			System.out.println(city);
			System.out.println("/////////////////////////");
			if(caches.remove(city)) {
				System.out.println("remove�ϸ�="+city);
				caches.addFirst(city);
				System.out.println("addFirst="+city);
				answer += 1;//(�̹� ����־��� ������ 1=cachehit)
			}else {
				//2) ĳ�ÿ� ���� ���� �� 
				//����caches�� ���̾��� == cacheSize�̸� (���� ���� ���)
				if(caches.size() == cacheSize) {
					answer +=5; //cachemiss
					caches.addFirst(city); //addFirst : ���� ���� ������ �߰�
					caches.pollLast(); // pollLast: ���� ���� ������ ����(����)
				}
				else {
					// list(caches)�� ĳ��ũ�⺸�� ������ (ĳ�þȿ������̳���������)
					caches.addFirst(city);
					answer+=5; //cachemiss
				}
			}
			
			
			
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		int cacheSize = 3;
		int ca = 2; 
		int cac =5; 
		int cach = 0;
//		String[] cities = 
//			{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul","NewYork","LA"};
//		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
//		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork"," LA", "SanFrancisco", "Seoul"," Rome","Paris", "Jeju", "NewYork", "Rome"};
		String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
//		String[] cities5 = {"Jeju", "Pangyo", "NewYork"," newyork"};
//		String[] cities6 = {"Jeju", "Pangyo", "Seoul","NewYork","LA"};
		
		
//		int result = code2(cacheSize, cities);
//		int result2 = code2(cacheSize, cities2);
//		int result3 = code2(ca, cities3);
		int result4 = code2(cac,cities4);
//		int result5 = code2(ca, cities5);
//		int result6 = code2(cach, cities6);
		System.out.println("result is= " + result4);
//		System.out.println("city1= "+result+"\ncity2= "+result2+" \ncity3= "+result3+" \ncity4= "+result4+" \ncity=5 "+result5+" \ncity=6 "+result6);
	}

}
