public class NumberFormatter
{
	public String format(String number) {
		String res = "";

		int comma = number.indexOf(',');
		if (comma > 0)
			res = "." + number.substring(comma+1,number.length());

		int i = (comma > 0) ? comma : number.length();
		for (; i > 3; i-=3)
			res = " " + number.substring(i-3,i) + res;

		res = number.substring(0,i) + res;

		return res;
	}

	public static void main(String[] args) {
		NumberFormatter f = new NumberFormatter();
		System.out.println(f.format("1234567,890"));
		System.out.println(f.format("1024"));
		System.out.println(f.format("00003,1234000"));
		System.out.println(f.format("12345678912345678912345,0987654321"));
	}
}
