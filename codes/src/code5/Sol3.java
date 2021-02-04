package code5;


//3. 비밀번호

//(1) A이진수에서 1의갯수 x 찾기
//(2) case1: A보다 작은수 중, 이진수표현에서 1갯수=x이고, A랑가장 가까운수 찾기
// case2: A보다 큰수 중, 이진수 표현에서 1갯수=x이고, A랑가장 가까운 수 찾아 출력

public class Sol3 {

	public static void main(String[] args) {
		int A = 7;
		int B = 7;
		int cnt = 0;
		String a = Integer.toBinaryString(A);
		System.out.println("입력값="+A);
		
		System.out.println("이진수 변환값="+a);
		String[] findOne = new String[6];

		for (int i = 0; i < a.length(); i++) {
			findOne[i] = a.substring(i, i + 1);

			if (findOne[i].contains("1")) {
				cnt++;
			}
		}
		System.out.println("이진수표현값에서 1의 개수= " + cnt);
		// case1
		int s = 1;
		int s1 = 1;
		int max = 0;
		int min = 0;

		for (s = 1; s < 108; s++) {

			matchesBianary(s);
			if (cnt == matchesBianary(s)) {
				// 그 중 A와 가장 가까운 값.0
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
		
		System.out.println("출력값="+min+" "+max);

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
