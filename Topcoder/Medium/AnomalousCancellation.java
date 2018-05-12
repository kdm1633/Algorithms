public class AnomalousCancellation
{
	public String reducedFraction(int numerator, int denominator) {
		String[] nleft = new String[16]; String[] ngone = new String[16];
		String[] dleft = new String[16]; String[] dgone = new String[16];;

		int bestn = numerator, bestd = denominator;
		String num = String.valueOf(numerator), den = String.valueOf(denominator);

		for (int m=1; m < 1<<num.length(); m++) {
			nleft[m] = ngone[m] = "";
			for (int i=0; i < num.length(); i++) {
				int flag = m & 1<<i;
				if(flag > 0) nleft[m] += num.charAt(i);
				else ngone[m] += num.charAt(i);
			}
		}

		for (int m=1; m < 1<<den.length(); m++) {
			dleft[m] = dgone[m] = "";
			for (int i=0; i < den.length(); i++) {
				int flag = m & 1<<i;
				if(flag > 0) dleft[m] += den.charAt(i);
				else dgone[m] += den.charAt(i);
			}
		}

		for (int a=1; a < 1<<num.length(); a++) {
			for (int b=1; b < 1<<den.length(); b++) {
				if (ngone[a].equals(dgone[b])) {
					int n = Integer.parseInt(nleft[a]);
					int d = Integer.parseInt(dleft[b]);
					if (n>0 && d>0 && n<bestn && bestn*d==bestd*n) {
						bestn = n;
						bestd = d;
					}
				}
			}
		}

		return String.valueOf(bestn) + "/" + String.valueOf(bestd);
	}

	public static void main(String[] args) {
		AnomalousCancellation a = new AnomalousCancellation();
		System.out.println(a.reducedFraction(16,64));
		System.out.println(a.reducedFraction(4784,7475));
		System.out.println(a.reducedFraction(25,25));
		System.out.println(a.reducedFraction(95,19));
		System.out.println(a.reducedFraction(100,1000));
		System.out.println(a.reducedFraction(123,456));
		System.out.println(a.reducedFraction(151,1057));
	}
}

// https://community.topcoder.com/tc?module=HSProblemSolution&cr=22663117&rd=13486&pm=9804
