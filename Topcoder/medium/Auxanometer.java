public class Auxanometer
{
	int m, M, res;

	boolean check(int n1, int n2) {
		while(n2 >= 10) n2 /= 10;
		if(n1%10 > n2) return false;
		
		while(n1 >= 10) {
			if(n1%10 < (n1/10)%10) return false;
			n1 /= 10;
		}

		return true;
	}

	void f(int x) {
		if(x > M) return;
		
		int other = x + m - 1;
		if(check(other,x)) res++;

		if(x >= 100000000) return;

		for (int i = x%10; i < 10; i++)
			f(x*10+i);
	}

	public int countIncreasingMarks(int nmin, int nmax) {
		m = nmin;
		M = nmax - nmin + 1;
		res = 0;
		for (int i = 1; i < 10; i++)
			f(i);

		return res;
	}

	public static void main(String[] args) {
		Auxanometer a = new Auxanometer();
		System.out.println(a.countIncreasingMarks(1,9));
		System.out.println(a.countIncreasingMarks(2,10));
		System.out.println(a.countIncreasingMarks(1090,1112));
		System.out.println(a.countIncreasingMarks(80,169));
	}
}

//import java.util.HashSet;
//
//public class Auxanometer
//{
//	int len;
//	HashSet<Integer> S;
//
//	void go(int num, int a, int b) {
//		S.add(num);
//		if (b < len) {
//			for (int i=a; i <= 9; i++)
//				go(num*10 + i, i, b+1);
//		}
//	}
//
//	public int countIncreasingMarks(int nmin, int nmax) {
//		S = new HashSet<Integer>();
//
//		int max = nmax; len = 1;
//		while(max >= 10) {max /= 10; len++;}
//		if(len == 10) len--;
//		
//		go(0,0,0);
//
//		int res = 0;
//		for (int x : S) {
//			if (nmin <= x && x <= nmax) {
//				int y = x - nmin + 1;
//				if (S.contains(y)) {
//					while(y >= 10) y /= 10;
//					if(y >= (x%10)) res++;
//				}
//			}
//		}
//
//		return res;
//	}
//
//	public static void main(String[] args) {
//		Auxanometer a = new Auxanometer();
//		System.out.println(a.countIncreasingMarks(1,9));
//		System.out.println(a.countIncreasingMarks(2,10));
//		System.out.println(a.countIncreasingMarks(1090,1112));
//		System.out.println(a.countIncreasingMarks(80,169));
//		System.out.println(a.countIncreasingMarks(1,1000000000));
//	}
//}

// https://www.topcoder.com/tc?module=HSProblemSolution&cr=22696982&rd=13528&pm=9868
// https://www.topcoder.com/tc?module=HSProblemSolution&cr=22652051&rd=13528&pm=9868
