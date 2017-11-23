import java.util.Arrays;

public class MineField
{
	int[] dy = {-1, -1, -1,  0, 0,  1, 1, 1};
	int[] dx = {-1,  0,  1, -1, 1, -1, 0, 1};

	public String[] getMineField(String mineLocations) {
		char[][] board = new char[9][9];
		int[] r = new int[mineLocations.length()/5];
		int[] c = new int[mineLocations.length()/5];

		for (int i=0; i < 9; i++)
			for (int j=0; j < 9; j++)
				board[i][j] = '0';
		
		for (int i=1,j=0; i < mineLocations.length(); i+=5) {
			r[j] = mineLocations.charAt(i)-'0';
			c[j++] = mineLocations.charAt(i+2)-'0';
			board[mineLocations.charAt(i)-'0'][mineLocations.charAt(i+2)-'0'] = 'M';
		}

		for (int i=0; i < r.length; i++) {
			for (int k=0; k < 8; k++) {
				int r1 = r[i]+dy[k];
				int c1 = c[i]+dx[k];
				if (r1>=0 && c1>=0 && r1<9 && c1<9 && board[r1][c1]!='M')
					board[r1][c1]++;
			}
		}

		String[] res = new String[9];
		for (int i=0; i < 9; i++)
			res[i] = String.valueOf(board[i]);

		return res;
	}

	public static void main(String[] args) {
		MineField m = new MineField();
		System.out.println(Arrays.toString(m.getMineField("(0,0)(1,0)(2,0)(3,0)(4,0)")));
		System.out.println(Arrays.toString(m.getMineField("(0,0)(0,8)(8,0)(8,8)")));
		System.out.println(Arrays.toString(m.getMineField("(3,2)(3,3)(3,4)(4,2)(4,4)(5,2)(5,3)(5,4)(7,4)(6,7)")));
		System.out.println(Arrays.toString(m.getMineField("")));
	}
}
