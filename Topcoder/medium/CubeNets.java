public class CubeNets
{
	int n,m;
	String[] f;

	int[] di = {-1,0,0,1}, dj = {0,-1,1,0};

	int countPlane(boolean[][] checked, int i, int j, int cnt) {
		checked[i][j] = true;

		for (int k=0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni>=0 && nj>=0 && ni<n && nj<m && f[ni].charAt(nj) == '#' && !checked[ni][nj])
				cnt = countPlane(checked,ni,nj,cnt+1);
		}

		return cnt;
	}

	public String isCubeNet(String[] figure) {
		f = figure;
		n = f.length; m = f[0].length();

		if (n<4 && m<4) return "NO";

		LOOP:
		for (int i=0; i < n; i++) {
			for (int j=0; j < m; j++) {
				if (f[i].charAt(j) == '#') {
					if (countPlane(new boolean[n][m],i,j,1) != 6) return "NO";

					break LOOP;
				}
			}
		}
		
		// 5 planes
		for (int i=4; i < n; i++) {
			boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false;
			for (int j=0; j < m; j++) {
				if (f[i-4].charAt(j) == '#') b1 = true;
				if (f[i-3].charAt(j) == '#') b2 = true;
				if (f[i-2].charAt(j) == '#') b3 = true;
				if (f[i-1].charAt(j) == '#') b4 = true;
				if (f[i].charAt(j) == '#') b5 = true;
			}
			if (b1 && b2 && b3 && b4 && b5) {
				for (int l=1; l < m; l++) {
					int cnt1=0, cnt2=0; 
					for (int k=0; k < n; k++) {
						if (f[k].charAt(l-1) == '#') cnt1++;
						if (f[k].charAt(l) == '#') cnt2++;
					}
					if (cnt1==3 && cnt2==3) return "YES";
				}
				return "NO";
			}
		}

		for (int j=4; j < m; j++) {
			boolean b1 = false, b2 = false, b3 = false, b4 = false, b5 = false;
			for (int i=0; i < n; i++) {
				if (figure[i].charAt(j-4) == '#') b1 = true;
				if (figure[i].charAt(j-3) == '#') b2 = true;
				if (figure[i].charAt(j-2) == '#') b3 = true;
				if (figure[i].charAt(j-1) == '#') b4 = true;
				if (figure[i].charAt(j) == '#') b5 = true;
			}
			if (b1 && b2 && b3 && b4 && b5) {
				for (int k=1; k < n; k++) {
					int cnt1=0, cnt2=0; 
					for (int l=0; l < m; l++) {
						if (f[k-1].charAt(l) == '#') cnt1++;
						if (f[k].charAt(l) == '#') cnt2++;
					}
					if (cnt1==3 && cnt2==3) return "YES";
				}
				return "NO";
			}
		}

		// 4 planes
		for (int i=3; i < n; i++) {
			boolean b1 = false, b2 = false, b3 = false, b4 = false;
			for (int j=0; j < m; j++) {
				if (f[i-3].charAt(j) == '#') b1 = true;
				if (f[i-2].charAt(j) == '#') b2 = true;
				if (f[i-1].charAt(j) == '#') b3 = true;
				if (f[i].charAt(j) == '#') b4 = true;
			}
			if (b1 && b2 && b3 && b4) {
				for (int l=2; l < m; l++) {
					boolean b5 = false, b6 = false, b7 = false;
					for (int k=0; k < n; k++) {
						if (f[k].charAt(l-2) == '#') b5 = true;
						if (f[k].charAt(l-1) == '#') b6 = true;
						if (f[k].charAt(l) == '#') b7 = true;
					}
					if (b5 && b6 && b7) {
						int cnt1=0, cnt2=0;
						for (int k=i-3; k <= i; k++) {
							if (f[k].charAt(l-2) == '#') cnt1++;
							if (f[k].charAt(l) == '#') cnt2++;
						}
						if (cnt1>=3 || cnt2>=3) return "NO";
						else return "YES";
					}
				}
			}
		}

		for (int j=3; j < m; j++) {
			boolean b1 = false, b2 = false, b3 = false, b4 = false;
			for (int i=0; i < n; i++) {
				if (figure[i].charAt(j-3) == '#') b1 = true;
				if (figure[i].charAt(j-2) == '#') b2 = true;
				if (figure[i].charAt(j-1) == '#') b3 = true;
				if (figure[i].charAt(j) == '#') b4 = true;
			}
			if (b1 && b2 && b3 && b4) {
				for (int k=2; k < n; k++) {
					boolean b5 = false, b6 = false, b7 = false;
					for (int l=0; l < m; l++) {
						if (f[k-2].charAt(l) == '#') b5 = true;
						if (f[k-1].charAt(l) == '#') b6 = true;
						if (f[k].charAt(l) == '#') b7 = true;
					}
					if (b5 && b6 && b7) {
						int cnt1=0, cnt2=0;
						for (int l=j-3; l <= j; l++) {
							if (f[k-2].charAt(l) == '#') cnt1++;
							if (f[k].charAt(l) == '#') cnt2++;
						}
						if (cnt1>=3 || cnt2>=3) return "NO";
						else return "YES";
					}
				}
			}
		}

		return "NO";
	}

	public static void main(String[] args) {
		CubeNets c = new CubeNets();
		System.out.println(c.isCubeNet(new String[]{
			"..#.",
			"####",
			"..#."}));
		System.out.println(c.isCubeNet(new String[]{
			"###",
			"###"}));
		System.out.println(c.isCubeNet(new String[]{
			"..#.",
			"####",
			".#.."}));
		System.out.println(c.isCubeNet(new String[]{
			"##..",
			".##.",
			"..##"}));
		System.out.println(c.isCubeNet(new String[]{
			"####",
			"...#",
			"...#"}));
	}
}
