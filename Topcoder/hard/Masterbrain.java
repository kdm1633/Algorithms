public class Masterbrain
{
	String score(String g, String p) {
		int b = 0, w = 0;
		boolean[] ug = new boolean[4];
		boolean[] up = new boolean[4];

		for (int i = 0; i < 4; i++) {
			if (g.charAt(i)==p.charAt(i)) {
				b++;
				ug[i] = true;
				up[i] = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (!ug[i] && !up[j] && g.charAt(i)==p.charAt(j)) {
					w++;
					ug[i] = true;
					up[j] = true;
				}
			}
		}

		return "" + b + "b " + w + "w";
	}

	boolean check(String[] g, String[] r, String p) {
		int lies = 0;
		for (int i = 0; i < g.length; i++) {
			String res = score(g[i],p);
			if (!r[i].equals(res)) {
				if (lies == 1) return false;
				else lies = 1;
			}
		}
		return lies == 1;
	}

	public int possibleSecrets(String[] guesses, String[] results) {
		int res = 0;
		char[] p = new char[4];
		for (p[0] = '1'; p[0] <= '7'; p[0]++)
		for (p[1] = '1'; p[1] <= '7'; p[1]++)
		for (p[2] = '1'; p[2] <= '7'; p[2]++)
		for (p[3] = '1'; p[3] <= '7'; p[3]++)
			if (check(guesses, results, new String(p)))
				res++;

		return res;
	}

	public static void main(String[] args) {
		Masterbrain m = new Masterbrain();
		System.out.println(m.possibleSecrets(new String[]{"1575"}, new String[]{"4b 0w"}));
		System.out.println(m.possibleSecrets(new String[]{"1234"}, new String[]{"0b 4w"}));
		System.out.println(m.possibleSecrets(new String[]{"6172","6162","3617"}, new String[]{"3b 0w","2b 1w","0b 3w"}));
		System.out.println(m.possibleSecrets(new String[]{"1513","5654","4564","1377","1671","1342"}, new String[]{"1b 0w","0b 1w","1b 0w","1b 0w","0b 1w","0b 1w"}));
		System.out.println(m.possibleSecrets(new String[]{"2611", "1371", "7417", "2647", "3735", "4272", "2442", "3443", "1252", "3353"}, new String[]{"0b 2w","0b 2w","0b 1w","0b 2w","1b 0w","1b 0w","1b 0w","0b 1w","1b 1w","0b 1w"}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=152342&rd=4535&pm=1541
