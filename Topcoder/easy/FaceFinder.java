import java.util.LinkedList;
import java.awt.Point;

public class FaceFinder
{
	int[][] m;

	void floodfill(int x, int y) 
	{ 
		int[] dx = {0,0,1,-1}; 
		int[] dy = {1,-1,0,0}; 
		LinkedList<Point> q = new LinkedList<Point>(); 
		q.add(new Point(x,y)); 
		m[y][x]=1; 

		while (q.size()!=0) { 
			Point p = q.poll(); 
			for(int i=0; i<4; i++) {
				x = p.x+dx[i];
				y = p.y+dy[i];
				if (x>=0 && y>=0 && x<=402 && y<=402 && m[y][x]==0) {
					q.add(new Point(x,y));
					m[y][x]=1;
				}
			}
		}
	}

	public int howMany(String[] lines) {
		int faces=0;
		m = new int[403][403];

		for (int i=0; i < lines.length; i++) {
			String[] s = lines[i].split(" ");

			int x1 = 4*Integer.parseInt(s[0]), y1 = 4*Integer.parseInt(s[1]);
			int x2 = 4*Integer.parseInt(s[2]), y2 = 4*Integer.parseInt(s[3]);
			int dx = x2-x1, dy = y2-y1;

			if(dx>0) dx=1; if(dx<0) dx=-1; if(dy>0) dy=1; if(dy<0) dy=-1;

			while (x2!=x1 || y2!=y1) {
				m[y1+1][x1+1]=1;
				if(x2!=x1) x1+=dx; if(y2!=y1) y1+=dy;
			}

			m[y1+1][x1+1] = 1;
		}

		for (int i=0; i <= 400; i++) {
			for (int j=0; j <= 400; j++) {
				if (m[i][j] == 0) {
					faces++;
					floodfill(j,i);
				}
			}
		}

		return faces;
	}

	public static void main(String[] args) {
		FaceFinder f = new FaceFinder();
		System.out.println(f.howMany(new String[]{"0 0 100 100","0 100 100 0"}));
		System.out.println(f.howMany(new String[]{"10 10 20 10","10 10 10 20","20 20 10 20","20 20 20 10"}));
		System.out.println(f.howMany(new String[]{"0 0 0 10","1 0 1 10","2 0 2 10","3 0 3 10","4 0 4 10","5 0 5 10","6 0 6 10","7 0 7 10","8 0 8 10","9 0 9 10","10 0 10 10","0 0 10 0","0 1 10 1","0 2 10 2","0 3 10 3","0 4 10 4","0 5 10 5","0 6 10 6","0 7 10 7","0 8 10 8","0 9 10 9","0 10 10 10"}));
		System.out.println(f.howMany(new String[]{"0 0 0 1","0 0 0 2","0 0 0 3","0 0 0 4","0 0 0 5","0 0 1 0","0 0 2 0","0 0 3 0","0 0 4 0","0 0 5 0","5 0 0 5","4 0 0 4","3 0 0 3","2 0 0 2","1 0 0 1"}));
		System.out.println(f.howMany(new String[]{"0 0 0 1", "0 0 1 0", "0 0 1 1", "1 0 1 1", "0 1 1 1", "1 0 0 1"}));
	}
}

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=269554&rd=4491&pm=1657
