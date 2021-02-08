package code_210208;

import java.util.Arrays;

//2. ���� �ﰢ��
public class algo2 {

	public static void main(String[] args) {

		int[][] triangle = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		System.out.println("triangle="+Arrays.deepToString(triangle)+"  "+"result="+solution(triangle));
	}

	public static int solution(int[][] triangle) {
		//�Ƕ�̵��� �¿� ���� �ش� ���� �� �� ���� -> ���� �������� �迭�� �ֱ�
		int[][] sideTriangle = new int[triangle.length][triangle.length];
 
		sideTriangle[0][0] = triangle[0][0]; // �� �� ������ �� �־��ֱ�
		for (int i = 1; i < triangle.length; i++) {
			sideTriangle[i][0] = sideTriangle[i - 1][0] + triangle[i][0]; //���� �� ��
			sideTriangle[i][i] = sideTriangle[i - 1][i - 1] + triangle[i][i]; //������ �� ��
		}

		//���������� ���� ���ϸ鼭 �ִ��� sideTriangle �迭�� �ֱ�
		for (int i = 2; i < triangle.length; i++) {
			for (int j = 1; j < i; j++) {
				sideTriangle[i][j] = Math.max(sideTriangle[i - 1][j - 1], sideTriangle[i - 1][j]) + triangle[i][j];
			}
		}

		int max = sideTriangle[sideTriangle.length - 1][0];
		for (int i = 1; i < triangle.length; i++) {
			int checkNo = sideTriangle[sideTriangle.length - 1][i];
			if (max < checkNo) {
				max = checkNo; //max�� �� ������ �ٲ��ֱ�
			}
		}
		return max;
	}
}
