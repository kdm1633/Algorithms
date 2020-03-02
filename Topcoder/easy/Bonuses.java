import java.util.Arrays;

public class Bonuses
{
	public int[] getDivision(int[] points) {
		int len = points.length;
		int sum = 0, extra = 100;
		boolean[] used = new boolean[len];
		int[] percents = new int[len];

		for (int i = 0; i < len; i++)
			sum += points[i];

		for (int i = 0; i < len; i++) {
			percents[i] = 100*points[i] / sum;
			extra -= 100*points[i] / sum;
		}

		while (extra-- > 0) {
			int max = 0, mi = 0;
			for (int i = 0; i < len; i++)
				if (!used[i] && points[i]>max) {max = points[i]; mi = i;}
			used[mi] = true;
			percents[mi]++;
		}

		return percents;
	}

	public static void main(String[] args) {
		Bonuses b = new Bonuses();
		System.out.println(Arrays.toString(b.getDivision(new int[]{1,2,3,4,5})));
		System.out.println(Arrays.toString(b.getDivision(new int[]{5,5,5,5,5,5})));
		System.out.println(Arrays.toString(b.getDivision(new int[]{485, 324, 263, 143, 470, 292, 304, 188, 100, 254, 296, 255, 360, 231, 311, 275, 93, 463, 115, 366, 197, 470})));
	}
}
