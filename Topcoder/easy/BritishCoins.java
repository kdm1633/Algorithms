import java.util.Arrays;

public class BritishCoins
{
	public int[] coins(int pence) {
		int[] res = new int[3];

		res[0] = pence/240; pence %= 240;
		res[1] = pence/12; pence %= 12;
		res[2] = pence;

		return res;
	}

	public static void main(String[] args) {
		BritishCoins b = new BritishCoins();
		System.out.println(Arrays.toString(b.coins(533)));
		System.out.println(Arrays.toString(b.coins(0)));
		System.out.println(Arrays.toString(b.coins(6)));
		System.out.println(Arrays.toString(b.coins(4091)));
		System.out.println(Arrays.toString(b.coins(10000)));
	}
}
