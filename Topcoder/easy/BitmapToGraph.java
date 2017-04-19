import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class BitmapToGraph
{
	String[] bmap;
	int[][] npos;
	boolean[][] edges;
	
	ArrayList<Integer> al;
	
	int n,m,pos,ey,ex;
	
	int[] ys = {-1,-1,-1,0,0,1,1,1};
	int[] xs = {-1,0,1,-1,1,-1,0,1};
	
	int[] sy = {1,1,-1,-1,0,0,-1,1};
	int[] sx = {1,-1,1,-1,-1,1,0,0};
	int[] ly = {0,1,-1,0,1,-1,-1,1};
	int[] lx = {1,0,0,-1,-1,1,-1,1};
	int[] ry = {1,0,0,-1,-1,1,-1,1};
	int[] rx = {0,-1,1,0,-1,1,1,-1};
	
	void go(int y, int x, int py, int px, int cnt) {
		int ny = y+(y-py), nx = x+(x-px);
		
		if (ny>=0 && nx>=0 && ny<n && nx<m) {
			if (bmap[ny].charAt(nx) == 'E') {
				go(ny,nx,y,x,cnt+1);
				return;
			}
			else if (bmap[ny].charAt(nx) == 'N') {
				int nl = npos[ny][nx]*10000 + cnt;
				if (npos[ny][nx]==pos) {
					if (al.contains(nl) && edges[y][x]) return;
					edges[ey][ex] = true;
				}
				al.add(nl);
				return;
			}
		}
		
		for (int i=0; i < 8; i++) {
			if ((y-py)==sy[i] && (x-px)==sx[i]) {
				ny = y+ly[i];
				nx = x+lx[i];
				if (ny>=0 && nx>=0 && ny<n && nx<m) {
					if (bmap[ny].charAt(nx) == 'E') {
						go(ny,nx,y,x,cnt+1);
						return;
					}
					else if (bmap[ny].charAt(nx) == 'N') {
						int nl = npos[ny][nx]*10000 + cnt;
						if (npos[ny][nx]==pos) {
							if (al.contains(nl) && edges[y][x]) return;
							edges[ey][ex] = true;
						}
						al.add(nl);
						return;
					}
				}
				ny = y+ry[i];
				nx = x+rx[i];
				if (ny>=0 && nx>=0 && ny<n && nx<m) {
					if (bmap[ny].charAt(nx) == 'E') {
						go(ny,nx,y,x,cnt+1);
						return;
					}
					else if (bmap[ny].charAt(nx) == 'N') {
						int nl = npos[ny][nx]*10000 + cnt;
						if (npos[ny][nx]==pos) {
							if (al.contains(nl) && edges[y][x]) return;
							edges[ey][ex] = true;
						}
						al.add(nl);
						return;
					}
				}
				return;
			}
		}
	}
	
	public String[] parse(String[] bitmap) {
		n = bitmap.length;
		m = bitmap[0].length();
		bmap = bitmap;
		npos = new int[n][m];
		edges = new boolean[n][m];

		int cnt=0;
		for (int i=0; i < n; i++)
			for (int j=0; j < m; j++)
				if (bmap[i].charAt(j) == 'N')
					npos[i][j] = cnt++;
		
		String[] res = new String[cnt];
		for (int i=0; i < cnt; i++)
			res[i] = "";
			
		cnt=0;
		for (int i=0; i < n; i++) {
		for (int j=0; j < m; j++) {
			if (bmap[i].charAt(j) == 'N') {
				pos = npos[i][j];
				al = new ArrayList<Integer>();
				for (int k=0; k < 8; k++) {
					int y = i+ys[k];
					int x = j+xs[k];
					if (y<0 || x<0 || y>=n ||x>=m || bmap[y].charAt(x)!='E') continue;

					ey = y; ex = x;
					go(y,x,i,j,1);
				}

				if (al.size() != 0) {
					Collections.sort(al);
					for (int e : al) {
						if (e < 10000)
							res[cnt] += "0" + ":" + e + ",";
						else
							res[cnt] += e/10000 + ":" + e%10000 + ",";
					}
					res[cnt] = res[cnt].substring(0,res[cnt].length()-1);
				}
				cnt++;
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

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=156216&rd=4701&pm=1882
