public class CakesEqualization
{
	public double fairDivision(int[] weights, int maxCuts) {
		int n = weights.length;
		double res = Double.MAX_VALUE;

		double[] sp = new double[50];
		double[] w = new double[n];

		for (int i=0; i < n; i++) w[i] = weights[i];
		for (int i=0; i < 50; i++) sp[i]=1.0;

		while (true) {
			int k=0;
			double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
      
			for (int i=0; i < n; i++) {
				if(weights[i]/sp[i] > max) {max = weights[i]/sp[i]; k=i;}
				if(weights[i]/sp[i] < min) min = weights[i]/sp[i];
			}

			if(max-min < res) res = max-min;
			if(maxCuts-- == 0) break;
			sp[k]++;
		}

		return res;
	}

	public static void main(String[] args) {
		CakesEqualization c = new CakesEqualization();
		System.out.println(c.fairDivision(new int[]{1, 3}, 2));
		System.out.println(c.fairDivision(new int[]{1, 1, 1, 1, 1}, 4));
		System.out.println(c.fairDivision(new int[]{1, 3}, 1));
		System.out.println(c.fairDivision(new int[]{7, 11, 13}, 10));
		System.out.println(c.fairDivision(new int[]{13, 69, 41, 37, 80}, 27));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&rm=298935&rd=13512&pm=10074&cr=22675302
