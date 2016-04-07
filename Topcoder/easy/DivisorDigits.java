import java.util.ArrayList;

public class DivisorDigits
{
	public static int howMany(int number) {
		int cnt=0;
		String s = "" + number;

		for (int i=0; i < s.length(); i++) {
			if(s.charAt(i) == '0') continue;
			if(number % (s.charAt(i)-'0') == 0) cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(howMany(12345));
		System.out.println(howMany(661232));
		System.out.println(howMany(52527));
		System.out.println(howMany(730000000));
	}
}
