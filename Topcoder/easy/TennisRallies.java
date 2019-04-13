public class TennisRallies
{
	int rec(int index, int numLength, String curr, int allowed, String[] forbidden) {
		if(index == numLength) return 1;

		int ret = 0;
		for (char stroke = 'c'; stroke <= 'd'; stroke++) {
			int newAllowed = allowed;
			String newCurr = curr + stroke;
			for (int forbIndex = 0; forbIndex < forbidden.length; forbIndex++)
				if(newCurr.endsWith(forbidden[forbIndex])) newAllowed--;

			if(newAllowed <= 0) continue;
			ret += rec(index+1, numLength, newCurr, newAllowed, forbidden);
		}

		return ret;
	}

	public int howMany(int numLength, String[] forbidden, int allowed) {
		return rec(0, numLength, "", allowed, forbidden);
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

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm161
