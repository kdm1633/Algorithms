public class GuessTheNumber
{
	public int noGuesses(int upper, int answer) {
		int lower=1, mid=(lower+upper)/2, count=1;
		while(mid != answer) {
			if(mid < answer) lower = mid+1;
			else upper = mid-1;

			mid = (lower+upper)/2;
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		GuessTheNumber g = new GuessTheNumber();
		System.out.println(g.noGuesses(9,6));
		System.out.println(g.noGuesses(1000,750));
		System.out.println(g.noGuesses(643,327));
		System.out.println(g.noGuesses(157,157));
		System.out.println(g.noGuesses(128,64));
	}
}
