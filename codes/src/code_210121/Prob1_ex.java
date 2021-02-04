package codeT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1. 나잡아봐라 게임

public class Prob1_ex {
	static int b;// 브라운의 위치
	static int c; // 코니의 위치
	// 방문했던 숫자를 체크하기 위해 배열 초기화하고 최소시간을 기록하기 위해 이전위치에서의 시간+1을 배열에넣는다.
	static int[] check = new int[200001];
	
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력: ");
        c = sc.nextInt();
        b = sc.nextInt();

        if (b == c) {
            System.out.println(0);
        } else {
            brown(check[b]);
           
         
        }
    }

	/*
	 브라운은 이십만이상의 위치로 가지 못하기때문에, pos[20만] 으로 설정
	또한 코니의 위치는 미리 구해놓지말고, pos[브라운 위치] 에 들어있는 값이 브라운이 그 위치에서 가질 수 있는 가장 작은 초이기때문에
	조건을 비교해줄 때, 코니의 위치는
	num = 브라운의 위치
	time = pos[num] = 브라운의 위치에서 가지는 시간
	cony = 코니의 시간은 (1+2+3+….+time)에 자신의 시간 더한 값이고
	if(num == cony + co) 브라운의 위치와 코니의 위치가 같다면
	답은 브라운의 위치가 가지는 시간(최소 시간).
	 */
	static void brown(int num) {
		
		Queue<Integer> q = new LinkedList<Integer>(); //큐 생성(링크드리스트)
		q.add(b); //(브라운시작위치넣기)
		
		int check[] = new int[200001]; //배열한개마다 1초취급
		int ans = -1;
		//check[b위치] = 브라운이 그 위치에서 가질 수 있는 가장 작은 값(가장빠른시간)
		
		
		while(!q.isEmpty()){
			 num = q.poll(); //비어있게 만들고
			int time = check[num];
			int cony = 0;
			for(int k=1; k<=time; k++) 
				cony +=k; //cony: 코니의 시간
//			System.out.println("cony의시간="+cony);
			
			
			if(num == c +cony) { //코니위치 = 시작위치+코니의시간?
				ans = check[num];
//			System.out.println("코니의위치는="+num);
		
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

				//next가 범위안에 있고, 이전에 방문한 이력이 없으면(check[next]==0) 큐에 넣기
				if(next >=0 && next <check.length && check[next]==0) {
					q.add(next);
					//next는 코니와 브라운의 위치가 같을 때. ?
//					System.out.println(next);
					check[next] = check[num]+1;
//					System.out.println(check[next]);
				}
			}
			
		}
		System.out.println("출력: "+ans);
	}


}
