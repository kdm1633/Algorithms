import java.util.Arrays;

public class WhichData
{
	int n;
	double var, closest;
	int[] sd, cd;
	boolean[] used;

	void calVar(int[] subset) {
		double sum=0.0;
		double num = (double)subset.length;
		for (int i=0; i < subset.length; i++)
			sum += subset[i];
		
		double mean = sum / num;

		double varSum=0.0;
		for (int i=0; i < subset.length; i++)
			varSum += (mean-subset[i])*(mean-subset[i]);
		
		double variance = varSum / num;

		if (Math.abs(var-variance) == closest || Math.abs(Math.abs(var-variance)-closest)<=1e-9) {
			int len = (subset.length < cd.length) ? subset.length : cd.length;
			int i=0;
			for (; i < len; i++) {
				if(subset[i] > cd[i]) return;
				else if(subset[i] < cd[i]) {
					cd = new int[subset.length];
					System.arraycopy(subset,0,cd,0,subset.length);
					return;
				}
			}
			cd = new int[subset.length];
			System.arraycopy(subset,0,cd,0,subset.length);
		}
		else if (Math.abs(var-variance) < closest) {
			closest = Math.abs(var-variance);
			cd = new int[subset.length];
			System.arraycopy(subset,0,cd,0,subset.length);
		}
	}

	void makeSubset(int[] subset, int idx) {
		for (int i=idx; i < n; i++) {
			int[] ss = new int[subset.length+1];
			System.arraycopy(subset,0,ss,0,subset.length);

			ss[ss.length-1] = sd[i];
			Arrays.sort(ss);
			calVar(ss);

			makeSubset(ss,i+1);
		}
	}

	public int[] bestVariance(int[] sampleData, int varNum, int varDen) {
		n = sampleData.length;
		sd = sampleData;
		used = new boolean[n];

		var = (double)varNum/varDen;
		closest=10001;

		makeSubset(new int[0],0);
		
		return cd;
	}

	public static void main(String[] args) {
		WhichData w = new WhichData();
		System.out.println(Arrays.toString(w.bestVariance(new int[]{1,2,3,4,5,6,7,8},40,20)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{1,2,3,4,5,6,7,8},6,1)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{-10000,10000,-9999,9999,-9998,9000},10000,1)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{-10000,10000,-9999,9999,-9998,9998,1,1,2,2},9999,10000)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{500,500,500,500,500,500,500,580,100,100,100,100,100,100,100,180},700,1)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{10,10,10,10,10,10},0,9999)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{2,5,8,15,-14,0,-2,3,0,-10,-3,-9,6,-13,4,-1},5787,170)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{-14,-3,-1,10,-5,0,13,6,11,9,5,6,3,-2,0,2},5061,225)));
		System.out.println(Arrays.toString(w.bestVariance(new int[]{0,-13,15,5,5,-7,-6,-7,-8,4,-12,-13,14,9,-3,-1},9262,197)));
	}
}
