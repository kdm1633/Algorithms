public class ChessMetric
{
	public long howMany(int size, int[] start, int[] end, int numMoves) {
		long[][][] nBoard = new long[size][size][numMoves+1];

		int[] dx = {-1,0,1,1,-1,1,0,-1,-2,-1,1,2,2,1,-1,-2};
		int[] dy = {-1,-1,-1,0,0,1,1,1,-1,-2,-2,-1,1,2,2,1};

		nBoard[start[1]][start[0]][0] = 1;
		
		for (int i=1; i <= numMoves; i++) {
			for (int x=0; x < size; x++) {
				for (int y=0; y < size; y++) {
					for (int j=0; j<16; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if(nx<0 || ny<0 || nx>=size || ny>=size) continue;
						
						nBoard[ny][nx][i] += nBoard[y][x][i-1];
					}
				}
			}
		}
		
		return nBoard[end[1]][end[0]][numMoves];
	}

	public static void main(String[] args) {
		ChessMetric c = new ChessMetric();
		System.out.println(c.howMany(3,new int[]{0,0},new int[]{1,0},1));
		System.out.println(c.howMany(3,new int[]{0,0},new int[]{1,2},1));
		System.out.println(c.howMany(3,new int[]{0,0},new int[]{2,2},1));
		System.out.println(c.howMany(3,new int[]{0,0},new int[]{0,0},2));
		System.out.println(c.howMany(100,new int[]{0,0},new int[]{0,99},50));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=269554&rd=4482&pm=1592
