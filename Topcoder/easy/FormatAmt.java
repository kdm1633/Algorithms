public class FormatAmt {
	public static String amount(int dollars, int cents) {
		String str = Integer.toString(dollars);
		String res = ((cents < 10) ? ".0" : ".") + Integer.toString(cents);
		
		for(int i=str.length(); i > 0; i-=3)
			res = (i > 3) ? "," + str.substring(i-3, i) + res : "$" + str.substring(0,i) + res;
		
		return res;
	}

	public static void main(String[] args) {
		System.out.println(amount(123456,0));
		System.out.println(amount(49734321,9));
		System.out.println(amount(0,99));
		System.out.println(amount(249,30));
		System.out.println(amount(1000,1));
	}
}

// References
// https://github.com/luiseduardo1/Topcoder/blob/master/SRM%20149/DIV%202/FormatAmt.java
