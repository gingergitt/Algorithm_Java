package codes;


	class Req {
		int start;
		int finish;
		
		Req(int start, int finish){
			this.start = start;
			this.finish = finish;
		}
	}
public class traffic_ex {

	final static String[] req1 = {"2016-09-15 01:00:04.001 2.0s", 
			"2016-09-15 01:00:07.000 2s"};
	final static String[] req2 = {"2016-09-15 01:00:04.002 2.0s", 
	"2016-09-15 01:00:07.000 2s"};
	final static String[] req3 = { "2016-09-15 20:59:57.421 0.351s"
							, "2016-09-15 20:59:58.233 1.181s"
							, "2016-09-15 20:59:58.299 0.8s"
							, "2016-09-15 20:59:58.688 1.041s"
							, "2016-09-15 20:59:59.591 1.412s"
							, "2016-09-15 21:00:00.464 1.466s"
							, "2016-09-15 21:00:00.741 1.581s"
							, "2016-09-15 21:00:00.748 2.31s"
							, "2016-09-15 21:00:00.966 0.381s"
							, "2016-09-15 21:00:02.066 2.62s" };

	// lines = �α׹��ڿ�.
	// ���� �Ϸ�ð� S = 2016-09-15 hh:mm:ss.sss.
	// ó���ð� T = 0.1s 0.312s�� �Ҽ��� 3°�ڸ�.
	// ex) 2016-09-15 03:10:33:020 0.011.
	// ���� �Ϸ�ð� ������������ �����Ǿ� ����.
	
	// ��û ó���ð��� 3�������� �ð��ڸ������� ��� �ʿ� x.
	// ��, ��, �� �ð� ������ ��, �ʸ� ���� Double�� �ʷ� ��ȯ.
	// Ŭ���� req�迭�� ����� ���۽ð�, ���ð��� �Ľ��Ͽ� ����.
	// �迭���� �ϳ������� ���۽ð� +1 �� and ���ð� + 1�� �� �ð� ���.
	// 2���� ���̽� �����ϰ� ����.
	// ���۽ð��� �� �ð� ���� �ȿ��ִ� ������ ī��Ʈ.
	//	ī��Ʈ �� ���� ���� ū ���� ���.
	
	// ���ǻ��� ���۽ð� = ���� �Ϸ�ð� - ó���ð� + 0.001
	//		  1�� ��� = ���۽ð�(or ���ð�) + 1 - 0.001
	
	static Req parse(String req) {
		// ���� 1000�ڸ� ���ؼ� ���.
		// �ε� �Ҽ����� ���� ���ֱ� ���ؼ�.
		String[] tmp = req.split(" ");	
		
		String[] tmp_time = tmp[1].split(":");
		int res_minute = Integer.parseInt(tmp_time[1]) * 1000;
		if (res_minute == 0)
			res_minute = 1000*60;
		int res_second 
			= (int)(Double.parseDouble(tmp_time[2]) * 1000);
		int res_time = res_minute * 60 + res_second;
		int proc_time = (int)(Double.parseDouble(tmp[2]
									.substring(0, tmp[2].length() - 1))
									* 1000);
		int req_time = res_time - proc_time + 1;
//		System.out.println(res_minute);
//		System.out.println(res_second);
//		System.out.println(res_time);
//		System.out.println(proc_time);
//		System.out.println(req_time);
		
		Req r = new Req(req_time, res_time);
		
		return r;
	}
	
	public static int count(Req[] req) {
		int max = 0;
		// ���ð� and ���ð�+1 ���� �ȿ� �ִ� �۾� ã��
		// ��� 1. �� ���� ���۵� �۾��� ��
		//	���۽ð��� ������ ī��Ʈ
		// ��� 2. �� �ʰ� ���۵� �۾��� ��
		//  �����̰��� �ʴµ� ���ð�+1 ���ٴ� ����
		for(int i=0; i<req.length; i++) {
			int tmp=1;
			Req f = req[i];
			int stand = f.finish + 1000 - 1;
			for(int j=i+1; j<req.length; j++) {
				 Req s = req[j];
				 if(s.start <= f.finish) {
					 tmp++;
				 }
				 else {
					 if(s.start <= stand) {
						 tmp++;
					 }
				 }
			}
//			System.out.println(tmp);
			if(tmp>max) {
				max = tmp;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		// ���� ���� parse�Լ��� �̿��Ͽ� ���ڿ��� �Ľ��ؼ�.
		// ��û�ð��� ����ð��� Class Req�� ����.
		Req[] req = new Req[req3.length];
		for(int i=0; i<req3.length; i++) {
			req[i] = parse(req3[i]);
		}
		
		//�ܼ� Ȯ�ο� ��¹�
		for(Req r:req) {
			int m = r.start/60000;
			int second = r.start%60000;
			double s = second/1000.0;
			System.out.println("Req_time = " + (m+":"+s));
			m = r.finish/60000;
			second = r.finish%60000;
			s = second/1000.0;
			System.out.println("Res_time = " + (m+":"+s));
			System.out.println();
		}
		
		// �������� count �Լ��� �̿��Ͽ� ���� ���
		int answer = count(req);
		System.out.println(answer);
		
	}
	
}
