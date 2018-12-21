public class TwoLotteryGames {
	long cbn(long n, long r) {
		long denom=1, numer=1;
		while(r > 0) {denom *= n--; numer *= r--;}
		return denom / numer;
	}

	public double getHigherChanceGame(int n, int m, int k) {
		long res=0;
		for (int i=k; i <= m; i++)
		  res += cbn(m,i) * cbn(n-m,m-i);

		return (double)res/(double)cbn(n,m);
	}

	public static void main(String[] args) {
		TwoLotteryGames t = new TwoLotteryGames();
		System.out.println(t.getHigherChanceGame(3,2,1));
		System.out.println(t.getHigherChanceGame(3,1,1));
		System.out.println(t.getHigherChanceGame(8,2,1));
		System.out.println(t.getHigherChanceGame(8,4,2));
	}
}

// http://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm418
