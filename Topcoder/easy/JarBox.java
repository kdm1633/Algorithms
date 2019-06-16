public class JarBox
{
	public int numJars(int radius, int woodlength) {
		int m = 1;

		for (int row=2; ; row++) {
			double h = 2*radius + (row-1)*Math.sqrt(3)*radius;
			double w = (woodlength - 2*h) / 2;
			if (w <= 0) break;
			int wnum = (int)(w / (2*radius));
			int tot = (w%(2*radius) >= radius) ? wnum * row : wnum*((row-1)/2+1) + (wnum-1)*(row/2);
			m = Math.max(m,tot);
		}

		return m;
	}

	public static void main(String[] args) {
		JarBox j = new JarBox();
		System.out.println(j.numJars(1,8));
		System.out.println(j.numJars(1,16));
		System.out.println(j.numJars(1,18));
		System.out.println(j.numJars(1,45));
		System.out.println(j.numJars(6,1269));
	}
}
