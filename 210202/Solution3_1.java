package code6;

import java.util.Arrays;

/* 약수 쌍 구하고 각자 갯수 구하기 
1. 카펫의 갈색의 개수와 빨간색의 개수를 더하여 카펫에서 총 격자의 개수를 구합니다.
2. 총 격자 개수의 약수의 쌍을 구합니다. brown=10, yellow=2 인 경우 총 격자의 개수는 12입니다.
이때 카펫은 다음과 같이 가능합니다
(1,12), (2,6), (3,4), (4,3), (6,2), (12,1)
하지만 행의 길이가 3보다 작게 되면 가운데 노란색 격자가 들어갈 수 없기 때문에 행(=가로)의 길이가 3이상이어야 합니다.
(3,4)의 경우 3을 가로의 길(열)이 4를 세로의 길이(행)라고 합시다. 
3. 노란색 격자의 행(가로), 열(세로)의 길이는 테두리 길이가 2씩 빠지게 되므로 다음과 같습니다.
노란색 격자의 행의 길이 = 4-2 = 2
노란색 격자의 열의 길이 = 3-2 = 1
총 노란색 격자의 수 = 2 x 1 = 2
4. 위에서 총 노란색 격자의 길이를 구하였습니다. 주어진 수와 같으므로 (3,4)가 답이 될 수 있습니다. 
여기서 가로와 세로의 길이만 비교합니다. 하지만 이는 세로의 길이가 더 기므로 답이될 수 없습니다. 
(4,3)이 답이 됩니다.
 */
public class Solution3_1 {
	public static void main(String[] args) {
		Solution3 sol3 = new Solution3();
		int[] brown = {10,8,24};
		int[] yellow = {2,1,24};
		
		for(int i=0; i<3; i++) {
			String ans = Arrays.toString(sol3.solution(brown[i], yellow[i]));
			System.out.println("brown="+brown[i]+" yellow="+yellow[i]+" return="+ans);
			
		}
	}
 
	public static int[] solution(int brown, int yellow) {
		int[] answer = {};
		int sum = brown + yellow; // 약수를 구하기 위한 sum

		// i=3인이유는, 가로가 3이상이어야 노란색 격자가 들어갈 수 있다.
		for (int i = 3; i <= sum; i++) {
			// 약수 모두 구하기
			if (sum % i == 0) {
				int garo = sum / i; // 가로
				int sero = sum / garo; // 세로

				int x = garo - 2; // 노란색 격자의 가로
				int y = sero - 2; // 노란색 격자의 세로
				if (x * y == yellow && garo >= sero) {
					return new int[] { garo, sero }; 
				}
			}
		}
 
		return answer;
	}
}
