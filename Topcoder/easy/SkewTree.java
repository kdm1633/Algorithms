public class SkewTree
{
	int[] probs;
	int[][] best;

	int getAccess(int i1, int i2) {
		int total=0;
		for (int i=i1; i <= i2; i++) total += probs[i];
		return total;
	}

	int getBest(int i1, int i2) {
		if(i1 > i2) return 0;
		if(best[i1][i2]!=0) return best[i1][i2];

		int val=Integer.MAX_VALUE;
		for (int root=i1; root <= i2; root++) {
			int thisVal = getBest(i1,root-1) + getBest(root+1,i2);
			if(thisVal < val) val = thisVal;
		}

		val += getAccess(i1,i2);

		best[i1][i2] = val;

		return val;
	}

	public int bestScore(int[] values, int[] _probs) {
		probs = _probs; best = new int[50][50];
		int n=values.length;

		for (int i=0; i < n; i++) {
			for (int j=i+1; j < n; j++) {
				if (values[i] > values[j]) {
					int tv = values[j]; values[j] = values[i]; values[i] = tv;
					int tp = probs[j]; probs[j] = probs[i]; probs[i] = tp;
				}
			}
		}

		return getBest(0, n-1);
	}

	public static void main(String[] args) {
		SkewTree s = new SkewTree();
		System.out.println(s.bestScore(new int[]{1,2}, new int[]{1,2}));
		System.out.println(s.bestScore(new int[]{1,2,4,3,5,6}, new int[]{1,2,4,3,5,6}));
		System.out.println(s.bestScore(new int[]{6,5,3,7,51,36}, new int[]{65,13,49,62,34,16}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=262936&rd=4497&pm=1641
