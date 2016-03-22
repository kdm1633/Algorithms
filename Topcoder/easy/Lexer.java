import java.util.ArrayList;
import java.util.Arrays;

public class Lexer {
	public static String[] tokenize(String[] tokens, String input) {
		ArrayList<String> a = new ArrayList<String>();
		String consume;

	        while(input.length() > 0) {
	            consume = "";
	
	            for (int j=0; j < tokens.length; j++)
	                if(input.startsWith(tokens[j]) && consume.length() < tokens[j].length())
				consume = tokens[j];
	
			if(consume.equals(""))
				input = input.substring(1);
			else {
				a.add(consume);
				input = input.substring(consume.length());
			}
	        }

		return a.toArray(new String[a.size()]);
	}

	public static void main(String[] args) {
		String[] a = tokenize(new String[]{"ab","aba","A"}, "ababbbaAab");

		System.out.println(Arrays.toString(a));

		a = tokenize(new String[]{"a","a","aa","aaa","aaaa","aaaaa","aa"}, "aaaaaaaaaaaaaaaaaaaaaaaaa");

		System.out.println(Arrays.toString(a));
	}
}

// REFERENCES
// https://github.com/charles-wangkai/topcoder/blob/master/Lexer.java
