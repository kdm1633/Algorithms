import java.util.Arrays;

public class LongestRun {
	public int runLength(String[] collection) {
		int res=0, len=collection.length;

		for (char ch='A'; ch <= 'Z'; ch++) {
			int all=0, best=0;
			int[] l = new int[len];
			int[] r = new int[len];

			for (int i=0; i < len; i++) {
				int iLen = collection[i].length();
				int cnt1=0, cnt2=0, within=0, wcnt=0, a=0, b=iLen-1;

				for (; a < iLen; a++) {
					if(ch == collection[i].charAt(a)) cnt1++;
					else break;
				}

				if(cnt1==iLen) {all += cnt1; continue;}

				for (; b >= 0; b--) {
					if(ch == collection[i].charAt(b)) cnt2++;
					else break;
				}

				for (int j=a; j <= b; j++) {
					if(ch == collection[i].charAt(j)) wcnt++;
					else {
						if(wcnt > within) within = wcnt;
						wcnt=0;
					}
				}

				l[i] = cnt1;
				r[i] = cnt2;

				if(l[i] > res) res = l[i];
				if(r[i] > res) res = r[i];
				if(within > res) res = within;
			}

			for (int i=0; i < len; i++) {
				for (int j=0; j < len; j++) {
					if(i==j) continue;
					if(l[i]+r[j] > best) best = l[i]+r[j];
				}
			}

			best += all;

			if(best > res) res = best;
		}

		return res;
	}
	
	public static void main(String[] args) {
		LongestRun l = new LongestRun();
		System.out.println(l.runLength(new String[]{"ABC", "CBBB", "CC", "ABCDEFG"}));
		System.out.println(l.runLength(new String[]{"ABC", "CBBBC","ABCDEFG", "AD", "AE", "AF"}));
		System.out.println(l.runLength(new String[]{"GOOD","DOG","EGG","DO","GIGABYTE","OOO","G","G"}));
		System.out.println(l.runLength(new String[]{"AAABBBBAAA","BAABBBBAB"}));
		System.out.println(l.runLength(new String[]{"AAABBBBAAA","AABBBBA"}));
		System.out.println(1<<20);
	}
}

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=107835&rd=4464&pm=1328
