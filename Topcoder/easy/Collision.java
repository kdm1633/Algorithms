public class Collision
{
	public double probability(int[] ass, int ids) {
		double res1=1, res2=1;
		int n=ids, d1=ids, d2=ids;

		for(int i=0; i < ass.length; i++) {
			d1=ids;
			for(int j=0; j < ass[i]; j++) {
				res1 = res1 * n / d1;
				res2 = res2 * n / d2;
				n--;
				d1--;
			}
		}

		if(n<0) return 0;

		return res1-res2;
	}

	public static void main(String[] args) {
		Collision c = new Collision();
		System.out.println(c.probability(new int[]{20,20}, 1000));
		System.out.println(c.probability(new int[]{123,456}, 123456));
		System.out.println(c.probability(new int[]{10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000,10000}, 2147483647));
		System.out.println(c.probability(new int[]{1005,1005}, 1000));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=7311097&rd=4570&pm=1771
