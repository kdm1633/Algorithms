public class EyeDrops
{
	public double closest(int sleepTime, int k) {
		if (sleepTime < 24.0/k)
			return 24.0/k * 60;
		else
			return (24.0-sleepTime)/(k-1) * 60;
	}

	public static void main(String[] args) {
		EyeDrops e = new EyeDrops();
		System.out.println(e.closest(8,2));
		System.out.println(e.closest(9,3));
		System.out.println(e.closest(23,1));
		System.out.println(e.closest(9,8));
	}
}
