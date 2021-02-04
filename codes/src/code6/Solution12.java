package code6;

//12. 큰 수 만들기
public class Solution12 {


	// 구간을 나눠서 숫자 조합 찾기 ( 구간=number.length()-k)
	public static String solution(String number, int k) {
		StringBuilder ans = new StringBuilder();
		int pos = 0;
		char max;
		int length = number.length()-k;
		if(number.charAt(0)== '0') 
			return "0";
		//number길이에서 k개 제거한 길이(length)만큼 반복하기 
		for(int i=0; i<length; i++) {
			max='0'; //여기서 max 초기화
			//구간별로 가장 큰 숫자를 저장한다.
			for(int j=pos; j<=k+i; j++) {
				// 0:1:2:3:4 번째 자리 중에 큰 숫자를 저장함 
				// max가 더 크면 그냥 끝남 (그전까지는 점점 더 큰수로 갱신)
				if(max<number.charAt(j)) {
					//number.charAt(j)=> 0번째
					max = number.charAt(j); 
					pos = j+1; // 1,2,3,4
				}
			}
			//숫자붙여주기
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
