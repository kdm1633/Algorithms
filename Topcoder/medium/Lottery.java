import java.util.Arrays;
import java.util.Comparator;

public class Lottery
{
	long perm(long a, long b) {
		long num = 1;
		for (int i = 0; i < b; i++)
			num *= a--;

		return num;
	}

	long fact(long a) {
		long num = 1;
		for (int i = 2; i <= a; i++)
			num *= i;

		return num;
	}

	long cbn(long n, long r) {
		if(r > n/2) r = n-r;
		long denom=1, numer=1;
		while(r > 0) {denom *= n--; numer *= r--;}

		return denom / numer;
	}

	long calOutcomes(long choices, long blanks, boolean sorted, boolean unique) {
		long outcomes = 1;

		if (sorted && unique)
			outcomes = cbn(choices, blanks);
		else if (sorted && !unique)
			outcomes = cbn(choices+blanks-1, blanks);
		else if (!sorted && unique)
			outcomes = perm(choices,blanks);
		else if (!sorted && !unique)
			outcomes = (long)Math.pow(choices,blanks);

		return outcomes;
	}

	public String[] sortByOdds(String[] rules) {
		int n = rules.length;

		Arrays.sort(rules, new Comparator<String>() {
			public int compare(String A, String B) {
				String[] spA = A.split(":")[1].split(" ");
				int choicesA = Integer.parseInt(spA[1]);
				int blanksA = Integer.parseInt(spA[2]);
				String[] spB = B.split(":")[1].split(" ");
				int choicesB = Integer.parseInt(spB[1]);
				int blanksB = Integer.parseInt(spB[2]);

				long outcomesA = calOutcomes(choicesA, blanksA, spA[3].charAt(0)=='T', spA[4].charAt(0)=='T');
				long outcomesB = calOutcomes(choicesB, blanksB, spB[3].charAt(0)=='T', spB[4].charAt(0)=='T');

				if (outcomesA < outcomesB)
					return -1;
				else if (outcomesA > outcomesB)
					return 1;
				else
					return A.compareTo(B);
			}
		});

		String[] name = new String[n];
		for (int i = 0; i < n; i++)
			name[i] = rules[i].split(":")[0];

		return name;
	}

	public static void main(String[] args) {
		Lottery l = new Lottery();
		System.out.println(Arrays.toString(l.sortByOdds(new String[]{
			"PICK ANY TWO: 10 2 F F",
			"PICK TWO IN ORDER: 10 2 T F",
			"PICK TWO DIFFERENT: 10 2 F T",
			"PICK TWO LIMITED: 10 2 T T"})));
		System.out.println(Arrays.toString(l.sortByOdds(new String[]{
			"INDIGO: 93 8 T F",
			"ORANGE: 29 8 F T",
			"VIOLET: 76 6 F F",
			"BLUE: 100 8 T T",
			"RED: 99 8 T T",
			"GREEN: 78 6 F T",
			"YELLOW: 75 6 F F"})));
		System.out.println(Arrays.toString(l.sortByOdds(new String[]{})));
	}
}

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=277659&rd=4515&pm=1659
