import java.util.Arrays;
import java.util.TreeSet;

public class QuadraticRoots
{
	public int[] findRoots(int[] a, int[] b, int[] c) {
		TreeSet<Integer> s = new TreeSet<Integer>();
		for (int i=0; i < a.length; i++) {
			for (int j=0; j < b.length; j++) {
				for (int k=0; k < c.length; k++) {
					double xp = (-b[j] + Math.sqrt(b[j]*b[j] - 4*a[i]*c[k])) / (2*a[i]);
					double xm = (-b[j] - Math.sqrt(b[j]*b[j] - 4*a[i]*c[k])) / (2*a[i]);
					if(xp%1 == 0) s.add((int)xp);
					if(xm%1 == 0) s.add((int)xm);
				}
			}
		}
		
		int[] values = new int[s.size()];
		int i=0;
		for (int x : s)
			values[i++] = x;
		
		return values;
	}
	
	public static void main(String[] args) {
		QuadraticRoots q = new QuadraticRoots();
		System.out.println(Arrays.toString(q.findRoots(new int[]{1}, new int[]{2,3}, new int[]{2,1})));
		System.out.println(Arrays.toString(q.findRoots(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}, new int[]{1}, new int[]{1})));
		System.out.println(Arrays.toString(q.findRoots(new int[]{1}, new int[]{0}, new int[]{-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16})));
		System.out.println(Arrays.toString(q.findRoots(new int[]{1,1,2,2,3,3,4,4}, new int[]{1,1,2,2,3,3,4,4}, new int[]{1,1,2,2,3,3,4,4})));
		System.out.println(Arrays.toString(q.findRoots(new int[]{1,10000,-10000}, new int[]{0,1,10000,-10000}, new int[]{0,1,10000,-10000})));
	}
}
