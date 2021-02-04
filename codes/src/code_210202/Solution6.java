package code_210202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//6. 여행경로
/*
가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 반환한다고 하여 비교하기 쉽게 String 타입으로 경로를 저장하였다. 구분값은 “,”
모든 항공권을 사용해야 하므로 visit[] 배열로 해당 항공권을 사용한적이 있는지 확인하였다.
visit이 모두 true인지 확인하는 것보다 시간을 줄이기 위해 총 몇 장의 항공권을 사용했는지 카운트 변수 cnt를 두었다. 다 사용했을 경우 해당 경로를 list에 저장했다. 만약 항공권을 다 사용하지 못 하고 경로가 종료되는 경우는 list에 저장되지 않는다.
지금까지의 경로 외에 중간에 다른 경로를 갈 수 있기 때문에 dfs 호출이 종료되면 visit과 route에서 현재 방문 위치를 빼줘야 한다.
list를 오름차순으로 정렬한다. (문자가 빠른 순)
 */
public class Solution6 {
	List<String> list = new ArrayList<>();
	static String route = "";
	static boolean[] visit;

	public static void main(String[] args) {
		Solution6 sol6 = new Solution6();
//		String start = "ICN";
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		String[][] tickets2 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };

		System.out.println("tickets="+Arrays.deepToString(tickets2));
		String tmp2[] = sol6.solution(tickets2);
		System.out.println("return="+Arrays.toString(tmp2));
		System.out.println("------------------");
		System.out.println("tickets="+Arrays.deepToString(tickets));
		String tmp[] = sol6.solution(tickets);
		System.out.println("return="+Arrays.toString(tmp));

	}

	private void dfs(String[][] tickets, String end, int cnt) {
		route += end + ",";

		if (cnt == tickets.length) {
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0], e = tickets[i][1];
			if (s.equals(end) && !visit[i]) {
				visit[i] = true;
				dfs(tickets, e, cnt + 1);
				visit[i] = false;
				route = route.substring(0, route.length() - 4);
			}
		}
	}

	public String[] solution(String[][] tickets) {
		for (int i = 0; i < tickets.length; i++) {
			visit = new boolean[tickets.length];
			String start = tickets[i][0];
			String end = tickets[i][1];

			if (start.equals("ICN")) {
				route = start + ",";
				visit[i] = true;
				dfs(tickets, end, 1);
			}
		}

		Collections.sort(list);
		String[] answer = list.get(0).split(",");

		return answer;
	}
}