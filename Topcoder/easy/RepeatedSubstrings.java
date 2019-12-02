public class RepeatedSubstrings
{
	public String decompress(String compressed) {
		String[] sp = compressed.split("\\s*[^0-9]+\\s*");
		int[] p1 = new int[sp.length/2];
		int[] p2 = new int[sp.length/2];
		int[] op1 = new int[sp.length/2];
		int[] op2 = new int[sp.length/2];
		int[] subLen = new int[sp.length/2];

		int cnt1 = 0;
		for (int i = 1, j = 0; i < sp.length; i+=2, j++) {
			p1[j] = Integer.parseInt(sp[i]);
			p2[j] = Integer.parseInt(sp[i+1]);
			subLen[j] = sp[i].length() + sp[i+1].length();
			cnt1 += p2[j] - p1[j] + 1;
		}

		int cnt2 = 0;
		for (int i = 0; i < compressed.length(); i++) {
			if ('A' <= compressed.charAt(i) || compressed.charAt(i) == ' ')
				cnt2++;
		}

		char[] c = new char[cnt1 + cnt2];
		for (int i = 0; i < c.length; i++)
			c[i] = '?';

		for (int i = 0, j = 0, k = 0; i < compressed.length(); i++, j++) {
			if (('A' <= compressed.charAt(i) && compressed.charAt(i) <= 'Z') || compressed.charAt(i) == ' ') {
				c[j] = compressed.charAt(i);
				cnt2++;
			}
			else {
				op1[k] = j;
				op2[k] = j + p2[k] - p1[k];
				i += subLen[k] + 1;
				j += p2[k] - p1[k];
				k++;
			}
		}

		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < p1.length; i++) {
				for (int j = op1[i], k = p1[i]; j <= op2[i]; j++, k++) {
					if (c[j]=='?' && c[k]!='?') {
						flag = true;
						c[j] = c[k];
					}
				}
			}
		}

		return String.valueOf(c);
	}

	public static void main(String[] args) {
		RepeatedSubstrings r = new RepeatedSubstrings();
		System.out.println(r.decompress("ABCDEFG &0-6"));
		System.out.println(r.decompress("AB&7-9&2-6"));
		System.out.println(r.decompress("IT WAS THE BE&39-49 &0-10WORST OF TIMES"));
		System.out.println(r.decompress("ABC&0-21"));
		System.out.println(r.decompress("&0-10"));
		System.out.println(r.decompress("&5-9ABC&2-7DE&20-22&17-19F"));
	}
}
