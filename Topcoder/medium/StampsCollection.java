public class StampsCollection
{
	boolean[] g;
	int[] u;
	int m;

	public int count(int[] u, int l, int r, int[] p) {
		int[] res = new int[r+2];
		res[r] = 0; res[r+1] = 0;
		for (int i = r-1; i >= 1; i--)
			res[i] = Math.max(res[i+1],p[u[i]] + res[i+2]);
		
		return res[l];
	}

	boolean[][] e;

	public int find(int v, int p, int d) {
		p += d; u[p] = v; g[v] = true;
		for (int i=0; i < m; i++)
			if (e[v][i] && !g[i]) return find(i,p,d);
		return p;
	}

	public int sell(int n, String[] demand, int[] price) {
		m = demand.length;

		int[][] b = new int[m][2];
		for (int i=0; i < m; i++) {
			String[] s = demand[i].split(" ");
			for (int j=0; j < s.length; j++)
				b[i][j] = Integer.parseInt(s[j]);

			if(s.length == 1) b[i][1] = n+i;
		}

		e = new boolean[m][m];
		for (int i=0; i < m; i++)
			for (int j=0; j < m; j++)
				for (int k=0; k < 2; k++)
					for (int l=0; l < 2; l++)
						if(b[i][k] == b[j][l]) e[i][j] = true;

		g = new boolean[m];
		u = new int[2*m];
		int res = 0;
		for (int i=0; i < m; i++) {
			if (!g[i]) {
				u[m] = i; g[i] = true;
				int l = m;
				int r = m+1;
				for (int j=0; j < m; j++)
					if(e[i][j] && !g[j]) {l = find(j,m,-1); break;}
				for (int j=0; j < m; j++)
					if(e[i][j] && !g[j]) {r = find(j,m,1)+1; break;}

				if (!e[u[l]][u[r-1]] || (l+1==r)) res += count(u,l,r,price);
				else res += Math.max(count(u,l+1,r,price),count(u,l,r-1,price));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		StampsCollection s = new StampsCollection();
		System.out.println(s.sell(10, new String[]{"0 4"}, new int[]{3}));
		System.out.println(s.sell(2, new String[]{"1 0","0"}, new int[]{3,5}));
		System.out.println(s.sell(3, new String[]{"0 1","0 2","1 2"}, new int[]{10,11,12}));
		System.out.println(s.sell(3, new String[]{"0","1 0","1 2"}, new int[]{5,9,5}));
		System.out.println(s.sell(20, new String[]{"0 1","1 2","2 3","3 0","4 5","5 6","6 4","8","8","9","9 10","10 11","11 12","12"}, new int[]{3,7,4,1,3,3,1,5,6,5,18,10,1,5}));
	}
}
