public class BenfordsLaw
{
	public int questionableDigit(int[] transactions, int threshold) {
		int min=10;
		int[] nums = new int[10];
		for(int i=0; i < transactions.length; i++) {
			int n = Integer.parseInt(String.valueOf(transactions[i]).substring(0,1));
			nums[n]++;
		}

		for(int i=1; i < nums.length; i++) {
			double expected = Math.log10(1+1.0/i) * transactions.length;
			if((nums[i] < expected/threshold || nums[i] > expected*threshold)) return i;
		}

		return -1;
	}
}
	public static void main(String[] args) {
		BenfordsLaw b = new BenfordsLaw();
		System.out.println(b.questionableDigit(new int[]{5236,7290,200,1907,3336,9182,17,4209,8746,7932,6375,909,2189,3977,2389,2500,1239,3448,6380,4812}, 2));
		System.out.println(b.questionableDigit(new int[]{1,10,100,2,20,200,2000,3,30,300},2));
		System.out.println(b.questionableDigit(new int[]{9,87,765,6543,54321,43219,321987,21987,1987,345,234,123},2));
		System.out.println(b.questionableDigit(new int[]{1,2,3,4,5,6,7,8,7,6,5,4,3,2,1},8));
		System.out.println(b.questionableDigit(new int[]{987,234,1234,234873487,876,234562,17,7575734,5555,4210,678234,3999,8123},3));
	}
}
