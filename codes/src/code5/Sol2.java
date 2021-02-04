package code5;

import java.util.Arrays;

public class Sol2 {

	public static void main(String[] args) throws Exception {
		int i = 2018915346;
		byte[] ii = getLittleEndian(i);
		System.out.println("ddd"+ Arrays.toString(getLittleEndian(i)));
//		System.out.println("ddd"+ getBigEndian(dd));
		System.out.println(getBigEndian(ii));
		
	String a = Integer.toBinaryString(2018915346);
		System.out.println(a);
	
			String[] aa = new String[4];
			while(a.length()<32) {
				a = "0"+a;
				aa[0] = a.substring(0,8);
				aa[1] = a.substring(8,16);
				aa[2] = a.substring(16,24);
				aa[3] = a.substring(24,32);
				for(int j=3; j>=0; j--) {
				System.out.println(aa[j]);
				int b = Integer.parseInt(aa[j],2);
				System.out.println(b);
				
				}
			}
		
		}
		
//		int b= Integer.parseInt(a,2);
//		System.out.println(b);
		
//		Integer.bitCount(i)
	
	public static byte [] getLittleEndian(int i) {
		byte[] input = new byte[4];
		input[3] = (byte)((i >>> 24)& 0xFF);
		input[2] = (byte)((i >>> 16)& 0xFF);
		input[1] = (byte)((i >>> 8)& 0xFF);
		input[0] = (byte)((i >>> 0)& 0xFF);
		return input;
	}
	public static int getBigEndian(byte[] i) throws Exception{
		int[] arr = new int[4];
		for(int k=0; k<4; k++) {
			arr[k] = (int) (i[3-k] & 0xFF);
		}
		return ((arr[0] << 24) + (arr[1] << 16)+ (arr[2] << 8)+ (arr[3]<<0));
	}
}
