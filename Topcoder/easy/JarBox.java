public class JarBox
{
	public int numJars(int radius, int woodlength) {
		int m = (woodlength - radius*2*2)/2/(radius*2);

		for (int row=2; ; row++) {
			double width = woodlength - 2*(radius*2 + (row-1)*(2*radius*Math.sqrt(3)*0.5));
			width /= 2;

			int a = (int)width/(radius*2);
			int b = (width%(radius*2) >= radius) ? a : a-1;
			int aa = a * ((row-1)/2+1);
			if(aa == 0) break;
			int bb = b * (row/2);

			m = Math.max(m,aa+bb);
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
