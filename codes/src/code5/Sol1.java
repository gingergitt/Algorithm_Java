package code5;

import java.util.Scanner;

public class Sol1 {
/*
 (1) a가 홀수인지 if문과 비트 연산자를 이용하여 판별하고자 한다. ?자리에 들어갈 비트연산자는?
   if(a ? 1){}   /// c, c++인 경우 
   if((a ?1) == 1 )) {} /// java의 경우

 */
	public static void main(String[] args) {
		
		String[] ans = new String[10];
		
		ans[0] = "&";
		ans[1] = "~&";
		ans[2] = "<<";
		ans[3] = "^^^";
		ans[4] = "&";
		ans[5] = ">>&";
		//1비트를 왼쪽으로 k 번 밀고 부호 반전하면 k자리만 0이고 나머지는 1
		// 그리고 그 상태에서 AND연산시 k자리만 0으로 바뀐다.
		ans[6] = "&~<<";
		// 1비트를 왼쪽으로 k번 밀고 XOR 해주면 비트가 바뀜
		ans[7] = "^<<";
		// 1비트만 1이어야 2의 제곱수 -1 해서 and 하면
		// 비트가 1개일 경우 아래 비트가 1로 깔리면서 and 연산시 0
		// 2개 이상일 경우 가장 왼쪽에 있는 비트가 1로 남아있어서 and 연산시 >0
		ans[8] = "&";
		// 다른비트들을 XOR로 뽑고 거기서 1을 빼면 
		// 같은 비트가 1개일 경우 아래 비트가 1로 깔리면서 and 연산시 0
		// 2개 이상일 경우 가장 왼쪽에 있는 비트가 1로 남아있어서 and 연산시 >0
		ans[9] = "^&";

		for(int i=0; i<ans.length; i++) {
			System.out.println("answer("+(i+1)+") = "+ans[i]);
		}
		
		
	}

}
