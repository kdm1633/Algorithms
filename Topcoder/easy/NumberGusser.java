public class NumberGuesser
{
	public int guess(String leftOver) {
		int s=0;
		for (int i=0; i < leftOver.length(); i++)
			s += leftOver.charAt(i) - '0';

		return 9 - s%9;
	}

	public static void main(String[] args) {
		NumberGuesser n = new NumberGuesser();
		System.out.println(n.guess("087"));
		System.out.println(n.guess("099"));
		System.out.println(n.guess("191"));
		System.out.println(n.guess("689"));
	}
}
