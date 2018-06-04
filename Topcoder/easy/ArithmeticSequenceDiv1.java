public class ArithmeticSequenceDiv1 {
	public int findMinCost(int[] x) {
		int n = x.length;
		int min = 10000;
		int maxGap = 0;

		for (int i=0; i < n-1; i++)
			if(Math.abs(x[i+1]-x[i]) > maxGap) maxGap = Math.abs(x[i+1]-x[i]);

		for (int d=-maxGap; d <= maxGap; d++) {
			for (int a=-200; a <= 200; a++) {
				int sum = 0;
				int yi=a;
				for (int i=0; i < n; i++) {
					sum += Math.abs(yi-x[i]);
					yi += d;
				}
				if(sum < min) min = sum;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		ArithmeticSequenceDiv1 a = new ArithmeticSequenceDiv1();
		System.out.println(a.findMinCost(new int[]{1,3,2}));
		System.out.println(a.findMinCost(new int[]{1,1,1,2,3,4,5}));
		System.out.println(a.findMinCost(new int[]{1,2,3,4}));
		System.out.println(a.findMinCost(new int[]{1,5,2,5}));
		System.out.println(a.findMinCost(new int[]{11,33,22}));
		System.out.println(a.findMinCost(new int[]{1,3,5,7,2,4,6}));
	}
}
