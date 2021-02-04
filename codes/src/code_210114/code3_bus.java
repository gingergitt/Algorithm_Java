package code_210114;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//****
class code3_bus {

	public static String code3(int n, int t, int m, String[] timetable) {
		int ans = 0;
		// 1. 크루들의 도착시간을 오름차순으로 정렬하여 우선순위가 가장 높은 데이터(가장 먼저 도착한 사람부터)가 가장 먼저 나오게 한다.

		//queue
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		// 2. 09:00부터 t분간격, n번까지 탐색 -> q에 잇는 크루들의 도착시간 중 해당 시간에 탈수있는지 검사하여 새 list에 담아준다.
		// 버스 시작 시간 (처음 도착하는 시간), 09:00을 변환해준것이다.
		int busstart = 9 * 60;
		List<Integer>[] list = new List[n]; // 운행횟수 리스트에 저장 [ 2, 3, 3, 1, 1, 2, 3] (운행횟수를 list로)

		// 크루들 도착시간을 숫자로 변환, 큐에 저장하기
		for (int i = 0; i < timetable.length; i++) {
			int hh = Integer.parseInt(timetable[i].split(":")[0]);
			// :를 기준으로 0은 시, 1은 분의 부분
			int mm = Integer.parseInt(timetable[i].split(":")[1]);
			int time = hh * 60 + mm;

			pq.add(time); // 큐에 저장.

		}
		// 09:00시작, t만큼 셔틀버스 존재.
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();

			// 기다리는 크루 존재하면 (큐가 비어있지않을경우)
			while (!pq.isEmpty()) {
				int busarrive = pq.poll();
				// 현재 도착해있는 셔틀보다 콘이 일찍 도착하고, 정원이 남아 탈 수 있을 때는
				if (busarrive <= busstart && list[i].size() < m) {
					list[i].add(busarrive); // 태우기

				} else {
					// 도착해있는 크루가 없을 경우, 이미 뺀 크루의 시간을 다시 넣는다
					pq.add(busarrive);
					break;
				}
				// 마지막크루보다 1분일찍 도착해야 탈 수 있으므로
				ans = busarrive - 1;

			} // 다음 셔틀 도착시간 갱신하기
			busstart += t; 
		}

		// 4.가장 늦게 셔틀을 타는 경우도 구해야함 -> 마지막셔틀이 비어있다면 그 시간이 answer
		if (list[n - 1].size() < m) {
			ans = busstart - t; // 버스 시작 시간(도착한시간)-운행간격
		}
		String hh = String.format("%02d", ans / 60);
		String mm = String.format("%02d", ans % 60);
		return hh + ":" + mm;
	}

	public static void main(String[] args) {
		System.out.println(code3(1, 1, 5, new String[] { "08:00", "08:01", "08:02", "08:03" }));
		System.out.println(code3(2, 10, 2, new String[] { "09:10", "09:09", "08:00" }));
		System.out.println(code3(2, 1, 2, new String[] { "09:00", "09:00", "09:00", "09:00" }));
		System.out.println(code3(1, 1, 5, new String[] { "00:01", "00:01", "00:01", "00:01", "00:01" }));
		System.out.println(code3(1, 1, 1, new String[] { "23:59" }));
		System.out.println(code3(10, 60, 45, new String[] { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" }));
	}

}
