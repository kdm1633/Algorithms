public class ProductOfDigits
{
	public int smallestNumber(int N) {
		if(N == 1) return 1;

		int res = 0;
		for (int d=9; d > 1; d--) {
			while (N % d == 0) {
				N /= d;
				res++;
			}
		}

		if (N > 9) return -1;

		return res;
	}

	public static void main(String[] args) {
		ProductOfDigits p = new ProductOfDigits();
		System.out.println(p.smallestNumber(1));
		System.out.println(p.smallestNumber(10));
		System.out.println(p.smallestNumber(26));
		System.out.println(p.smallestNumber(100));
		System.out.println(p.smallestNumber(2520));
		System.out.println(p.smallestNumber(864));
	}
}
