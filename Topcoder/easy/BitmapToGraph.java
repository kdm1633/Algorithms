import java.util.Arrays;
import java.util.TreeSet;

public class BitmapToGraph
{
	int[] dx = {-1,0,1,1,1,0,-1,-1};
	int[] dy = {-1,-1,-1,0,1,1,1,0};

	int n,m;
	String[] bmap;

	char check(int nx, int ny) {
		return (nx<0 || nx>=m || ny<0 || ny>=n) ? '.' : bmap[ny].charAt(nx);
	}
	
	public String[] parse(String[] bitmap) {
		bmap = bitmap;
		n = bitmap.length;
		m = bitmap[0].length();

		int node = 0;
		int[][] num = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (bitmap[i].charAt(j) == 'N')
					num[i][j] = node++;

		boolean[][] e = new boolean[n][m];

		String[] res = new String[node];
		for (int i = 0; i < node; i++) res[i] = "";

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (bitmap[i].charAt(j) == 'N') {
					TreeSet<Integer> set = new TreeSet<Integer>();

					for (int d = 0; d < 8; d++) {
						int nx = j + dx[d];
						int ny = i + dy[d];

						if (check(nx,ny)=='E' && e[ny][nx]) continue;

						int d1 = d;
						int cnt = 0;
						while (check(nx,ny) == 'E') {
							if (check(nx+dx[d1],ny+dy[d1]) == '.') {
								if (check(nx+dx[(d1+7)%8],ny+dy[(d1+7)%8]) != '.')
									d1 = (d1+7)%8;
								else if (check(nx+dx[(d1+1)%8],ny+dy[(d1+1)%8]) != '.')
									d1 = (d1+1)%8;
							}
							nx += dx[d1];
							ny += dy[d1];
							cnt++;
						}
						if (cnt != 0) {
							if (num[i][j] == num[ny][nx]) e[ny-dy[d1]][nx-dx[d1]] = true;
							set.add(num[ny][nx]*100000+cnt*10+d);
						}
					}

					boolean comma = false;
					for (int s : set) {
						if(comma) res[num[i][j]] += ",";
						res[num[i][j]] += s/100000 + ":" + (s%100000)/10;
						comma = true;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BitmapToGraph b = new BitmapToGraph();
		System.out.println(Arrays.toString(b.parse(new String[]{
			"NEEE.....N",
			"....EEEEE.",
			".........."})));
		System.out.println(Arrays.toString(b.parse(new String[]{
			"N.N",
			".E.",
			"N.N"})));
		System.out.println(Arrays.toString(b.parse(new String[]	{
			"N..N..N",
			".E.E.E.",
			"..EEE..",
			"NEEEEEN",
			"..EEE..",
			".E.E.E.",
			"N..N..N"})));
		System.out.println(Arrays.toString(b.parse(new String[]{
			".NE....NE..N",
			"E..E...E.E..",
			"E..E...E.E.E",
			".EE....NE..E"})));
		System.out.println(Arrays.toString(b.parse(new String[]{
			".EE....",
			"E..E...",
			"E..E...",
			"NEEEEE.",
			"...E..E",
			"...E..E",
			"...E..E",
			"....EE."})));
		System.out.println(Arrays.toString(b.parse(new String[]{
			".EE.",
			"N..N",
			".EE."})));
		System.out.println(Arrays.toString(b.parse(new String[]{
			"N..N.........",
			".E.E.........",
			"..EE....EN...",
			"...E.N.E.....",
			"...NEEEEEN...",
			"...E.N.E.....",
			"..EE....EN...",
			".E.E.........",
			"N..N........."})));
	}
}
