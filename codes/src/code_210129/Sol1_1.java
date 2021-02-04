package code_210129;


public class Sol1_1 {

	public static void main(String[] args) {
		
		String[] ans = new String[10];
		
		ans[0] = "&";
		ans[1] = "~&";
		ans[2] = "<<";
		ans[3] = "^^^";
		ans[4] = "&";
		ans[5] = ">>&";
		ans[6] = "&~<<";
		ans[7] = "^<<";
		ans[8] = "&";
		ans[9] = "^&";

		for(int i=0; i<ans.length; i++) {
			System.out.println("answer("+(i+1)+") = "+ans[i]);
		}
		
		
	}

}
