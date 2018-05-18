import java.util.Arrays;

public class StringsAndTabs
{
	public String[] transformTab(String[] tab, int[] stringsA, int[] stringsB, int d) {
		char[][] tabB = new char[stringsB.length][tab[0].length()];
		for (int i=0; i < tabB.length; i++)
			for (int j=0; j < tabB[0].length; j++)
				tabB[i][j] = '-';

		for (int j=0; j < tab[0].length(); j++) {
			int[] temp = new int[tab.length];
			int len=0;
			for (int i=0,idx=0; i < tab.length; i++) {
				char note = tab[i].charAt(j);
				if (note != '-') {
					temp[idx++] = (note < 'A') ? note-'0'+stringsA[i]+d : note-'A'+10+stringsA[i]+d;
					len++;
				}
			}
			
			int[] chord = new int[len];
			for (int i=0; i < len; i++)
				chord[i] = temp[i];
			
			if (chord.length != 0) {
				Arrays.sort(chord);
				for (int i=chord.length-1; i >= 0; i--) {
					int midx=-1, min=136;
					for (int k=0; k < stringsB.length; k++) {
						if (chord[i]>=stringsB[k] && chord[i]<=stringsB[k]+35 && Math.abs(chord[i]-stringsB[k])<=min && tabB[k][j]=='-') {
							midx = k;
							min = Math.abs(chord[i]-stringsB[k]);
						}
					}
					if (midx == -1) {
						for (int a=0; a < tabB.length; a++)
							tabB[a][j] = 'x';
							
						break;
					}
					else tabB[midx][j] = (min<10) ? (char)('0'+min) : (char)('A'+min-10);
				}
			}
		}

		String[] res = new String[stringsB.length];
		for (int i=0; i < res.length; i++)
			res[i] = new String(tabB[i]);

		return res;
	}

	public static void main(String[] args) {
		StringsAndTabs s = new StringsAndTabs();
		System.out.println(Arrays.toString(s.transformTab(new String[]{
			"-----------------",
			"-------------0-1-",
			"---------0-2-----",
			"---0-2-3---------",
			"-3---------------",
			"-----------------"},new int[]{28,23,19,14,9,4},new int[]{9},0)));
		System.out.println(Arrays.toString(s.transformTab(new String[]{"-4457754-20024422-4457754-20024200-"},new int[]{0},new int[]{28,23,19,14,9,4},12)));
		System.out.println(Arrays.toString(s.transformTab(new String[]{
			"-----------------------------------",
			"-----------------------------------",
			"----00---------------00------------",
			"-223--32-0--02200-223--32-0--020---",
			"----------33---------------33---33-",
			"-----------------------------------"},new int[]{28,23,19,14,9,4},new int[]{33,28,24,31},12)));
		System.out.println(Arrays.toString(s.transformTab(new String[]{
			"-----0------2-2222--0-------0-",
			"----0------2---222---5-----55-",
			"---0------2-----22----9---999-",
			"--0------2-------2-----E-EEEE-",
			"-0------2---------------------",
			"0------2----------------------"},new int[]{28,23,19,14,9,4},new int[]{33,28,28},12)));
		System.out.println(Arrays.toString(s.transformTab(new String[]{"012345---------","---------UVWXYZ"},new int[]{-2,2},new int[]{0},0)));
		System.out.println(Arrays.toString(s.transformTab(new String[]{
			"0220----02--",
			"75--75----57",
			"------B9B9B9",
			"--242424----"},new int[]{33,28,24,31},new int[]{33,28,28},0)));
	}
}
