public class Commission
{
	public double equivalentSales(double sales, double cost, double commission) {
		return sales * (100 - 20 - cost) / (100 - commission - cost);
	}
	
	public static void main(String[] args) {
		Commission c = new Commission();
		System.out.println(c.equivalentSales(100.555, 70.0, 10.0));
		System.out.println(c.equivalentSales(756840.0, 74.3, 11.5));
		System.out.println(c.equivalentSales(10000000000.0, 79.5, 19.5));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=279471&rd=5002&pm=2293
