package code_210114;

import java.util.LinkedList;
import java.util.*;

class code2_지도 {
//LRU : 사용한지 가장 오래된 것을 버리는 알고리즘 (Least Recently Used)
// 크게 3가지의 경우로 나눈다. 1) 캐시에 없는 것이 들어온 경우 -> 가장오래된것 빼고, 제일 뒤에 넣기(b,c,d,e)
	//2) 캐시에 있는 것이 들어 온 경우(제일앞O) -> (a,b,c,d)에서 a삽입 -> a의 상태를 제일 최신으로 변경 (맨뒤)(b,c,d,a)
	//3) 캐시에 있는 것이 들어온 경우 (제일 앞X) -> (a,b,c,d)에서 b 삽입-> a의 상태를 제일 최신으로 바꿔준다. (a,c,d,b)
	//3) - 앞에서부터 같은 값이 있는지 탐색 -> 저장한 인덱스 기준 한칸씩 당겨준다. -> 삽입된 요소를 배열의 제일 뒤에 넣어주기.

	public static int code2(int cacheSize, String[] cities) {
		
		//캐시사이즈가 0인 경우 : 모두 캐시 미스가 발생하기 때문에 *5를 해줘야한다. 
		if(cacheSize == 0 ) {
			return 5 * cities.length; 
		}
		int answer = 0;
		
		//linked list로 구현
		//linked list: 각 노드(엘리먼트)가 한줄로 연결되어 있는 방식으 ㅣ자료구조 , 중간에 삭제/추가해도 인덱스가 밀리지않음
		LinkedList<String> caches = new LinkedList<String>();
		
		for(int i=0; i<cities.length; i++) {
			String city = cities[i].toLowerCase(); //대소문자구분x니까 소문자로 일괄적용하기
			
			
			//1) 캐시에 값이 이미 들어 있을 때 (cachehit=1)
			//가장 오래된 값 빼고 (remove) //가장 앞에 데이터 추가
			System.out.println(city);
			System.out.println("/////////////////////////");
			if(caches.remove(city)) {
				System.out.println("remove하면="+city);
				caches.addFirst(city);
				System.out.println("addFirst="+city);
				answer += 1;//(이미 들어있었기 때문에 1=cachehit)
			}else {
				//2) 캐시에 값이 없을 때 
				//현재caches엔 값이없음 == cacheSize이면 (값이 없을 경우)
				if(caches.size() == cacheSize) {
					answer +=5; //cachemiss
					caches.addFirst(city); //addFirst : 가장 앞의 데이터 추가
					caches.pollLast(); // pollLast: 가장 뒤의 데이터 삭제(빼기)
				}
				else {
					// list(caches)가 캐시크기보다 작으면 (캐시안에공간이남아있을때)
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
