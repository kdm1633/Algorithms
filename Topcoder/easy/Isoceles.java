import java.util.*;

public class Isoceles {
	int[] x;
	int[] y;

	int dst(int a, int b) {
		return (x[a]-x[b])*(x[a]-x[b])+(y[a]-y[b])*(y[a]-y[b]);
	}
	
	boolean check(int rght, int s1, int s2) {
		int d1=dst(rght, s1);
		int d2=dst(rght, s2);
		
		if (d1!=d2) return false;
		
		int dh = dst(s1,s2);
		return dh==d1+d2;
	}
	
	public int howMany(int[] xs, int[] ys) {
		x=xs;
		y=ys;
		int n = xs.length;
		int cnt=0;
		
		for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) for (int k=j+1; k<n; k++) {
			if (check(i,j,k) || check(j,k,i) || check(k,i,j)) cnt++;  
		}
		
		return cnt;
	}

	public static void main(String[] args)
	{
		Isoceles i = new Isoceles();
		System.out.println(i.howMany(new int[]{0,1,2}, new int[]{0,10,0}));
		System.out.println(i.howMany(new int[]{0,0,5,5}, new int[]{0,5,0,5}));
		System.out.println(i.howMany(new int[]{-1000000,1000000,0}, new int[]{0,0,1000000}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=114853&rd=4371&pm=1169
