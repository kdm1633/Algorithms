import java.util.Arrays;

public class InfiniteSequence2
{
	int p,q,x,y;
	long[] a;

	long dp(long n) {
		if(n <= 0) return 1;
		if (n <= 3000000) {
			if(a[(int)n] != -1) return a[(int)n];
			return a[(int)n] = dp(n/p-x) + dp(n/q-y);
		}

		return dp(n/p-x) + dp(n/q-y);
	}

	public long calc(long n, int p, int q, int x, int y) {
		this.p = p; this.q = q; this.x = x; this.y = y;
		a = new long[3000001];
		Arrays.fill(a,-1);

		return dp(n);
	}

	public static void main(String[] args) {
		InfiniteSequence2 i = new InfiniteSequence2();
		System.out.println(i.calc(10000000,2,3,10000000,10000000));
		System.out.println(i.calc(12,2,3,1,0));
		System.out.println(i.calc(0,2,2,0,0));
		System.out.println(i.calc(123,45,67,8,9));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=20903642&rd=13504&pm=9922
