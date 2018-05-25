public class StringInterspersal
{
	public String minimum(String[] w) {
		String res = "";

		int len=0;
		for (int i=0; i < w.length; i++)
			len += w[i].length();

		int[] idx = new int[w.length];

		while (res.length() < len) {
			char ch = 'Z'+1;
			int mi=-1;
			for (int i=0; i < w.length; i++) {
				if (idx[i] == w[i].length()) continue;

				if (w[i].charAt(idx[i]) < ch) {
					ch = w[i].charAt(idx[i]);
					mi = i;
				}
				else if (w[i].charAt(idx[i]) == ch) {
					int j=idx[i]+1, k=idx[mi]+1;
					for (; j < w[i].length() && k < w[mi].length(); j++,k++) {
						if (w[i].charAt(j) < w[mi].charAt(k)) {
							mi = i;
							break;
						}
						else if (w[i].charAt(j) > w[mi].charAt(k))
							break;
					}
					if (j<w[i].length() && k==w[mi].length())
						if (w[i].charAt(j) <= w[mi].charAt(idx[mi]))
							mi = i;
				}
			}

			int si=idx[mi]+1;
			while (si<w[mi].length() && ch == w[mi].charAt(si)) si++;

			res += (si == idx[mi]+1) ? ch : w[mi].substring(idx[mi],si);
			idx[mi] = si;
		}

		return res;
	}

	public static void main(String[] args) {
		StringInterspersal s = new StringInterspersal();
		System.out.println(s.minimum(new String[]{"DESIGN","ALGORITHM","MARATHON"}));
		System.out.println(s.minimum(new String[]{"TOMEK","PETR","ACRUSH","BURUNDUK","KRIJGERTJE"}));
		System.out.println(s.minimum(new String[]{"CCCA","CCCB","CCCD","CCCE"}));
		System.out.println(s.minimum(new String[]{"BKSDSOPTDD","DDODEVNKL","XX","PODEEE","LQQWRT"}));
		System.out.println(s.minimum(new String[]{"TOPCODER","BETFAIR","NSA","BT","LILLY"}));
		System.out.println(s.minimum(new String[]{"QITHSQARQV","BYLHVGMLRY","LKMAQTJEAM","AQYICVNIKK","HKGZZFFEWC"}));
		System.out.println(s.minimum(new String[]{"XHCYBTUQUW","EKBISADSSN","LOOISPOFAK","MIXBDHPJUQ","BNMNDHMOTC"}));
	}
}
