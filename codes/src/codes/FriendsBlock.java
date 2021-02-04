package codes;

import java.util.Arrays;

class FriendsBlock {
	 /*
	  다시이해하기
	  */
	 public int friendsblock(int m, int n, String[] board) {
		 int answer = 0;
		 //1. 1차원 String 배열을 다루기 쉽도록 2차원 char 배열로 만들기
		 char[][] blockmap = new char[n][m];
		 //2. (1,1)부터 현재, 아래, 오른쪽, 오른쪽아래의 블록을 검사한다.
		 for(int i=0; i<board.length; i++) { 
//			 System.out.println(board[i]);
			 for(int j=0; j<board[i].length(); j++) {
				 
				 blockmap[j][i] = board[i].charAt(j); 
//				 System.out.println(board[i].charAt(j));
				 //board[0].charAt(0), board[0].chardAt(1),.... board[0].charAt(4)
				System.out.println(blockmap[j][i]);
			
			 }
		 }
		
		 
		 //3. 검사할 때 4개의블록(같은거) 발견 후 바로 지우면 겹쳐져있는 블록을 확인할 수 없으므로
		 // 4개의 블록을 지우기 위한 2차원 boolean 배열에 인덱스를 세팅한다. (지워도되는지검사)
		 boolean flag=true;
		 while(flag) {
			 flag=false; //지워줄 블록이 있는지 체크하기 위함
			 
			 //지워줄 블록을 표시해 줄 배열
			 int [][] visited = new int [n][m];
			 //4.(1,2)부터 다시 현재,아래, 오른쪽, 오른쪽아래 검사하고(지우기검사) 2차원 boolean 배열에 셋팅
			//5.(n-1,n-1)까지 검사 
			 
			 for(int i=0; i< blockmap.length-1; i++) {
				 for(int j=0; j<blockmap[i].length-1; j++) {
					 if(blockmap[i][j]=='0')
						 continue; //비어있는 블록이다.  
					 
					 //4블록 검사
					 if(blockmap[i][j] == blockmap[i+1][j] && blockmap[i+1][j] == blockmap[i+1][j+1]
							 && blockmap[i][j+1] == blockmap[i+1][j+1] && blockmap[i][j+1]==blockmap[i][j]) {
						 //지워줄 배열을 셋팅
						 visited[i][j] = 1;
						 visited[i+1][j] = 1;
						 visited[i+1][j+1] = 1;
						 visited[i+1][j+1] = 1;
						 visited[i][j+1] = 1;
						 
						 flag = true;  //지워줄 블록이 있기 때문에.
						
					 }
				 }
			 }
//			 System.out.println(Arrays.deepToString(visited));
			 
			 //6. 검사를 마치면,다시 for문으로 2차원 boolean 배열을 검사하고, 이때 지워줄 값이 세팅되어있는 곳을 지워주기
			 for(int i=0; i<visited.length; i++) {
				 for(int j=0; j<visited[i].length; j++) {
					 //지워줄 블록이라면(지워줄 값이 세팅되어있으면 지우기)
					 if(visited[i][j] == 1) {
						 answer ++;
						 //7. 해당 블록을 지우면서 해당 블록보다 위에 있는 블록들을 아래로 내려준다. 
						 for(int k=j-1; k>=0; k--) {
							 blockmap[i][k+1] = blockmap[i][k];
							 blockmap[i][k] = '0'; //비어있는 블록
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
	
		System.out.println("m= "+m+", n= "+n+", board = "+Arrays.toString(board)+", 입력값= "+new FriendsBlock().friendsblock(m, n, board));
		System.out.println("m= "+m2+", n= "+n2+", board = "+Arrays.toString(board2)+", 입력값= "+new FriendsBlock().friendsblock(m2, n2, board2));

	}

}
