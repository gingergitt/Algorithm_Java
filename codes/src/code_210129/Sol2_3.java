package code_210129;

public class Sol2_3 {
	public static void main(String[] args) {
		int i = 2018915346;
		
		// getBigendian값
		byte[] input = new byte[4];
		input[3] = (byte) ((i >>> 0));
		input[2] = (byte) ((i >>> 8));
		input[1] = (byte) ((i >>> 16));
		input[0] = (byte) ((i >>> 24));

		// getLittleEndian 값
		int newValue = 0;
		newValue |= (((int) input[3]) << 24) ;
		newValue |= (((int) input[2]) << 16);
		newValue |= (((int) input[1]) << 8) ;
		newValue |= (((int) input[0])) ;
		System.out.println("입력값: "+Integer.toString(i));
		System.out.println("big endian value = 0x" + 
		Integer.toHexString(i) + " (" + input[0] + "," + input[1] + ","
				+ input[2] + "," + input[3] + ")");
		System.out.println("출력값= "+Integer.toString(newValue));
		System.out.println("little endian value = 0x" 
				+ Integer.toHexString(newValue) + " (" + input[3] + "," + input[2]
				+ "," + input[1] + "," + input[0] + ")");

	}

}
