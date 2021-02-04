package code6;

//11. ���̽�ƽ
/*
- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�. (B->J)
- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.

 */
public class Solution11 {

	

	public static int solution(String name) {
		int answer = 0;
		// ���� ū �̵� ���� ���ʴ�� ������ length���� ���°�. == length -1
		int length = name.length();

		// �ִ�� ���� �� �ִ� min���� ������ ���°�
		int minMove = length - 1;

		for (int i = 0; i < length; i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			// �¿�: ���ӵ� A�� ���忡 ���� �ּ� �������� �޶�����
			int next = i + 1;// ���� ���� ��ġ����
			// �� ���� ��ġ ������ ���°� A��� ��� NEXT++
			while (next < length && name.charAt(next) == 'A') {
				next++;
			}
			// i=�ּ��̵�Ƚ��(JEROEN�̸� 6��)
//minMove = Math.min(minMove, Math.min(i+len-next+ Math.min(i,len-next) ));
			minMove = Math.min(minMove, i + length - next + i);
		} // for

		answer += minMove;

		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println("name  " + " return");
		System.out.println("JEROEN   " + solution("JEROEN"));
		System.out.println("JAN      " + solution("JAN"));
		System.out.println("SONIA    " + solution("SONIA"));
	}

}
