public class Mandelbrot
{
	public int iterations(int max, double a, double b) {
		double za = a, zb = b;
		for (int i=0; i <= max; i++) {
			if (za*za+zb*zb > 4) return i;
			double a2 = za*za - zb*zb + a;
			double b2 = 2*za*zb + b;
			za = a2;
			zb = b2;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Mandelbrot m = new Mandelbrot();
		System.out.println(m.iterations(5,1,1));
		System.out.println(m.iterations(2,-1,-1));
		System.out.println(m.iterations(30,.25,.25));
		System.out.println(m.iterations(30,-1.9,0));
		System.out.println(m.iterations(30,.375,.3));
		System.out.println(m.iterations(1,2,2));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=7472513&rd=4701&pm=1172
