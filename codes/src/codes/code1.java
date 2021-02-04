package codes;

class code1 {

	public static int code1(String darts) {
		// 1. 다트 횟수는 3번 (score)
		// 2. 입력받은 문자열(darts)를 문자 1개씩 가져오기 -> 1개씩 비교
		// 3. (1) 숫자 (2) S,D,T (3) *(중첩의경우포함-최근2개), #(최근1개)
		// 4. 숫자(0~10)의 경우 1일때와 10일때를 구분해야함(예외처리)
		// (Ex) darts = "1S2D*3T" 면 c= 1,S,2,D,*,3,T
		int answer = 0;
		int[] scores = new int[3];
		int idx = 0;
		int count = 0; // idx는 현재 입력받은 darts에서의 위치, count는 3회차중 몇번째인지를 세주는 용도.

		for (int i = 0; i < darts.length(); i++) {
			char c = darts.charAt(i);
			// 이 때, 문자의경우 아스키 코드식으로 저장이 되기 때문에 문자를 그대로 숫자로 치환해주는 함수가 필요
			int dartnum = Character.getNumericValue(c); // c의 문자가 숫자로 치환되었다.

			// 숫자일경우
			if (dartnum >= 0 && dartnum <= 10) {
				// 0~9 + 10
				if (dartnum == 1) {
					if (Character.getNumericValue(darts.charAt(i + 1)) == 0) {
						dartnum = 10; // 10일경우엔 10으로 찍어주기
						i++; // 하나씩 구할 때 마다 다음으로 넘어가야함.
					}
				}
				scores[idx] = dartnum; // (ex) scores[2]=10;
				count++; // 다음 도전 횟수로 넘어가야한다.
			}

			// 2. S, D , T
			// 숫자가 아닐 경우, S,D,T인 경우.
			else if (darts.charAt(i) == 'S') {
				// S일 경우 1제곱
				scores[idx] *= 1;
				idx++; // 다음자릿수넘기기
			} else if (darts.charAt(i) == 'D') {
				scores[idx] *= scores[idx];
				idx++;
			} else if (darts.charAt(i) == 'T') {
				scores[idx] *= scores[idx] * scores[idx];
				idx++;
			} // 2번 끝

			// 3. 숫자도아니고, 보너스(S,D,T)도아닌 *과 #일경우
			else if (darts.charAt(i) == '*') {
				// 첫번째기회에 *받을 경우 첫번째만 2배,
				idx= idx-2 <0 ? 0: idx-2; // idx-2가 0보다 크거나 같으면(=존재하면) , idx= idx-2;
				// 다른 스타상(*)과 중첩 가능함. 해당점수와, 바로 전에 얻은 점수를 각2배로. (idx, idx-1)
				while (idx < count) { // 
					//scores[idx] = scores[idx] * 2 + scores[idx - 1] * 2;
					scores[idx] = scores[idx] *2;
					idx++;
					
				}
				
			} else if (darts.charAt(i) == '#') {
				// 해당점수가 마이너스 
				scores[idx-1] = scores[idx-1] * (-1);
			}

		}
		// 점수집계
		for (int i = 0; i < scores.length; i++) {
			answer += scores[i];
		}

		return answer;
	}

	public static void main(String[] args) {
	    String[] darts = {"1S2D*3T","1D2S#10S","1D2S0T","1S*2T*3S","1D#2S*3S","1T2D3D#","1D2S3T*"};
	    
	      
	      for(int k=0; k<darts.length; k++) {
	         int result = code1(darts[k]);
	         System.out.println(k+"번의 "+"answer is = "+result);
	      }

	}
}
