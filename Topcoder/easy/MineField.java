import java.util.Arrays;

public class MineField
{
	public String[] getMineField(String mineLocations) {
		char[][] board = new char[9][9];

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				board[i][j] = '0';

		for (int i = 1; i < mineLocations.length(); i+=5) {
			int a = mineLocations.charAt(i) - '0';
			int b = mineLocations.charAt(i+2) - '0';
			board[a][b] = 'M';
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'M') continue;
				for (int r = i-1; r <= i+1; r++) {
					if (r<0 || r>=9) continue;
					for (int c = j-1; c <= j+1; c++)
						if (c>=0 && c<9 && board[r][c] == 'M') board[i][j]++;
				}
			}
		}

		String[] res = new String[9];
		for (int i = 0; i < 9; i++)
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
