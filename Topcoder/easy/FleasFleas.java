public class FleasFleas
{
	public int population(int n, int k) {
		int tot=0;

		for(int rem=1; k > -5; rem *= k, k-=5) {
			tot += rem*n;

			if(tot > 10000000) return -1;
		}

		return tot;
	}

	public static void main(String[] args) {
		FleasFleas f = new FleasFleas();
		System.out.println(f.population(30,7));
		System.out.println(f.population(100,3));
		System.out.println(f.population(100,100));
		System.out.println(f.population(50,15));
		System.out.println(f.population(100,0));
		System.out.println(f.population(56,23));
		System.out.println(f.population(2,2));
		System.out.println(f.population(5,5));
	}
}
