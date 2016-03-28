import java.util.Arrays;

public class Pricing {
	public static int maxSales(int[] price) {
		Arrays.sort(price);

		int len = price.length;
		int ret=0;
		
		for(int i=0; i < len; i++) {
			for(int j=i; j < len; j++) {
				for(int k=j; k < len; k++) {
					for(int l=k; l < len; l++) {
						int rev=0;
						
						for(int m=0; m < len; m++) {
							int p = price[m];
							
							if(p >= price[l])
								rev += price[l];
							else if(p >= price[k])
								rev += price[k];
							else if(p >= price[j])
								rev += price[j];
							else if(p >= price[i])
								rev += price[i];
						}
						
						if(rev > ret) ret = rev;
					}
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		System.out.println(maxSales(new int[]{9,1,5,5,5,5,4,8,80}));
		System.out.println(maxSales(new int[]{17,50,2}));
		System.out.println(maxSales(new int[]{130,110,90,13,6,5,4,3,0}));
	}
}
