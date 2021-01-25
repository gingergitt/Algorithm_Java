package codes;

import java.util.Arrays;

class FriendsBlock {
	 /*
	  �ٽ������ϱ�
	  */
	 public int friendsblock(int m, int n, String[] board) {
		 int answer = 0;
		 //1. 1���� String �迭�� �ٷ�� ������ 2���� char �迭�� �����
		 char[][] blockmap = new char[n][m];
		 //2. (1,1)���� ����, �Ʒ�, ������, �����ʾƷ��� ����� �˻��Ѵ�.
		 for(int i=0; i<board.length; i++) { 
//			 System.out.println(board[i]);
			 for(int j=0; j<board[i].length(); j++) {
				 
				 blockmap[j][i] = board[i].charAt(j); 
//				 System.out.println(board[i].charAt(j));
				 //board[0].charAt(0), board[0].chardAt(1),.... board[0].charAt(4)
				System.out.println(blockmap[j][i]);
			
			 }
		 }
		
		 
		 //3. �˻��� �� 4���Ǻ��(������) �߰� �� �ٷ� ����� �������ִ� ����� Ȯ���� �� �����Ƿ�
		 // 4���� ����� ����� ���� 2���� boolean �迭�� �ε����� �����Ѵ�. (�������Ǵ����˻�)
		 boolean flag=true;
		 while(flag) {
			 flag=false; //������ ����� �ִ��� üũ�ϱ� ����
			 
			 //������ ����� ǥ���� �� �迭
			 int [][] visited = new int [n][m];
			 //4.(1,2)���� �ٽ� ����,�Ʒ�, ������, �����ʾƷ� �˻��ϰ�(�����˻�) 2���� boolean �迭�� ����
			//5.(n-1,n-1)���� �˻� 
			 
			 for(int i=0; i< blockmap.length-1; i++) {
				 for(int j=0; j<blockmap[i].length-1; j++) {
					 if(blockmap[i][j]=='0')
						 continue; //����ִ� ����̴�.  
					 
					 //4��� �˻�
					 if(blockmap[i][j] == blockmap[i+1][j] && blockmap[i+1][j] == blockmap[i+1][j+1]
							 && blockmap[i][j+1] == blockmap[i+1][j+1] && blockmap[i][j+1]==blockmap[i][j]) {
						 //������ �迭�� ����
						 visited[i][j] = 1;
						 visited[i+1][j] = 1;
						 visited[i+1][j+1] = 1;
						 visited[i+1][j+1] = 1;
						 visited[i][j+1] = 1;
						 
						 flag = true;  //������ ����� �ֱ� ������.
						
					 }
				 }
			 }
//			 System.out.println(Arrays.deepToString(visited));
			 
			 //6. �˻縦 ��ġ��,�ٽ� for������ 2���� boolean �迭�� �˻��ϰ�, �̶� ������ ���� ���õǾ��ִ� ���� �����ֱ�
			 for(int i=0; i<visited.length; i++) {
				 for(int j=0; j<visited[i].length; j++) {
					 //������ ����̶��(������ ���� ���õǾ������� �����)
					 if(visited[i][j] == 1) {
						 answer ++;
						 //7. �ش� ����� ����鼭 �ش� ��Ϻ��� ���� �ִ� ��ϵ��� �Ʒ��� �����ش�. 
						 for(int k=j-1; k>=0; k--) {
							 blockmap[i][k+1] = blockmap[i][k];
							 blockmap[i][k] = '0'; //����ִ� ���
						 }
					 }
				 }
			 }
			
		 }
		 
		
		 
		 
		 
		 return answer;
	 }

	public static void main(String[] args) {

		int m = 4;
		int n =5;
		int m2= 6;
		int n2 =6;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
	
		System.out.println("m= "+m+", n= "+n+", board = "+Arrays.toString(board)+", �Է°�= "+new FriendsBlock().friendsblock(m, n, board));
		System.out.println("m= "+m2+", n= "+n2+", board = "+Arrays.toString(board2)+", �Է°�= "+new FriendsBlock().friendsblock(m2, n2, board2));

	}

}
