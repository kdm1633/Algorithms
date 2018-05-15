import java.util.Arrays;

public class ClosestRegex
{
	class Pair {
		int first;
		String second;
		
		Pair (int first) {
			this.first = first;
		}
		
		Pair (int first, String second) {
			this.first = first;
			this.second = second;
		}
		
		Pair (Pair p) {
			this.first = p.first;
			this.second = p.second;
		}
	}
	
	Pair min(Pair a, Pair b) {
		if(a.first < b.first) return a;
		else if(a.first > b.first) return b;
		
		for (int i=0; i < a.second.length(); i++) {
			if(a.second.charAt(i) < b.second.charAt(i)) return a;
			else if(a.second.charAt(i) > b.second.charAt(i)) return b;
		}
		
		return a;
	}
	
	public String closestString(String text, String regex) {
		char[] t = text.toCharArray();
		
		int cnt=0;
		for (int i=0; i < regex.length(); i++)
			if(regex.charAt(i) != '*') cnt++;
		
		char[] r = new char[cnt];
		
		for (int i=0,j=0; i < regex.length(); i++) {
			if(i==regex.length()-1 || regex.charAt(i+1)!='*') r[j++] = regex.charAt(i);
			else {r[j++] = (char)('A' + (regex.charAt(i)-'a')); i++;}
		}
		
		Pair[][] d = new Pair[r.length+1][t.length+1];
		
		d[0][0] = new Pair(0,"");
		for(int j=1; j <= t.length; j++)
			d[0][j] = new Pair(-1);
		for(int i=1; i <= r.length; i++)
			d[i][0] = new Pair(-1);
		
		for (int i=1; i <= r.length; i++) {
			if(r[i-1] >= 'a') break;
			d[i][0] = new Pair(0,"");
		}
		
		for (int j=1; j <= t.length; j++) {
			for (int i=1; i <= r.length; i++) {
				d[i][j] = new Pair(987);
				Pair tmp;
				
				if(r[i-1]<'a' && d[i-1][j].first!=-1) d[i][j] = new Pair(d[i-1][j]);

				if (t[j-1]==r[i-1] && d[i-1][j-1].first!=-1) {
					tmp = new Pair(d[i-1][j-1]);
					tmp.second += t[j-1];
					d[i][j] = min(d[i][j],tmp);
				}
				else if (t[j-1]==(char)(r[i-1]-'A'+'a') && d[i][j-1].first!=-1) {
					tmp = new Pair(d[i][j-1]);
					tmp.second += t[j-1];
					d[i][j] = min(d[i][j],tmp);
				}

				if (r[i-1]<'a' && d[i][j-1].first!=-1) {
					tmp = new Pair(d[i][j-1]);
					tmp.first++;
					tmp.second += (char)(r[i-1]-'A'+'a');
					d[i][j] = min(d[i][j],tmp);
				}
				else if (r[i-1]>='a' && d[i-1][j-1].first!=-1) {
					tmp = new Pair(d[i-1][j-1]);
					tmp.first++;
					tmp.second += r[i-1];
					d[i][j] = min(d[i][j],tmp);
				}
				
				if(d[i][j].first == 987) d[i][j].first = -1;
			}
		}
		
		if(d[r.length][t.length].first != -1) return d[r.length][t.length].second;

		return "";
	}

	public static void main(String[] args) {
		ClosestRegex c = new ClosestRegex();
		System.out.println(c.closestString("abcd","bcdd"));	// "bcdd"
		System.out.println(c.closestString("topcoder","t*px*coa*de*"));	// "ttpcodee"
		System.out.println(c.closestString("cmu","c*m*fm*u*"));	// "cfu"
		System.out.println(c.closestString("aaaaacccc","a*abc*"));	// "aaaaabccc"
		System.out.println(c.closestString("short","lo*ts*of*let*ter*s")); // ""
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=22741711&rd=12182&pm=9727
