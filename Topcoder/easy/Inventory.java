public class Inventory
{
	public int monthlyOrder(int[] sales, int[] daysAvailable) {
		int n=sales.length;
		double sum=0;

		for (int i=0; i < sales.length; i++) {
			if(daysAvailable[i]==0) {n--; continue;}
			sum += (double)sales[i]/daysAvailable[i];
		}

		return (int)Math.ceil(sum*30/n);
	}

	public static void main(String[] args) {
		Inventory i = new Inventory();
		System.out.println(i.monthlyOrder(new int[]{5}, new int[]{15}));
		System.out.println(i.monthlyOrder(new int[]{75,120,0,93}, new int[]{24,30,0,30}));
		System.out.println(i.monthlyOrder(new int[]{8773}, new int[]{16}));
		System.out.println(i.monthlyOrder(new int[]{1115,7264,3206,6868,7301}, new int[]{1,3,9,4,18}));
		//System.out.println(i.monthlyOrder(new int[], new int[]));
	}
}
