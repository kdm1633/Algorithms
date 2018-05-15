import java.util.Arrays;

public class SentenceDecomposition
{
	boolean compare(String s, String sub) {
		char[] a = s.toCharArray();
		char[] b = sub.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i=0; i < a.length; i++)
			if(a[i] != b[i]) return false;
		
		return true;
	}
	
	public int decompose(String sentence, String[] validWords) {
		int n = sentence.length();
		int[] dp = new int[n+1];
		for (int i=1; i < dp.length; i++)
			dp[i] = 51;
		
		for (int i=0; i < dp.length; i++) {
			for (String s : validWords) {
				if(i+s.length() > n) continue;
				
				String sub = sentence.substring(i,i+s.length());
				if (compare(s,sub)) {
					int cost=0;
					for (int j=0; j < s.length(); j++)
						if(s.charAt(j) != sub.charAt(j)) cost++;
					if(dp[i]+cost < dp[i+s.length()]) dp[i+s.length()] = dp[i]+cost;
				}
			}
		}
		
		return (dp[n] != 51) ? dp[n] : -1;
	}
	
	public static void main(String[] args) {
		SentenceDecomposition s = new SentenceDecomposition();
		System.out.println(s.decompose("neotowheret",new String[]{"one", "two", "three", "there"}));
		System.out.println(s.decompose("abba",new String[]{"ab", "ac", "ad"}));
		System.out.println(s.decompose("thisismeaningless",new String[]{"this", "is", "meaningful"}));
		System.out.println(s.decompose("ommwreehisymkiml",new String[]{"we", "were", "here", "my", "is", "mom", "here", "si", "milk", "where", "si"}));
		System.out.println(s.decompose("ogodtsneeencs",new String[]{"go", "good", "do", "sentences", "tense", "scen"}));
		System.out.println(s.decompose("sepawaterords",new String[]{"separate","words"}));
	}
}
// https://community.topcoder.com/stat?c=problem_solution&cr=14927744&rd=12183&pm=8692
