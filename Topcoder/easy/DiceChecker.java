import java.util.Arrays;

public class DiceChecker
{
	public int[] badValues(int[] values) {
		int t=0;
		int[] r = new int[7];

		for(int i=0; i < values.length; i++)
			r[values[i]]++;

		for(int i=1; i < r.length; i++) {
			float prob = (float) r[i] / values.length;
			if(prob > 0.25 || prob < 0.1) t++;
		}

		int[] res = new int[t];

		for(int i=1,j=0; i < r.length; i++) {
			float prob = (float) r[i] / values.length;
			if(prob > 0.25 || prob < 0.1) res[j++] = i;
		}

		return res;
	}

	public static void main(String[] args) {
		DiceChecker d = new DiceChecker();
		System.out.println(Arrays.toString(d.badValues(new int[]{ 1, 2, 3, 4, 5, 6, 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(d.badValues(new int[]{ 3, 1, 5 })));
		System.out.println(Arrays.toString(d.badValues(new int[]{ 1, 1, 1, 1, 1, 1, 1, 2, 2, 2 })));
		System.out.println(Arrays.toString(d.badValues(new int[]{ 1, 1, 3, 3, 4, 4, 2, 2, 5, 5, 6, 6 })));
	}
}
