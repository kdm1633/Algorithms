public class Inchworm {
	int lcm(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		for (int i=b; ; i+=b)
			if(i%a == 0) return i;
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
