import java.util.Hashtable;

public class InfiniteSequence
{
	int p,q;
	Hashtable<Long,Long> memo;

	long dp(long n) {
		if(memo.containsKey(n)) return memo.get(n);
		
		memo.put(n,dp(n/p) + dp(n/q));

		return memo.get(n);
	}

	public long calc(long n, int p, int q) {
		this.p = p; this.q = q;
		memo = new Hashtable<Long,Long>();
		memo.put(0L,1L);

		return dp(n);
	}

	public static void main(String[] args) {
		InfiniteSequence i = new InfiniteSequence();
		System.out.println(i.calc(0,2,3));
		System.out.println(i.calc(7,2,3));
		System.out.println(i.calc(10000000,3,3));
		System.out.println(i.calc(256,2,4));
		System.out.println(i.calc(1,1000000,1000000));
	}
}
