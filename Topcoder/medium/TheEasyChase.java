public class TheEasyChase
{
	int UNKNOWN = 987654321;
	int[][][][][] oldresult = new int[20][20][20][20][2];
	int[][][][][] result = new int[20][20][20][20][2];

	int[] dr = {-1,1,0,0,-2,2,0,0};
	int[] dc = {0,0,-1,1,0,0,-2,2};

	void arraycopy() {
		for (int i = 0; i < 20; i++)
		for (int j = 0; j < 20; j++)
		for (int k = 0; k < 20; k++)
		for (int l = 0; l < 20; l++)
		for (int m = 0; m < 2; m++)
			{oldresult[i][j][k][l][m] = result[i][j][k][l][m];}
	}

	public String winner(int n, int rowWhite, int colWhite, int rowBlack, int colBlack) {
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		for (int k = 0; k < n; k++)
		for (int l = 0; l < n; l++)
		for (int m = 0; m < 2; m++)
			result[i][j][k][l][m] = UNKNOWN;

		int remains = n*n*n*n*2;
		for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			{result[i][j][i][j][0] = result[i][j][i][j][1] = 0; remains -= 2;}

		int currentmove = 0;
		arraycopy();
		while (remains != 0) {
			currentmove++;

			// white move
			for (int rw = 0; rw < n; rw++)
			for (int cw = 0; cw < n; cw++)
			for (int rb = 0; rb < n; rb++)
			for (int cb = 0; cb < n; cb++)
				if (result[rw][cw][rb][cb][0] == UNKNOWN) {
					for (int d = 0; d < 4; d++) {
						int nrw = rw + dr[d], ncw = cw + dc[d];

						if (nrw<0 || nrw>=n || ncw<0 || ncw>=n) continue;

						if (oldresult[nrw][ncw][rb][cb][1] != UNKNOWN) {
							if (oldresult[nrw][ncw][rb][cb][1] <= 0) {
								result[rw][cw][rb][cb][0] = currentmove;
								remains--;
								break;
							}
						}
					}

					if (result[rw][cw][rb][cb][0] == UNKNOWN) {
						boolean knows_all = true;
						for (int d = 0; d < 4; d++) {
							int nrw = rw + dr[d], ncw = cw + dc[d];

							if(nrw<0 || nrw>=n || ncw<0 || ncw>=n) continue;

							if (oldresult[nrw][ncw][rb][cb][1] == UNKNOWN) knows_all = false;
						}

						if (knows_all) {
							result[rw][cw][rb][cb][0] = -currentmove;
							remains--;
						}
					}
				}

			// black move
			for (int rw = 0; rw < n; rw++)
			for (int cw = 0; cw < n; cw++)
			for (int rb = 0; rb < n; rb++)
			for (int cb = 0; cb < n; cb++)
				if (result[rw][cw][rb][cb][1] == UNKNOWN) {
					for (int d = 0; d < 8; d++) {
						int nrb = rb + dr[d], ncb = cb + dc[d];

						if (nrb<0 || nrb>=n || ncb<0 || ncb>=n) continue;

						if (oldresult[rw][cw][nrb][ncb][0] != UNKNOWN) {
							if (oldresult[rw][cw][nrb][ncb][0] <= 0) {
								result[rw][cw][rb][cb][1] = currentmove;
								remains--;
								break;
							}
						}
					}

					if (result[rw][cw][rb][cb][1] == UNKNOWN) {
						boolean knows_all = true;
						for (int d = 0; d < 8; d++) {
							int nrb = rb + dr[d], ncb = cb + dc[d];

							if (nrb<0 || nrb>=n || ncb<0 || ncb>=n) continue;

							if (oldresult[rw][cw][nrb][ncb][0] == UNKNOWN) knows_all = false;
						}

						if (knows_all) {
							result[rw][cw][rb][cb][1] = -currentmove;
							remains--;
						}
					}
				}

			arraycopy();
		}

		String ss;
		if (result[--rowWhite][--colWhite][--rowBlack][--colBlack][0] > 0)
			ss = "WHITE " + result[rowWhite][colWhite][rowBlack][colBlack][0];
		else
			ss = "BLACK " + -result[rowWhite][colWhite][rowBlack][colBlack][0];

		return ss;
	}

	public static void main(String[] args) {
		TheEasyChase t = new TheEasyChase();
		System.out.println(t.winner(2,1,1,2,2));
		System.out.println(t.winner(2,2,2,1,2));
		System.out.println(t.winner(3,1,1,3,3));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&rm=299103&rd=13514&pm=9977&cr=8357090
