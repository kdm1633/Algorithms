public class PowSum
{
	public int getSum(int low, int high, int pow) {
		double sum=0;
		for (int i=low; i <= high; i++)
			for (int j=1; j <= pow; j++)
				sum += Math.pow(i,j);

		return (int)sum;
	}

	public static void main(String[] args) {
		PowSum p = new PowSum();
		System.out.println(p.getSum(1,3,2));
		System.out.println(p.getSum(-12,12,9));
		System.out.println(p.getSum(-100,100,2));
	}
}
