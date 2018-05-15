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
  
  // https://community.topcoder.com/stat?c=problem_solution&cr=14927744&rd=12183&pm=8692
