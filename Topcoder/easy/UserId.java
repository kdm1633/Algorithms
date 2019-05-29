public class UserId
{
	String[] iu;

	String delch(String s) {
		return s.replace(" ","").replace("'","");
	}

	boolean chkNotInUse(String s) {
		for (int i=0; i < iu.length; i++)
			if (s.equals(iu[i])) return false;

		return true;
	}

	public String id(String[] inUse, String first, String middle, String last) {
		iu = inUse;
		first = delch(first); middle = delch(middle); last = delch(last);

		if (first.length()<2 || last.length()<2) return "BAD DATA";

		first = first.toLowerCase(); middle = middle.toLowerCase(); last = last.toLowerCase();

		char[] c = (first + middle + last).toCharArray();
		for (int i=0; i < c.length; i++)
			if (c[i]!=' ' && c[i]!='\'' && !(c[i]>='A' && c[i]<='z')) return "BAD DATA";

		String s = "" + first.charAt(0) + last;
		if (s.length() > 8) s = s.substring(0,8);
		if (chkNotInUse(s)) return s;

		if (middle.length() != 0) {
			s = "" + first.charAt(0) + middle.charAt(0) + last;
			if (s.length() > 8) s = s.substring(0,8);
			if (chkNotInUse(s)) return s;
		}

		s = "" + first.charAt(0) + last;
		if (s.length() > 6) s = s.substring(0,6);

		for (int i=1; i < 10; i++)
			if (chkNotInUse(s+"0"+i)) return s+"0"+i;
		for (int i=10; i < 51; i++)
			if (chkNotInUse(s+i)) return s+i;

		return "BAD DATA";
	}

	public static void main(String[] args) {
		UserId u = new UserId();
		System.out.println(u.id(new String[]{"bjones","bjones03","bmjones","old34id"},"Bob","","Jones"));
		System.out.println(u.id(new String[]{"bjones","bjones03","bmjones","old34id"},"Bob Mack","Hertobise","Jone's"));
		System.out.println(u.id(new String[]{"bjonesto","bjones01","bjonesto","old34id"},"BoB-Mack","Mo","Jonestone"));
		System.out.println(u.id(new String[]{"momorris","mmmm","momorr01"},"'m m","","O'Morrisy"));
		System.out.println(u.id(new String[]{},"'m m","J.J","O'Morrisy"));
	}
}
