import java.util.Arrays;

public class MatchMaker {
	public static String[] getBestMatches(String[] members, String currentUser, int sf) {
		if(members.length < 2) return new String[0];
		
		int len = members.length;
		int XsLen = members[0].split(" ").length - 3;
		int cIdx=0;
		int resLen=0;
		
		int[] idx = new int[XsLen+1];
		int[][] sfs = new int[XsLen+1][len];
		String[] user = {""};
		
		for(int i=0; i < len; i++) {
			if(members[i].startsWith(currentUser)) {
				user = members[i].split(" ");
				cIdx = i;
				break;
			}
		}
		
		for(int i=0; i < len; i++) {
			int msf=0;
			
			String[] m = members[i].split(" ");
			
			if(!m[1].equals(user[2]) || i == cIdx)
				continue;
			else {
				for(int j=3; j < m.length; j++)
					if(m[j].equals(user[j]))
						msf++;
					
					if(msf >= sf) {
						sfs[msf][idx[msf]++] = i;
						resLen++;
					}
			}
		}
		
		String[] res = new String[resLen];
		
		for(int i=XsLen, k=0; i > 0; i--)
			for(int j=0; j < idx[i]; j++)
				res[k++] = members[sfs[i][j]].substring(0, members[sfs[i][j]].indexOf(' '));
				
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(getBestMatches(new String[]{
			"BOB M M A", "FRED M F A", "JIM F M A", "DAISY F F A"}, "BOB", 1)));
		System.out.println(Arrays.toString(getBestMatches(new String[]{
			"A F F A", "B M F A", "C F M A", "D M M A"}, "A", 1)));
		System.out.println(Arrays.toString(getBestMatches(new String[]{
			"BETTY F M A C", "TOM M F A C", "SUE F M D C", "ELLEN F M A C", 
			"JOE M F A C", "ED M F A C", "SALLY F M C C", "MARGE F M A C"}, "MARGE", 2)));
		System.out.println(Arrays.toString(getBestMatches(new String[]	{
			"BETTY F M A A C C", "TOM M F A D C A", "SUE F M D D D D", "ELLEN F M A A C A", 
			"JOE M F A A C A", "ED M F A D D A", "SALLY F M C D A B", "MARGE F M A A C C"}, "JOE", 1)));
	}
}
