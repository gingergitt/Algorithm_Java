package code_210202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//6. ������
/*
������ ��ΰ� 2�� �̻��� ��� ���ĺ� ������ �ռ��� ��θ� ��ȯ�Ѵٰ� �Ͽ� ���ϱ� ���� String Ÿ������ ��θ� �����Ͽ���. ���а��� ��,��
��� �װ����� ����ؾ� �ϹǷ� visit[] �迭�� �ش� �װ����� ��������� �ִ��� Ȯ���Ͽ���.
visit�� ��� true���� Ȯ���ϴ� �ͺ��� �ð��� ���̱� ���� �� �� ���� �װ����� ����ߴ��� ī��Ʈ ���� cnt�� �ξ���. �� ������� ��� �ش� ��θ� list�� �����ߴ�. ���� �װ����� �� ������� �� �ϰ� ��ΰ� ����Ǵ� ���� list�� ������� �ʴ´�.
���ݱ����� ��� �ܿ� �߰��� �ٸ� ��θ� �� �� �ֱ� ������ dfs ȣ���� ����Ǹ� visit�� route���� ���� �湮 ��ġ�� ����� �Ѵ�.
list�� ������������ �����Ѵ�. (���ڰ� ���� ��)
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