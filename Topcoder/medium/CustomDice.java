public class CustomDice {
	int mod = 1000000007;

	public int countDice(int M) {
		int rem = M*6-21;

		if (rem < 0) return 0;

		int[] d1 = new int[rem+1];
		int[] d2 = new int[rem+1];

		d2[0] = 1;
		for (int i=1; i <= 6; i++) {
			for (int j=0; j <= rem; j++)
				if (j >= i) d1[j] = (d1[j-i]+d2[j]) % mod;
			for (int j=0; j <= rem; j++)
				d2[j] = d1[j];
		}

		int sum=0;
		for (int i=0; i <= rem; i++)
			sum = (sum+d2[i]) % mod;

		return (int)((30L*sum) % mod);
	}

	public static void main(String[] args) {
		CustomDice c = new CustomDice();
		System.out.println(c.countDice(3));
		System.out.println(c.countDice(4));
		System.out.println(c.countDice(10));
		System.out.println(c.countDice(50));
	}
}

// http://community.topcoder.com/stat?c=problem_solution&cr=22653720&rd=13507&pm=9904
