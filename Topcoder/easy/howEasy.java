public class howEasy
{
	public int pointVal(String param0) {
		int sum=0, num=0;
		String[] s = param0.split(" ");
		
		for (int i=0; i < s.length; i++) {
			if(s[i].equals("") || s[i].equals(".")) continue;
			
			int j=0;
			for (; j < s[i].length(); j++) {
				if(j==s[i].length()-1 && '.' == s[i].charAt(j)) {sum--; continue;}
				if('.' <= s[i].charAt(j) && s[i].charAt(j) <= '9') break;
			}
			if(j==s[i].length()) {
				sum += s[i].length();
				num++;
			}
		}
		
		if(num == 0) return 250;
		
		if(sum/num <= 3) return 250;
		else if(sum/num <= 5) return 500;
		else return 1000;
	}
	
	public static void main(String[] args) {
		howEasy h = new howEasy();
		System.out.println(h.pointVal("This is a problem statement"));
		System.out.println(h.pointVal("523hi."));
		System.out.println(h.pointVal("Implement a class H5 which contains some method."));
		System.out.println(h.pointVal(" no9 . wor7ds he8re. hj.."));
	}
}
