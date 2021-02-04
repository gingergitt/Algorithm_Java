package code_210114;

import java.util.StringTokenizer;
//���� ����
class code1_ex {

	public static int code1(String darts) {

		//darts�� "SDT*#���� �и��ϴµ� �� SDT*#���� token���� �����Ѵ�.(true)
	     StringTokenizer st = new StringTokenizer(darts, "SDT*#", true);
	    
	        int[] scores = new int[darts.length() / 2]; //��Ʈ Ƚ���� 3��
//	        System.out.println(Arrays.toString(scores));
	        int i = 0;

	        while (st.hasMoreTokens()) {
	            String idx = st.nextToken();
	            switch (idx) { 
	            case "S":
	                break;
	            case "D":
	                scores[i - 1] = scores[i - 1] * scores[i - 1];
	                break;
	            case "T":
	                scores[i - 1] = scores[i - 1] * scores[i - 1] * scores[i - 1];
	                break;
	            case "*":
	                scores[i - 1] *= 2;
	                if (i >= 2) 
	                    scores[i - 2] *= 2;
	                break;
	            case "#":
	                scores[i - 1] *= -1;
	                break;
	            default:
	                scores[i] = Integer.parseInt(idx);
	                i++;
	            }
	        }
	        int sum = 0;
	        for (int j = 0; j < i; j++) {
	            sum += scores[j];
	        }

	        return sum;
	    }

	public static void main(String[] args) {
	    String[] darts = {"1S2D*3T","1D2S#10S","1D2S0T","1S*2T*3S","1D#2S*3S","1T2D3D#","1D2S3T*"};
	    
	      
	      for(int k=0; k<darts.length; k++) {
	         int result = code1(darts[k]);
	         System.out.println(k+1+"�� darts="+darts[k]+" | "+"answer = "+result);
	      }

	}
}
