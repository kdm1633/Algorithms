public class RedIsGood
{
	public double getProfit(int R, int B) {
		double[][] best = new double[2][R+B+1];
		for (int r=1; r <= R; r++) {
			best[r%2][0] = r;
			for (int b=1; b <= B; b++)
				best[r%2][b] = Math.max(0.0,1.*r/(r+b)*(best[1-r%2][b] + 1) + 1.*b/(r+b)*(best[r%2][b-1] - 1));
		}

		return best[R%2][B];
	}

	public static void main(String[] args) {
		RedIsGood r = new RedIsGood();
		System.out.println(r.getProfit(0,7));
		System.out.println(r.getProfit(4,0));
		System.out.println(r.getProfit(5,1));
		System.out.println(r.getProfit(2,2));
		System.out.println(r.getProfit(12,4));
		System.out.println(r.getProfit(11,12));
	}
}

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm420
