package code_210114;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//****
class code3_bus {

	public static String code3(int n, int t, int m, String[] timetable) {
		int ans = 0;
		// 1. ũ����� �����ð��� ������������ �����Ͽ� �켱������ ���� ���� ������(���� ���� ������ �������)�� ���� ���� ������ �Ѵ�.

		//queue
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		// 2. 09:00���� t�а���, n������ Ž�� -> q�� �մ� ũ����� �����ð� �� �ش� �ð��� Ż���ִ��� �˻��Ͽ� �� list�� ����ش�.
		// ���� ���� �ð� (ó�� �����ϴ� �ð�), 09:00�� ��ȯ���ذ��̴�.
		int busstart = 9 * 60;
		List<Integer>[] list = new List[n]; // ����Ƚ�� ����Ʈ�� ���� [ 2, 3, 3, 1, 1, 2, 3] (����Ƚ���� list��)

		// ũ��� �����ð��� ���ڷ� ��ȯ, ť�� �����ϱ�
		for (int i = 0; i < timetable.length; i++) {
			int hh = Integer.parseInt(timetable[i].split(":")[0]);
			// :�� �������� 0�� ��, 1�� ���� �κ�
			int mm = Integer.parseInt(timetable[i].split(":")[1]);
			int time = hh * 60 + mm;

			pq.add(time); // ť�� ����.

		}
		// 09:00����, t��ŭ ��Ʋ���� ����.
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();

			// ��ٸ��� ũ�� �����ϸ� (ť�� ��������������)
			while (!pq.isEmpty()) {
				int busarrive = pq.poll();
				// ���� �������ִ� ��Ʋ���� ���� ���� �����ϰ�, ������ ���� Ż �� ���� ����
				if (busarrive <= busstart && list[i].size() < m) {
					list[i].add(busarrive); // �¿��

				} else {
					// �������ִ� ũ�簡 ���� ���, �̹� �� ũ���� �ð��� �ٽ� �ִ´�
					pq.add(busarrive);
					break;
				}
				// ������ũ�纸�� 1������ �����ؾ� Ż �� �����Ƿ�
				ans = busarrive - 1;

			} // ���� ��Ʋ �����ð� �����ϱ�
			busstart += t; 
		}

		// 4.���� �ʰ� ��Ʋ�� Ÿ�� ��쵵 ���ؾ��� -> ��������Ʋ�� ����ִٸ� �� �ð��� answer
		if (list[n - 1].size() < m) {
			ans = busstart - t; // ���� ���� �ð�(�����ѽð�)-���ణ��
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
