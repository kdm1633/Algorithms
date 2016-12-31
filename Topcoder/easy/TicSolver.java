public class TicSolver
{
	char[][] board;
	char ch;

	int[] y1 = {0,0,2,2,1,0,0,0};
	int[] x1 = {0,2,2,0,0,1,0,2};
	int[] y2 = {0,1,2,1,1,1,1,1};
	int[] x2 = {1,2,1,0,1,1,1,1};
	int[] y3 = {0,2,2,0,1,2,2,2};
	int[] x3 = {2,2,0,0,2,1,2,0};
	
	boolean checkInvalid () {
		boolean O3=false, X3=false;
		int O=0, X=0;

		for (int i=0; i < 3; i++) {
			for (int j=0; j < 3; j++) {
				if(board[i][j] == 'O') O++;
				else if(board[i][j] == 'X') X++;
			}
		}

		for(int i=0; i < 8; i++)
			if(board[y1[i]][x1[i]]=='O' && board[y2[i]][x2[i]]=='O' && board[y3[i]][x3[i]]=='O') {O3=true; break;}

		for(int i=0; i < 8; i++)
			if(board[y1[i]][x1[i]]=='X' && board[y2[i]][x2[i]]=='X' && board[y3[i]][x3[i]]=='X') {X3=true; break;}

		if(O==X+1) ch = 'X';

		if(O==X && !O3) return false;
		else if(O==X+1 && !X3) return false;

		return true;
	}

	boolean checkWin (char ch) {
		for (int i=0; i < 8; i++)
			if(board[y1[i]][x1[i]]==ch && board[y2[i]][x2[i]]==ch && board[y3[i]][x3[i]]==ch) return true;
		
		return false;
	}
	
	void selectSpot(char ch) {
		// 1. Win
		for (int i=0; i < 8; i++) {
			int cnt=0, spot=0, a=0, b=0;
			
			if(board[y1[i]][x1[i]] == ch) cnt++;
			else if(board[y1[i]][x1[i]] == '.') {spot++; a=y1[i]; b=x1[i];}
			
			if(board[y2[i]][x2[i]] == ch) cnt++;
			else if(board[y2[i]][x2[i]] == '.') {spot++; a=y2[i]; b=x2[i];}
			
			if(board[y3[i]][x3[i]] == ch) cnt++;
			else if(board[y3[i]][x3[i]] == '.') {spot++; a=y3[i]; b=x3[i];}
			
			if(cnt==2 && spot==1) {board[a][b] = ch; return;}
		}

		// 2. Defense
		for (int i=0; i < 8; i++) {
			char other = (ch == 'O') ? 'X' : 'O';
			int cnt=0, spot=0, a=0, b=0;
			
			if(board[y1[i]][x1[i]] == other) cnt++;
			else if(board[y1[i]][x1[i]] == '.') {spot++; a=y1[i]; b=x1[i];}
			
			if(board[y2[i]][x2[i]] == other) cnt++;
			else if(board[y2[i]][x2[i]] == '.') {spot++; a=y2[i]; b=x2[i];}
			
			if(board[y3[i]][x3[i]] == other) cnt++;
			else if(board[y3[i]][x3[i]] == '.') {spot++; a=y3[i]; b=x3[i];}
			
			if(cnt==2 && spot==1) {board[a][b] = ch; return;}
		}

		// 3. Best choice
		int a=0, b=0, priority=0, best=0, max=-1;

		for (int i=0; i < 3; i++) {
			for (int j=0; j < 3; j++) {
				if (board[i][j] == '.') {
					if (ch == 'O') {
						if (i==0&&j==0 || i==0&&j==2 || i==2&&j==0 || i==2&&j==2) {
							if(board[0][0]=='O' && (0==i||0==j)) priority=4;
							else if(board[0][2]=='O' && (0==i||2==j)) priority=4;
							else if(board[2][0]=='O' && (2==i||0==j)) priority=4;
							else if(board[2][2]=='O' && (2==i||2==j)) priority=4;
							else priority=3;
						}
						else if(i==1 && j==1) priority=2;
						else priority=1;
					}
					else {
						if(i==1 && j==1) priority=3;
						else if(i==0&&j==1 || i==1&&j==0 || i==1&&j==2 || i==2&&j==1) priority=2;
						else priority=1;
					}

					if(priority<best) continue;
					else if(priority>best && best!=0) {best = priority; a=i; b=j; continue;}

					int n=0;

					board[i][j] = ch;

					for (int k=0; k < 8; k++) {
						int cnt=0, spot=0;
						
						if(board[y1[k]][x1[k]] == ch) cnt++;
						else if(board[y1[k]][x1[k]] == '.') spot++;
						
						if(board[y2[k]][x2[k]] == ch) cnt++;
						else if(board[y2[k]][x2[k]] == '.') spot++;
						
						if(board[y3[k]][x3[k]] == ch) cnt++;
						else if(board[y3[k]][x3[k]] == '.') spot++;

						if(cnt==2 && spot==1) n+=2;
						else if(cnt==1 && spot==2) n+=1;
					}

					board[i][j] = '.';

					if(n>max) {best=priority; max=n; a=i; b=j;}
				}
			}
		}

		board[a][b] = ch;
	}

	void print() {
		System.out.println("----------------------");
		for (int i=0; i < board.length; i++) {
			for (int j=0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
	public String whoWins(String[] sBoard) {
		board = new char[3][3];
		ch = 'O';
		int spots=0;
		
		for (int i=0; i < 3; i++)
			board[i] = sBoard[i].toCharArray();

		if(checkInvalid()) return "INVALID";
		if(checkWin('O')) return "FIRST";
		if(checkWin('X')) return "SECOND";

		for (int i=0; i < 3; i++)
			for (int j=0; j < 3; j++)
				if(board[i][j] == '.') spots++;

		// Test
		while (spots-- > 0) {
			selectSpot(ch);
			if(checkWin(ch)) {
				if(ch == 'O') return "FIRST";
				else return "SECOND";
			}	
			ch = (ch == 'O') ? 'X' : 'O';
		}
		
		return "DRAW";
	}

	public static void main(String[] args) {
		TicSolver t = new TicSolver();
		System.out.println(t.whoWins(new String[]{"OX.","...","..."}));
		System.out.println(t.whoWins(new String[]{"O..", ".X.", "..."}));
		System.out.println(t.whoWins(new String[]{"OXO", "OOX", "X.X"}));
		System.out.println(t.whoWins(new String[]{"OOO", "XX.", "..."}));
		System.out.println(t.whoWins(new String[]{"...", "...", "..."}));
		System.out.println(t.whoWins(new String[]{"O..", "XX.", "..."}));
		System.out.println(t.whoWins(new String[]{"XXX", "OO.", "OO."}));
		System.out.println(t.whoWins(new String[]{"OXO", "X.X", "OXO"}));
		System.out.println(t.whoWins(new String[]{"O.X", "...", "..."}));
		System.out.println(t.whoWins(new String[]{"O..", ".X.", "..O"}));
	}
}
