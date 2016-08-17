import java.util.HashSet;
import java.awt.Point;

public class BearBall
{
	public int gcd(int a, int b) {
		return b==0 ? a : gcd(b,a%b);
	}

	public int countThrows(int[] x, int[] y) {
		int n = x.length;
		int res = n*(n-1)*2;

		for (int i=0; i < n; i++) {
			HashSet<Point> set = new HashSet<Point>();

			for (int j=0; j < n; j++) {
				if(i==j) continue;

				int dx = x[j] - x[i], dy = y[j] - y[i];
				int g = gcd(Math.abs(dx),Math.abs(dy));
				dx /= g; dy /= g;
				
				set.add(new Point(dx,dy));
			}

			if(set.size()==1) {
				res = 0;
				for (int a=0; a < n; a++) {
					for (int b=0; b < n; b++) {
						if(a==b) continue;
						res += Math.abs(a-b);
					}
				}
				return res;
			}

			res -= set.size();
		}

		return res;
	}

	public static void main(String[] args) {
		BearBall b = new BearBall();
		System.out.println(b.countThrows(new int[]{1,4,2}, new int[]{1,10,7}));
		System.out.println(b.countThrows(new int[]{0,0,0,1,1}, new int[]{0,1,2,0,1}));
		System.out.println(b.countThrows(new int[]{5,7,9,11}, new int[]{4,3,2,1}));
		System.out.println(b.countThrows(new int[]{10,10,50,50,90,	0}, new int[]{5,17,5,17,5,17}));
		System.out.println(b.countThrows(new int[]{-100, -90, -80, -70, -85, -90, 0, 20}, new int[]{-5, -8, -13, -21, -13, -13, -13, -69}));
	}
}
