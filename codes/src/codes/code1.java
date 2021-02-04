package codes;

class code1 {

	public static int code1(String darts) {
		// 1. ��Ʈ Ƚ���� 3�� (score)
		// 2. �Է¹��� ���ڿ�(darts)�� ���� 1���� �������� -> 1���� ��
		// 3. (1) ���� (2) S,D,T (3) *(��ø�ǰ������-�ֱ�2��), #(�ֱ�1��)
		// 4. ����(0~10)�� ��� 1�϶��� 10�϶��� �����ؾ���(����ó��)
		// (Ex) darts = "1S2D*3T" �� c= 1,S,2,D,*,3,T
		int answer = 0;
		int[] scores = new int[3];
		int idx = 0;
		int count = 0; // idx�� ���� �Է¹��� darts������ ��ġ, count�� 3ȸ���� ���°������ ���ִ� �뵵.

		for (int i = 0; i < darts.length(); i++) {
			char c = darts.charAt(i);
			// �� ��, �����ǰ�� �ƽ�Ű �ڵ������ ������ �Ǳ� ������ ���ڸ� �״�� ���ڷ� ġȯ���ִ� �Լ��� �ʿ�
			int dartnum = Character.getNumericValue(c); // c�� ���ڰ� ���ڷ� ġȯ�Ǿ���.

			// �����ϰ��
			if (dartnum >= 0 && dartnum <= 10) {
				// 0~9 + 10
				if (dartnum == 1) {
					if (Character.getNumericValue(darts.charAt(i + 1)) == 0) {
						dartnum = 10; // 10�ϰ�쿣 10���� ����ֱ�
						i++; // �ϳ��� ���� �� ���� �������� �Ѿ����.
					}
				}
				scores[idx] = dartnum; // (ex) scores[2]=10;
				count++; // ���� ���� Ƚ���� �Ѿ���Ѵ�.
			}

			// 2. S, D , T
			// ���ڰ� �ƴ� ���, S,D,T�� ���.
			else if (darts.charAt(i) == 'S') {
				// S�� ��� 1����
				scores[idx] *= 1;
				idx++; // �����ڸ����ѱ��
			} else if (darts.charAt(i) == 'D') {
				scores[idx] *= scores[idx];
				idx++;
			} else if (darts.charAt(i) == 'T') {
				scores[idx] *= scores[idx] * scores[idx];
				idx++;
			} // 2�� ��

			// 3. ���ڵ��ƴϰ�, ���ʽ�(S,D,T)���ƴ� *�� #�ϰ��
			else if (darts.charAt(i) == '*') {
				// ù��°��ȸ�� *���� ��� ù��°�� 2��,
				idx= idx-2 <0 ? 0: idx-2; // idx-2�� 0���� ũ�ų� ������(=�����ϸ�) , idx= idx-2;
				// �ٸ� ��Ÿ��(*)�� ��ø ������. �ش�������, �ٷ� ���� ���� ������ ��2���. (idx, idx-1)
				while (idx < count) { // 
					//scores[idx] = scores[idx] * 2 + scores[idx - 1] * 2;
					scores[idx] = scores[idx] *2;
					idx++;
					
				}
				
			} else if (darts.charAt(i) == '#') {
				// �ش������� ���̳ʽ� 
				scores[idx-1] = scores[idx-1] * (-1);
			}

		}
		// ��������
		for (int i = 0; i < scores.length; i++) {
			answer += scores[i];
		}

		return answer;
	}

	public static void main(String[] args) {
	    String[] darts = {"1S2D*3T","1D2S#10S","1D2S0T","1S*2T*3S","1D#2S*3S","1T2D3D#","1D2S3T*"};
	    
	      
	      for(int k=0; k<darts.length; k++) {
	         int result = code1(darts[k]);
	         System.out.println(k+"���� "+"answer is = "+result);
	      }

	}
}
