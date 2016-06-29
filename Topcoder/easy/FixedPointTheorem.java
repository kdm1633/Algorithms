public class FixedPointTheorem
{
	public double cycleRange(double R) {
		double x=0.25, max=0, min=10;

		for (int i=0; i < 200000; i++)
			x = R * x * (1-x);

		for (int i=0; i < 1000; i++) {
			x = R * x * (1-x);

			if(x > max) max = x;
			if(x < min) min = x;
		}

		return max - min;
	}
		
	public static void main(String[] args) {
		FixedPointTheorem f = new FixedPointTheorem();
		System.out.println(f.cycleRange(0.1));
		System.out.println(f.cycleRange(3.05));
		System.out.println(f.cycleRange(3.4499));
		System.out.println(f.cycleRange(3.55));
		System.out.println(f.cycleRange(3.565));
		System.out.println(f.cycleRange(3.5689));
		System.out.println(f.cycleRange(3.00005));
	}
}
