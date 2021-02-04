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
		 Counting Sort 는 각 배열 원소끼리 직접 비교하는 것이 아닌, 인덱스를 갖고 위치를 찾아나가는 것이다.
		  위의 예시에서는 비교를 위해 array 와 result 배열이 존재했지만, 
		  수의 범위를 알고있고 입출력만 하는 것이라면 array에 0번째부터 입력하는게 아니라 counting 처럼
		   입력 받자마자 해당 값을 array 배열의 인덱스를 사용하여 array 배열 값을 증가시킨 뒤, 
		   누적 합 부분을 skip 하고 바로 array[0] 부터 해당 인덱스의 값이 0 이 될 때 까지 인덱스를 출력해주면 된다.
		 */
		
		
		
		//  public class counting_sort { 
		/*		public static void main(String[] args) {
		
		int[] arr = new int[101]; // 수의 범위 : 0 ~ 100
		 
		for (int i = 0; i < 50; i++) {	// 수열의 크기 : 50 
			arr[(int) (Math.random() * 101)]++;	// 0 ~ 100
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			while(arr[i]-- > 0) {	// arr 값이 0보타 클 경우 
				System.out.print(i + " ");
			}
		}
			}
			}
		*/
		
		
		
	}
}
