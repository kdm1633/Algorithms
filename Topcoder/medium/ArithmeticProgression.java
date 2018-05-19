public class ArithmeticProgression
{
	public double minCommonDifference(int a0, int[] seq) {
		double max = 0.0, min = 10E7;
		for (int i=0; i < seq.length; i++) {
			double d = (double)(seq[i]-a0)/(i+1);
			double limit = (double)(seq[i]-a0+1)/(i+1);
			if(d > max) max = d;
			if(limit < min) min = limit;
		}
		
		return (min > max) ? max : -1;
	}

	public static void main(String[] args) {
		ArithmeticProgression a = new ArithmeticProgression();
		System.out.println(a.minCommonDifference(0,new int[]{6, 13, 20, 27}));
		System.out.println(a.minCommonDifference(1,new int[]{2, 3, 4, 5, 6}));
		System.out.println(a.minCommonDifference(3,new int[]{}));
		System.out.println(a.minCommonDifference(3,new int[]{3, 3, 3, 3, 4}));
		System.out.println(a.minCommonDifference(1,new int[]{-3}));
		System.out.println(a.minCommonDifference(0,new int[]{6,14}));
	}
}
