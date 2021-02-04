package code6;

//12. ū �� �����
public class Solution12 {


	// ������ ������ ���� ���� ã�� ( ����=number.length()-k)
	public static String solution(String number, int k) {
		StringBuilder ans = new StringBuilder();
		int pos = 0;
		char max;
		int length = number.length()-k;
		if(number.charAt(0)== '0') 
			return "0";
		//number���̿��� k�� ������ ����(length)��ŭ �ݺ��ϱ� 
		for(int i=0; i<length; i++) {
			max='0'; //���⼭ max �ʱ�ȭ
			//�������� ���� ū ���ڸ� �����Ѵ�.
			for(int j=pos; j<=k+i; j++) {
				// 0:1:2:3:4 ��° �ڸ� �߿� ū ���ڸ� ������ 
				// max�� �� ũ�� �׳� ���� (���������� ���� �� ū���� ����)
				if(max<number.charAt(j)) {
					//number.charAt(j)=> 0��°
					max = number.charAt(j); 
					pos = j+1; // 1,2,3,4
				}
			}
			//���ںٿ��ֱ�
			ans.append(max);
			
		}
		return ans.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("number   "+"k"+"  return");
		String[] numbers= {"1924","1231234","4177252841"};
		
		System.out.println(numbers[0]+"  "+"2  "+solution(numbers[0],2));
		System.out.println(numbers[1]+"  "+"3  "+solution(numbers[1],3));
		System.out.println(numbers[2]+"  "+"4  "+solution(numbers[2],4));
	}

}
