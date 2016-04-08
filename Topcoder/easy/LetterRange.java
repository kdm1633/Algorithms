import java.util.ArrayList;
import java.util.Arrays;

public class LetterRange
{
	public static String[] ranges(String text) {
		ArrayList<String> list = new ArrayList<String>();

		for(char i='a',j; i <= 'z'; i++) {
			if(text.indexOf(i) != -1) {
				for(j=i; text.indexOf(j + 1) != -1; j++) {}
				list.add(i + ":" + j);
				i = j;
			}
		}

		return list.toArray(new String[list.size()]);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(ranges("")));
		System.out.println(Arrays.toString(ranges(" ")));
		System.out.println(Arrays.toString(ranges("aha")));
		System.out.println(Arrays.toString(ranges("xyzzy")));
		System.out.println(Arrays.toString(ranges("and toto too")));
		System.out.println(Arrays.toString(ranges("topcoder quiz")));
		System.out.println(Arrays.toString(ranges("the quick brown fox jumps over the lazy dog")));
	}
}
