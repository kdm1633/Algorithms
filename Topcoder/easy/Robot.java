public class Robot {
	static int[] dx = {-1,  0,  1,-1, 1, -1, 0, 1 };
	static int[] dy = {-1, -1, -1, 0, 0,  1, 1, 1 };

	public int getProb(String[] floor, int x, int y, int time) {
		int rx = 0;
		int ry = 0;
		for (int cx=0; cx<floor[0].length(); cx++) {
			for (int cy=0; cy<floor.length; cy++) {
				if (floor[cy].charAt(cx)=='R') {
					rx=cx;
					ry=cy;
				}
			}
		}

		int sx = floor[0].length();
		int sy = floor.length;

		double[][] cp = new double[sx][sy];
		cp[rx][ry]=1;

		for (int t=0; t<time; t++) {
			double[][] np = new double[sx][sy];

			for (int cx=0; cx<sx; cx++) {
				for (int cy=0; cy<sy; cy++) {
					int nmoves=0;

					for (int d=0; d<8; d++) {
						int nx = cx+dx[d];
						int ny = cy+dy[d];

						if (nx<0 || nx>=sx) continue;
						if (ny<0 || ny>=sy) continue;

						if (floor[ny].charAt(nx)=='X') continue;
						if (floor[cy].charAt(nx)=='X' || floor[ny].charAt(cx)=='X') continue;

						//System.out.println(""+nx+" "+ny+" "+cx+" "+cy);
						np[nx][ny]+=cp[cx][cy]/8;
						nmoves++;
					}

					np[cx][cy]+=(cp[cx][cy]*(8-nmoves))/8;
				}
			}
			cp=np;
		}

		return (int)(cp[x][y]*1000);
	}

	public static void main(String[] args) {
		Robot r = new Robot();
		System.out.println(r.getProb(new String[]{
			"R.XX",
			"..XX",
			"..XX",
			"...."},3,3,7));
		System.out.println(r.getProb(new String[]{"RX","X."},1,1,10));
		System.out.println(r.getProb(new String[]{"RX","X."},0,1,1000));
		System.out.println(r.getProb(new String[]{"R."},0,0,10));
		System.out.println(r.getProb(new String[]{"RX"},1,0,10));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=114853&rd=4497&pm=1583
