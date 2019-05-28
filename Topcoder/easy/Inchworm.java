public class Inchworm {
	public int gcd(int a, int b) {
		return b==0 ? a : gcd(b,a%b);
	}

	int lcm(int a, int b) {
		return a*b / gcd(a,b);
	}

	public int lunchtime(int branch, int rest, int leaf) {
		return branch/lcm(rest, leaf) + 1;
	}

	public static void main(String[] args) {
		Inchworm i = new Inchworm();
		System.out.println(i.lunchtime(11,2,4));
		System.out.println(i.lunchtime(12,6,4));
		System.out.println(i.lunchtime(20,3,7));
		System.out.println(i.lunchtime(21,7,3));
		System.out.println(i.lunchtime(15,16,5));
		System.out.println(i.lunchtime(1000,3,7));
		System.out.println(i.lunchtime(1000,7,3));
	}
}
