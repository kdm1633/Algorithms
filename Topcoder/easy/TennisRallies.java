public class TennisRallies
{
	int count, len, a;
	String[] fb;

	void tryRallies(String cur) {
		if (cur.length() < len) {
			tryRallies(cur+"c");
			tryRallies(cur+"d");
			return;
		}

		int c=0;
		for (int i=0; i < fb.length; i++) {
			int idx=0;
			while (cur.indexOf(fb[i], idx) != -1) {
				idx = cur.indexOf(fb[i], idx)+1;
				c++;
			}
		}
		if(c < a) count++;
	}

	public int howMany(int numLength, String[] forbidden, int allowed) {
		count=0; len = numLength; fb = forbidden; a = allowed;
		tryRallies("");
		return count;
	}

	public static void main(String[] args) {
		TennisRallies t = new TennisRallies();
		System.out.println(t.howMany(3,new String[]{"cc","dd"},1));
		System.out.println(t.howMany(10,new String[]{"c"},1));
		System.out.println(t.howMany(10,new String[]{"c"},2));
		System.out.println(t.howMany(18,new String[]{"c","d"},1));
		System.out.println(t.howMany(18,new String[]{},1));
		System.out.println(t.howMany(18,new String[]{"c","cc","ccc","cccc","ccccc","cccccc","ccccccc","cccccccc","ccccccccc","cccccccccc"},100));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=294688&rd=4610&pm=1802
