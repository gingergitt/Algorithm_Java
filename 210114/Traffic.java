package codes;

import java.util.Arrays;

public class Traffic {
	/*
	 * hh:mm:ss:000 0.000s �� ���·� �迭�� �־����� hh:mmss.000�� �αװ� ������ �ð�, 0.000s�� �ش� �α׸�
	 * ó���ϴµ� �ʿ��� �ð�. ������ �������� 1�ʵ��ȷαװ��ߺ� �ߺ��Ǵ� �α� ���� ��, ó������ �ִ��� return�ؾ��Ѵ�.
	 */
	//�Է�: [
//	2016-09-15 01:00:04.001 2.0s,
//	2016-09-15 01:00:07.000 2s
//	]

	public static int holidayTraffic(String[] lines) {
		int answer = 0;
		// ������ ó���� ����� �迭
		int [] traffics = new int[lines.length];
		double S, T, section; //S=����Ϸ�ð�, T=ó���ð�

		for (int i = 0; i < lines.length; i++) {
			//
			lines[i] = lines[i].substring(11).replace(":", "").replace("s", "");
			System.out.println("1="+lines[i]);
			// 010004.001 2.0
			// hh:mms:ss:000 ��� �ʷ� ġȯ�ϱ�
			int sec = (Integer.parseInt(lines[i].substring(0, 2)) * 3600
					+ Integer.parseInt(lines[i].substring(2, 4)) * 60) 
					+ Integer.parseInt(lines[i].substring(4, 6));
//			System.out.println(sec);
			lines[i] = "" + sec + lines[i].substring(6); // hhmmss
//			System.out.println(lines[i]);
			// 3604.001 2.0

		}

		for (int i = 0; i < lines.length; i++) {
			String[] splits = lines[i].split("\\s"); // S,T���п�-����
			// line[0] = 3604.001 
			// line[1] = 2.0
			//System.out.println(Arrays.deepToString(splits));
			S = Double.parseDouble(splits[0]); // S�� �Ϸ�ð�
//			System.out.println("S="+S);
			T = Double.parseDouble(splits[1]); // T�� ó���ð�
//			System.out.println("T="+T);
			// �˻��ؾߵ� ���� ���� 
			section = S + 1; //
			System.out.println("section="+section);
			// �Ʒ� ��û����  �˻�
			for (int j = i; j < lines.length; j++) {
				splits = lines[j].split("\\s");
				S = Double.parseDouble(splits[0]);
				
				T = Double.parseDouble(splits[1]);
				System.out.println("S�� ="+S+" T��="+T);
				// ���۽ð� ��� (temp)
				double temp = S - T + 0.001;
				System.out.println(temp);
				// ���۽ð��� section ���� ������
				if (temp - section < 0)
					System.out.println(temp-section);
				// ��������
					traffics[i]++;

			}

		}
		// ���� ���
		for (int i = 0; i < lines.length; i++) {
			// ���� ū ��û �� �˻�
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
		System.out.println("���="+holidayTraffic(lines)); // 
//
//		String[] lines1 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s" };
//		for (int i = 0; i < lines1.length; i++) {
//			System.out.println(lines1[i]);
//		}
		
//		System.out.println("���="+holidayTraffic(lines1)); // 
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
//		System.out.println("���="+holidayTraffic(lines2)); // ��:2
//		System.out.println(holidayTraffic(lines1)); // ��:2


	}

}
