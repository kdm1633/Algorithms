public class MagicalSpheres
{
	long count(long n, long p) {
		long res=0;
		long q=p;
		while (q <= n) {
			res += n/q;
			q *= p;
		}
    
		return res;
	}

	public int divideWork(int spheresCount, int fakeSpheresCount, int gnomesAvailable) {
		int n = spheresCount+fakeSpheresCount;
		int r = spheresCount;

		gnomes:
		for (int g=gnomesAvailable; g > 1; g--) {
			int num=g;
			for (int p=2; p*p <= num; p++) {
				if(num%p == 0) {
					int exp=0;
					while (num%p == 0) {
						num /= p;
						exp++;
					}
					if(count(n,p)-count(r,p)-count(n-r,p) < exp) continue gnomes;
				}
			}
			if(num>1)
				if(count(n,num)-count(r,num)-count(n-r,num) < 1) continue gnomes;

			return g;
		}

		return 1;
	}

	public static void main(String[] args) {
		MagicalSpheres m = new MagicalSpheres();
		System.out.println(m.divideWork(3,1,4));
		System.out.println(m.divideWork(3,3,50));
		System.out.println(m.divideWork(4,3,4));
		System.out.println(m.divideWork(15634,456,5000));
		System.out.println(m.divideWork(1,1,100000));
		System.out.println(m.divideWork(1,1000000000,100000));
	}
}

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm409
