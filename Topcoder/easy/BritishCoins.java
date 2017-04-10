import java.util.Arrays;

public class BritishCoins
{
	public int[] coins(int pence) {
		return new int[]{pence/240, ((pence%240)/12), ((pence%240)%12)};
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
