package codeT;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//나잡아봐라 게임
/*
 브라운은 이십만이상의 위치로 가지 못하기때문에, pos[20만] 으로 설정
또한 코니의 위치는 미리 구해놓지말고, pos[브라운 위치] 에 들어있는 값이 브라운이 그 위치에서 가질 수 있는 가장 작은 초이기때문에
조건을 비교해줄 때, 코니의 위치는
num = 브라운의 위치
time = pos[num] = 브라운의 위치에서 가지는 시간
cony = 코니의 시간은 (1+2+3+….+time)에 자신의 시간 더한 값이고
if(num == cony + co) 브라운의 위치와 코니의 위치가 같다면
답은 브라운의 위치가 가지는 시간(최소 시간)이다!
 */
public class Prob1 {
	static int b;// 브라운의 위치
	static int c; // 코니의 위치
	// 방문했던 숫자를 체크하기 위해 배열 초기화하고 최소시간을 기록하기 위해 이전위치에서의 시간+1을 배열에넣는다.
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

	// 브라운은 B+1,B-1,B*2 중 하나로 움직일 수 있다. 범위를 벗어날 수 는 없다.
	/* 큐에 해당 위치를 넣어주고 check[현재위치]의 값을 1로 변경한다. 
	 * 큐가 비지않을 동안 while문을 돌면서 다음에 갈 위치(next)를 변경한다. 
	 * next가 범위안에 있고 이전에 방문한 이력이 없으면 큐에 넣어준다.
	 * BFS를 수행하기 전에 N과 K가 같을 때 0으로 출력해줘야함을 처리해야한다.*/
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
				//next가 범위안에 있고, 이전에 방문한 이력이 없으면(check[next]==0) 큐에 넣기
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
