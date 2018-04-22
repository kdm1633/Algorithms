public class RepeatedSubstrings
{
	public String decompress(String compressed) {
		char[] c = new char[256];
		int[] q = new int[256];
		int[] pos1 = new int[256];
		int[] pos2 = new int[256];

		int qSize = 0, len = 0;
		for (int i=0, j=0, k=0; i < compressed.length(); i++) {
			if (compressed.charAt(i) == '&') {
				qSize++;
				q[k] = j;

				int p1 = compressed.charAt(++i)-'0';
				while(compressed.charAt(++i)>='0' && compressed.charAt(i)<='9') p1 = 10*p1 + compressed.charAt(i)-'0';
				int p2 = compressed.charAt(++i)-'0';
				while(i<compressed.length()-1 && compressed.charAt(i+1)>='0' && compressed.charAt(i+1)<='9') p2 = 10*p2 + compressed.charAt(++i)-'0';
				for (int l=p1; l <= p2; l++)
					c[j++] = '?';

				pos1[k] = p1;
				pos2[k] = p2;
				k++;
			}
			else c[j++] = compressed.charAt(i);

			if(i == compressed.length()-1) len = j;
		}

		boolean changed = false;
		for (int i=0; i < qSize; i++) {
			for (int j = q[i], k = pos1[i]; k <= pos2[i]; j++,k++) {
				if (c[j]=='?' && c[k]!='?') {
					changed = true;
					c[j] = c[k];
				}
			}
			if(i==qSize-1 && changed) {changed = false; i=-1;}
		}

		char[] res = new char[len];
		for (int i=0; i < len; i++)
			res[i] = c[i];

		return new String(res);
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

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=144400&rd=4707&pm=2004
