import java.util.Arrays;

public class MissingLetters
{
	public String getMissingLetters(String sentence) {
		sentence = sentence.toUpperCase();

		String res = "";
		for (char c = 'A'; c <= 'Z'; c++)
			if (sentence.indexOf(c) == -1)
				res += c;

		return res;
	}

	public static void main(String[] args) {
		MissingLetters m = new MissingLetters();
		System.out.println(m.getMissingLetters("A quick brown fox jumps over the lazy dog"));
		System.out.println(m.getMissingLetters("A slow yellow fox crawls under the proactive dog"));
		System.out.println(m.getMissingLetters("Lions, and tigers, and bears, oh my!"));
		System.out.println(m.getMissingLetters(""));
	}
}
