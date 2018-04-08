import java.util.Arrays;
import java.util.TreeSet;

public class SetComparison
{
	String[] r = {"EQUIPOTENT","EQUIVALENT","MEMBER","POWERSET","PROPER SUBSET","SUBSET"};
	
	boolean[] chk;
	
	TreeSet<String> sa,sb;
	
	long comb(long n, long r) {
		long denom=1, numer=1;
		
		while (r > 0) {denom *= n--; numer *= r--;}
		
		return denom / numer;
	}

	boolean equipotent() {
		if(sa.size() == sb.size()) return true;
		
		return false;
	}
	
	boolean equivalent() {
		if(sa.size() != sb.size()) return false;
		
		for (String s : sa)
			if(!sb.contains(s)) return false;
		
		return true;
	}
	
	boolean member() {
		if (sa.size()==0) {
			if(sb.contains("{}")) return true;
			return false;
		}

		String a = "";
		for (String s : sa)
			a += s+",";

		System.out.println(a);
		a = "{" + a.substring(0,a.length()-1) + "}";
		
		if(sb.contains(a)) return true;
		
		return false;
	}
	
	boolean powerset() {
		int pSize = 1;
		for (int i=1; i <= sb.size(); i++)
			pSize += comb(sb.size(),i);
		
		if(sa.size() != pSize) return false;
		
		for (String s : sa) {
			if(s.charAt(0) != '{') return false;

			TreeSet<String> hs = new TreeSet<String>();
			
			for (int i=1; i < s.length()-1; ) {
				if (s.charAt(i) != '{') {
					int idx = s.indexOf(',',i+1);
					if(idx == -1) idx = s.length()-1;
					if(!sb.contains(s.substring(i,idx))) return false;
					i = idx+1;
				}
				else if (s.charAt(i) == '{') {
					int cnt=1;
					int j = i+1;
					for (; j < s.length(); j++) {
						if(s.charAt(j) == '{') cnt++;
						else if(s.charAt(j) == '}' && --cnt==0) break;
					}
					if(!sb.contains(s.substring(i+1,j))) return false;
					i = j+2;
				}
			}
			
			for (String s1 : hs)
				if(!sb.contains(s1)) return false;
		}
		
		return true;
	}
	
	boolean propersubset() {
		if(chk[1] || chk[3]) return false;
		
		for (String s : sa)
			if(!sb.contains(s)) return false;
		
		return true;
	}
	
	boolean subset() {
		if(chk[3]) return false;

		for (String s : sa)
			if(!sb.contains(s)) return false;

		return true;
	}
	
	TreeSet<String> saveElements(String str) {
		TreeSet<String> hs = new TreeSet<String>();

		for (int i=0; i < str.length(); ) {
			if (str.charAt(i) == '{') {
				if(str.charAt(i+1) == '}') {hs.add("{}"); i += 3; continue;}
				
				int cnt=1;
				int j = i+1;
				for (; j < str.length(); j++) {
					if(str.charAt(j) == '{') cnt++;
					else if(str.charAt(j) == '}' && --cnt==0) break;
				}
				
				TreeSet<String> temp = saveElements(str.substring(i+1,j));
				
				String subset = "";
				for (String s : temp)
					subset += s+",";
				subset = "{" + subset.substring(0,subset.length()-1) + "}";
				hs.add(subset);
				i = j+2;
			}
			else {
				int idx = str.indexOf(',',i+1);

				if(idx == -1) idx = str.length();

				hs.add(str.substring(i,idx));
				i = idx+1;
			}
		}
		
		return hs;
	}
	
	public String[] relation(String a, String b) {
		chk = new boolean[6];

		sa = saveElements(a.substring(1,a.length()-1));
		sb = saveElements(b.substring(1,b.length()-1));
		
		int len=0;
		if(equipotent()) {chk[0] = true; len++;}
		if(equivalent()) {chk[1] = true; len++;}
		if(member()) {chk[2] = true; len++;}
		if(powerset()) {chk[3] = true; len++;}
		if(propersubset()) {chk[4] = true; len++;}
		if(subset()) {chk[5] = true; len++;}
		
		String[] res = new String[len];
		for (int i=0,j=0; i < chk.length; i++)
			if(chk[i]) res[j++] = r[i];
		
		return res;
	}

	public static void main(String[] args) {
		SetComparison s = new SetComparison();
		System.out.println(Arrays.toString(s.relation("{}","{a,b,c,c,c,d,d,d}")));	// proper subset, subset
		System.out.println(Arrays.toString(s.relation("{{a,b},{a},{b},{}}","{a,b}")));	// powerset
		System.out.println(Arrays.toString(s.relation("{a,b,c,d,e}","{a,a,b,b,c,c,d,d,e,e}")));	// equipotent, equivalent, subset
		System.out.println(Arrays.toString(s.relation("{{a}}","{{{a}},{a}}"))); // member, proper subset, subset
		System.out.println(Arrays.toString(s.relation("{a,a,{a},{a},{a,a,a},{},{},a,aa}","{a,{a},{},aa}"))); // equipotent, equivalent, subset
		System.out.println(Arrays.toString(s.relation("{frank,bob}","{{},{frank,frank},{bob},{frank,bob,bob},{}}"))); //member
		System.out.println(Arrays.toString(s.relation("{{a,b},{a},{a,b},{},{b},{b,a}}","{a,b}"))); // powerset
		System.out.println(Arrays.toString(s.relation("{a,b,c,d}","{a,b}"))); // {}
	}
}
