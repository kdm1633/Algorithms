public class Archimedes
{
	public static double approximatePi(int numSides) {
		double d = 2 * Math.PI / numSides / 2;  // 2*Math.PI is 360 degrees.
		return numSides * Math.sin(d);
	}

	public static void main(String[] args) {
		System.out.println(approximatePi(3));
		System.out.println(approximatePi(8));
		System.out.println(approximatePi(17280));
	}
}
