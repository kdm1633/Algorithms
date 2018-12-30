import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LostSortingAlgorithm {
	void reverse(int[] rank, int first, int last) {
		while ((first!=last) && (first!=--last)) {
			int temp = rank[first];
			rank[first] = rank[last];
			rank[last] = temp;
			
			first++;
		}
	}
	
	boolean next_permutation(int[] rank) {
		if(rank.length < 2) return false;
		
		int i = rank.length-1;
		while (true) {
			int j = i;
			i--;
			
			if (rank[i] < rank[j]) {
				int k = rank.length;

				while (!(rank[i] < rank[--k])) ;

				int temp = rank[i];
				rank[i] = rank[k];
				rank[k] = temp;

				reverse(rank,j,rank.length);

				return true;
			}
			
			if (i == 0) {
				reverse(rank,0,rank.length);
				
				return false;
			}
		}
	}
	
	public String recoverSortingAlgorithm(String[] clues) {
		int m = clues[0].length();
		String ans = "";
		int[] rank = new int[m];
		for (int i=0; i < m; i++)
			rank[i] = i;

		do {
			String[] clues2 = new String[clues.length];
			System.arraycopy(clues,0,clues2,0,clues.length);
			Arrays.sort(clues2, new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					for (int i=0; i < m; i++) {
					if (s1.charAt(rank[i]) < s2.charAt(rank[i]))
						return -1;
					else if (s1.charAt(rank[i]) > s2.charAt(rank[i]))
						return 1;
					}
					return 0;
				}
			});

			if (Arrays.equals(clues,clues2)) {
				if (ans != "") return "TOO MANY";

				for (int i=0; i < m; i++)
					ans += rank[i];
			}
		} while (next_permutation(rank));

		return (ans == "") ? "IMPOSSIBLE" : ans;
	}

	public static void main(String[] args) {
		LostSortingAlgorithm l = new LostSortingAlgorithm();
		System.out.println(l.recoverSortingAlgorithm(new String[]{"12D", "23A", "33A", "13B"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"0112", "2102", "1010"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"F112", "21F2", "1F1F"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"01234567", "01234568"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"0","1","2","3","4","7","6"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"0123","1234","2345","0145","1245","2346"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"0123","0145","1234","1245","2345","2346"}));
		System.out.println(l.recoverSortingAlgorithm(new String[]{"CC0","2F0","4A1","FB1","542","362","462","172"}));
	}
}

// https://community.topcoder.com/tc?module=HSProblemSolution&cr=22664055&rd=13526&pm=10064
