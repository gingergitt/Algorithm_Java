package codes;

import java.util.Arrays;

public class Traffic {
	/*
	 * hh:mm:ss:000 0.000s 의 형태로 배열이 주어진다 hh:mmss.000운 로그가 끝나는 시간, 0.000s는 해당 로그를
	 * 처리하는데 필요한 시간. 임의의 시점부터 1초동안로그가중복 중복되는 로그 개수 즉, 처리량중 최댓값을 return해야한다.
	 */
	//입력: [
//	2016-09-15 01:00:04.001 2.0s,
//	2016-09-15 01:00:07.000 2s
//	]

	public static int holidayTraffic(String[] lines) {
		int answer = 0;
		// 구간별 처리량 저장용 배열
		int [] traffics = new int[lines.length];
		double S, T, section; //S=응답완료시간, T=처리시간

		for (int i = 0; i < lines.length; i++) {
			//
			lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");
			System.out.println("1="+lines[i]);
			// 010004.001 2.0
			// hh:mms:ss:000 모두 초로 치환하기
			int sec = (Integer.parseInt(lines[i].substring(0, 2)) * 3600
					+ Integer.parseInt(lines[i].substring(2, 4)) * 60) 
					+ Integer.parseInt(lines[i].substring(4, 6));
//			System.out.println(sec);
			lines[i] = "" + sec + lines[i].substring(6); // hhmmss
//			System.out.println(lines[i]);
			// 3604.001 2.0

		}

		for (int i = 0; i < lines.length; i++) {
			String[] splits = lines[i].split("\\s"); // S,T구분용-띄어쓰기
			// line[0] = 3604.001 
			// line[1] = 2.0
			//System.out.println(Arrays.deepToString(splits));
			S = Double.parseDouble(splits[0]); // S는 완료시간
//			System.out.println("S="+S);
			T = Double.parseDouble(splits[1]); // T는 처리시간
//			System.out.println("T="+T);
			// 검사해야될 구간 설정 
			section = S + 1; //
			System.out.println("section="+section);
			// 아래 요청들을  검사
			for (int j = i; j < lines.length; j++) {
				splits = lines[j].split("\\s");
				S = Double.parseDouble(splits[0]);
				
				T = Double.parseDouble(splits[1]);
				System.out.println("S는 ="+S+" T는="+T);
				// 시작시간 계산 (temp)
				double temp = S - T + 0.001;
				System.out.println(temp);
				// 시작시간이 section 보다 빠르면
				if (temp - section < 0)
					System.out.println(temp-section);
				// 개수증가
					traffics[i]++;

			}

		}
		// 정답 계산
		for (int i = 0; i < lines.length; i++) {
			// 가장 큰 요청 수 검색
			if (answer < traffics[i]) answer = traffics[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] lines = {
				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
		};

		for (int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}
		System.out.println("출력="+holidayTraffic(lines)); // 
//
//		String[] lines1 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
//		for (int i = 0; i < lines1.length; i++) {
//			System.out.println(lines1[i]);
//		}
		
//		System.out.println("출력="+holidayTraffic(lines1)); // 
//
//		String[] lines2 = {
//		 "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", 
//		 "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s",
//		 "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", 
//		 "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", 
//		 "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
//		for (int i = 0; i < lines2.length; i++) {
//			System.out.println(lines2[i]);
//		}
//		
//		System.out.println("출력="+holidayTraffic(lines2)); // 답:2
//		System.out.println(holidayTraffic(lines1)); // 답:2


	}

}
