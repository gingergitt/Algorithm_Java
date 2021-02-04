package code4;

public class CountingSortAlgorithm {
	public static void main(String[] args) {

		int[] count = new int[6];
		int array[] = { 1, 3, 2, 4, 3, 2, 5, 3, 
				1, 2, 3, 4, 4, 3, 5, 1, 2, 3, 5,
				2, 3, 1, 4, 3, 5, 1, 2, 1, 1, 1 };
		
		for (int i = 1; i <= 5; i++) {
			count[i] = 0;
		}
		
		//array[0]= 1 , array[1]=2, array[2]=2 
		//count[1]=7;
		// count[array[0]]++; -> count[1]++;
		// count[array[1]]++ -> count[3]
		for (int i = 0; i < 30; i++) {
			count[array[i]]++;
//			System.out.println("array="+array[i]);
//			System.out.println("count=?"+count[array[i]++]);
			
		}
		
		for (int i = 1; i <= 5; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					//j=0<count[i]=count[1]
					System.out.print(i + " ");
				}
			}
		}
		
		/*
		 Counting Sort �� �� �迭 ���ҳ��� ���� ���ϴ� ���� �ƴ�, �ε����� ���� ��ġ�� ã�Ƴ����� ���̴�.
		  ���� ���ÿ����� �񱳸� ���� array �� result �迭�� ����������, 
		  ���� ������ �˰��ְ� ����¸� �ϴ� ���̶�� array�� 0��°���� �Է��ϴ°� �ƴ϶� counting ó��
		   �Է� ���ڸ��� �ش� ���� array �迭�� �ε����� ����Ͽ� array �迭 ���� ������Ų ��, 
		   ���� �� �κ��� skip �ϰ� �ٷ� array[0] ���� �ش� �ε����� ���� 0 �� �� �� ���� �ε����� ������ָ� �ȴ�.
		 */
		
		
		
		//  public class counting_sort { 
		/*		public static void main(String[] args) {
		
		int[] arr = new int[101]; // ���� ���� : 0 ~ 100
		 
		for (int i = 0; i < 50; i++) {	// ������ ũ�� : 50 
			arr[(int) (Math.random() * 101)]++;	// 0 ~ 100
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			while(arr[i]-- > 0) {	// arr ���� 0��Ÿ Ŭ ��� 
				System.out.print(i + " ");
			}
		}
			}
			}
		*/
		
		
		
	}
}
