public class MostProfitable
{
	public String bestItem(int[] costs, int[] prices, int[] sales, String[] items) {
		int mostProfits=0;
		String res="";

		for (int i=0; i < costs.length; i++) {
			int profits = (prices[i]-costs[i])*sales[i];
			if(profits > mostProfits) {
				mostProfits = profits;
				res = items[i];
			}
		}

		return res;
	}

	public static void main(String[] args) {
		MostProfitable m = new MostProfitable();
		System.out.println(m.bestItem(new int[]{100,120,150,1000}, new int[]{110,110,200,2000}, new int[]{20,100,50,3}, new String[]{"Video Card","256M Mem","CPU/Mobo combo","Complete machine"}));
		System.out.println(m.bestItem(new int[]{100}, new int[]{100}, new int[]{134}, new String[]{"Service, at cost"}));
		System.out.println(m.bestItem(new int[]{38,24}, new int[]{37,23}, new int[]{1000,634}, new String[]{"Letter","Postcard"}));
		System.out.println(m.bestItem(new int[]{10,10}, new int[]{11,12}, new int[]{2,1}, new String[]{"A","B"}));
	}
}
