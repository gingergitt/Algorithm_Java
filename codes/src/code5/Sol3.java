package code5;


//3. ��й�ȣ

//(1) A���������� 1�ǰ��� x ã��
//(2) case1: A���� ������ ��, ������ǥ������ 1����=x�̰�, A������ ������ ã��
// case2: A���� ū�� ��, ������ ǥ������ 1����=x�̰�, A������ ����� �� ã�� ���

public class Sol3 {

	public static void main(String[] args) {
		int A = 7;
		int B = 7;
		int cnt = 0;
		String a = Integer.toBinaryString(A);
		System.out.println("�Է°�="+A);
		
		System.out.println("������ ��ȯ��="+a);
		String[] findOne = new String[6];

		for (int i = 0; i < a.length(); i++) {
			findOne[i] = a.substring(i, i + 1);

			if (findOne[i].contains("1")) {
				cnt++;
			}
		}
		System.out.println("������ǥ�������� 1�� ����= " + cnt);
		// case1
		int s = 1;
		int s1 = 1;
		int max = 0;
		int min = 0;

		for (s = 1; s < 108; s++) {

			matchesBianary(s);
			if (cnt == matchesBianary(s)) {
				// �� �� A�� ���� ����� ��.0
				if (s < A) {
					if (min < s) {
						min = s;
					}
				}else if (s > A) {
						max = s;
						break;
				}
			} 

		}
		
		System.out.println("��°�="+min+" "+max);

	}

	public static int matchesBianary(int value) {
		String valueBinary = Integer.toBinaryString(value);
		String[] matching = new String[10];
		int Bidx = 0;
		for (int i = 0; i < valueBinary.length(); i++) {
			matching[i] = valueBinary.substring(i, i + 1);

			if (matching[i].contains("1")) {
				Bidx++;
			}
		}
		return Bidx;
	}

}
