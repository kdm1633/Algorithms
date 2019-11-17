import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class SetComparison
{
	HashSet getSet(StringTokenizer st) {
		HashSet s = new HashSet<String>();
		String t = st.nextToken();
		while (!t.equals("}")) {
			if (t.equals("{")) s.add(getSet(st));
			else if (!t.equals(",")) s.add(t);
			t = st.nextToken();
		}

		return s;
	}
	
	public String[] relation(String _a, String _b) {
		StringTokenizer st = new StringTokenizer(_a,"{},",true);
		st.nextToken();
		HashSet a = getSet(st);
		st = new StringTokenizer(_b,"{},",true);
		st.nextToken();
		HashSet b = getSet(st);
		TreeSet<String> ret = new TreeSet<String>();

		if (b.contains(a)) ret.add("MEMBER");
		boolean eq = a.equals(b);
		if (eq) ret.add("EQUIVALENT");
		if (b.containsAll(a)) {
			ret.add("SUBSET");
			if (!eq) ret.add("PROPER SUBSET");
		}
		if (a.size() == 1<<b.size()) {
			boolean isPowerset = true;
			for (Object o : a)
				if (b.contains(o)) {isPowerset = false; break;}

			if (isPowerset) ret.add("POWERSET");
		}
		if (a.size() == b.size()) ret.add("EQUIPOTENT");

		return ret.toArray(new String[0]);
	}

	public static void main(String[] args) {
		SetComparison s = new SetComparison();
		System.out.println(Arrays.toString(s.relation("{}","{a,b,c,c,c,d,d,d}")));	// proper subset, subset
		System.out.println(Arrays.toString(s.relation("{{a,b},{a},{b},{}}","{a,b}")));	// powerset
		System.out.println(Arrays.toString(s.relation("{a,b,c,d,e}","{a,a,b,b,c,c,d,d,e,e}")));	// equipotent, equivalent, subset
		System.out.println(Arrays.toString(s.relation("{{a}}","{{{a}},{a}}"))); // member, proper subset, subset
		System.out.println(Arrays.toString(s.relation("{a,a,{a},{a},{a,a,a},{},{},a,aa}","{a,{a},{},aa}"))); // equipotent, equivalent, subset
		System.out.println(Arrays.toString(s.relation("{frank,bob}","{{},{frank,frank},{bob},{frank,bob,bob},{}}"))); // member
		System.out.println(Arrays.toString(s.relation("{{a,b},{a},{a,b},{},{b},{b,a}}","{a,b}"))); // powerset
		System.out.println(Arrays.toString(s.relation("{a,b,c,d}","{a,b}"))); // {}
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=287266&rd=4664&pm=1636
