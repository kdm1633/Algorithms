import java.util.Arrays;

public class BinaryCode {
	public String[] decode(String message) {
		int n = message.length();
		int[] P = new int[n+2];
		int[] Q = new int[n];
		String[] res = new String[2];

		for (int i = 0; i < n; i++)
			Q[i] = message.charAt(i) - '0';

		for (int i = 0; i < n; i++) {
			P[i+1] = Q[i] - P[i+2] - P[i];
			if (P[i+1] > 1) {
				res[0] = "NONE";
				break;
			}
		}

		P[1] = 1;
		for (int i = 0; i < n; i++) {
			P[i+1] = Q[i] - P[i+2] - P[i];
			if (P[i+1] > 1) {
				res[1] = "NONE";
				break;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryCode b = new BinaryCode();
		System.out.println(Arrays.toString(b.decode("123210122")));
		System.out.println(Arrays.toString(b.decode("11")));
		System.out.println(Arrays.toString(b.decode("22111")));
		System.out.println(Arrays.toString(b.decode("123210120")));
		System.out.println(Arrays.toString(b.decode("3")));
		System.out.println(Arrays.toString(b.decode("12221112222221112221111111112221111")));
		System.out.println(Arrays.toString(b.decode("0")));
		System.out.println(Arrays.toString(b.decode("1")));
		System.out.println(Arrays.toString(b.decode("2")));
		System.out.println(Arrays.toString(b.decode("00")));
		System.out.println(Arrays.toString(b.decode("22")));
		System.out.println(Arrays.toString(b.decode("000")));
		System.out.println(Arrays.toString(b.decode("011")));
		System.out.println(Arrays.toString(b.decode("111")));
		System.out.println(Arrays.toString(b.decode("122")));
		System.out.println(Arrays.toString(b.decode("121")));
		System.out.println(Arrays.toString(b.decode("232")));
		System.out.println(Arrays.toString(b.decode("11111")));
		System.out.println(Arrays.toString(b.decode("12221")));
		System.out.println(Arrays.toString(b.decode("12221112221112222222222221112222221111112221112221")));
		System.out.println(Arrays.toString(b.decode("11112222222221112222221111112221111112221112221111")));
		System.out.println(Arrays.toString(b.decode("12221111111111112222221112221111111111111112222221")));
		System.out.println(Arrays.toString(b.decode("12221112222222222222222221112221111112222221111111")));
		System.out.println(Arrays.toString(b.decode("11111112222222222221112221111112221111112221111111")));
		System.out.println(Arrays.toString(b.decode("2211121100122223333332211000000123322111232222")));
		System.out.println(Arrays.toString(b.decode("2322222233321001221123210001232100001111233321000")));
		System.out.println(Arrays.toString(b.decode("11211111000001233332222222222222212221122")));
		System.out.println(Arrays.toString(b.decode("23222321112122333221112321122100011100122")));
		System.out.println(Arrays.toString(b.decode("00001233321112222221001232223321001111222110")));
		System.out.println(Arrays.toString(b.decode("3322220301103123301212012200321013203020302120323")));
		System.out.println(Arrays.toString(b.decode("111323012211013231000233331110223030100330")));
		System.out.println(Arrays.toString(b.decode("30120230303312331303233023113010030303331011023")));
		System.out.println(Arrays.toString(b.decode("2211121100122223333332211000000123322111232221")));
		System.out.println(Arrays.toString(b.decode("2322222233321001221123210001232100001111233321001")));
		System.out.println(Arrays.toString(b.decode("11211111000001233332222222222222212221121")));
		System.out.println(Arrays.toString(b.decode("23222321112122333221112321122100011100121")));
		System.out.println(Arrays.toString(b.decode("00001233321112222221001232223321001111222111")));
		System.out.println(Arrays.toString(b.decode("11")));
		System.out.println(Arrays.toString(b.decode("0")));
		System.out.println(Arrays.toString(b.decode("123210120")));
		System.out.println(Arrays.toString(b.decode("12311221")));
		System.out.println(Arrays.toString(b.decode("001")));
		System.out.println(Arrays.toString(b.decode("3")));
		System.out.println(Arrays.toString(b.decode("1")));
		System.out.println(Arrays.toString(b.decode("1222111222221")));
		System.out.println(Arrays.toString(b.decode("2222")));
		System.out.println(Arrays.toString(b.decode("132131021")));
		System.out.println(Arrays.toString(b.decode("12221112222221112221111111112221111")));
		System.out.println(Arrays.toString(b.decode("10")));
		System.out.println(Arrays.toString(b.decode("12")));
		System.out.println(Arrays.toString(b.decode("2")));
		System.out.println(Arrays.toString(b.decode("2322")));
		System.out.println(Arrays.toString(b.decode("123210122")));
		System.out.println(Arrays.toString(b.decode("11")));
		System.out.println(Arrays.toString(b.decode("0")));
		System.out.println(Arrays.toString(b.decode("123210120")));
		System.out.println(Arrays.toString(b.decode("12311221")));
		System.out.println(Arrays.toString(b.decode("001")));
		System.out.println(Arrays.toString(b.decode("3")));
		System.out.println(Arrays.toString(b.decode("1")));
		System.out.println(Arrays.toString(b.decode("1222111222221")));
		System.out.println(Arrays.toString(b.decode("2222")));
		System.out.println(Arrays.toString(b.decode("132131021")));
		System.out.println(Arrays.toString(b.decode("12221112222221112221111111112221111")));
		System.out.println(Arrays.toString(b.decode("10")));
		System.out.println(Arrays.toString(b.decode("12")));
		System.out.println(Arrays.toString(b.decode("2")));
		System.out.println(Arrays.toString(b.decode("2322")));
		System.out.println(Arrays.toString(b.decode("123210122")));
	}
}

// This problem didn't work at arena so that you should check all possible inputs for yourself.
