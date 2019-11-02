import java.util.ArrayList;
import java.util.Arrays;

public class WhichData
{
	public int[] bestVariance(int[] sampleData, int varNum, int varDen) {
		Arrays.sort(sampleData);

		int sdLen = sampleData.length;

		double var = (double)varNum/varDen;
		double closest = 10001;
		int[] res = new int[0];

		for (int i = 1; i < Math.pow(2,sdLen); i++) {
			double sum = 0.0;
			double sumOfSquares = 0.0;
			ArrayList<Integer> ss = new ArrayList<Integer>();
			for (int j = i, k = 0; j > 0; j = j>>1,k++) {
				if ((j&1) == 1) {
					sum += sampleData[k];
					sumOfSquares += sampleData[k]*sampleData[k];
					ss.add(sampleData[k]);
				}
			}

			double ssLen = ss.size();
			double svar = sumOfSquares/ssLen - (sum*sum)/(ssLen*ssLen);
			if (Math.abs(var-svar)==closest || Math.abs(Math.abs(var-svar)-closest)<=1e-9) {
				boolean flag = false;
				int len = (res.length < ss.size()) ? res.length : ss.size();
				for (int j = 0; j < len; j++) {
					if (res[j] < ss.get(j)) break;
					else if (res[j] > ss.get(j)) {flag = true; break;}
				}
				if (flag) {
					res = new int[ss.size()];
					for (int j = 0; j < ss.size(); j++)
						res[j] = ss.get(j);
				}
			}
			else if (Math.abs(var-svar) < closest) {
				closest = Math.abs(var-svar);
				res = new int[ss.size()];
				for (int j = 0; j < ss.size(); j++)
					res[j] = ss.get(j);
			}
		}

		return res;
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

// References
// https://www.topcoder.com/tc?module=Static&d1=match_editorials&
