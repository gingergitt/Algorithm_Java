package code6;

//11. 조이스틱
/*
- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다. (B->J)
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.

 */
public class Solution11 {

	

	public static int solution(String name) {
		int answer = 0;
		// 가장 큰 이동 값은 차례대로 움직여 length까지 가는것. == length -1
		int length = name.length();

		// 최대로 가질 수 있는 min값은 끝까지 가는것
		int minMove = length - 1;

		for (int i = 0; i < length; i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// 좌우: 연속된 A의 등장에 따라 최소 움직임이 달라진다
			int next = i + 1;// 현재 다음 위치부터
			// 내 현재 위치 다음에 오는게 A라면 계속 NEXT++
			while (next < length && name.charAt(next) == 'A') {
				next++;
			}
			// i=최소이동횟수(JEROEN이면 6번)
//minMove = Math.min(minMove, Math.min(i+len-next+ Math.min(i,len-next) ));
			minMove = Math.min(minMove, i + length - next + i);
		} // for

		answer += minMove;

		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println("name  " + " return");
		System.out.println("JEROEN   " + solution("JEROEN"));
		System.out.println("JAN      " + solution("JAN"));
		System.out.println("SONIA    " + solution("SONIA"));
	}

}
