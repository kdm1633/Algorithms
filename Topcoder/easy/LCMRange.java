public class LCMRange {
	public int lcm(int first, int last) {
		for (int i=last; ; i += last) {
			int j=first;
			for (; j < last; j++)
				if(i%j != 0) break;

			if(j == last) return i;
		}
	}

	public static void main(String[] args) {
		LCMRange l = new LCMRange();
		System.out.println(l.lcm(1,5));
		System.out.println(l.lcm(4,5));
		System.out.println(l.lcm(1,12));
	}
}
