public class YearProgressbar
{
	public double percentage(String currentDate) {
		String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

		String[] s = currentDate.split(" ");

		int curDays = -1, y = 365;

		int year = Integer.parseInt(s[2]);
		if(year%400==0 || (year%4==0 && year%100!=0)) {days[1]++; y++;}

		for (int i=0; i < 12; i++) {
			if (month[i].equals(s[0])) {
				for (int j=0; j < i; j++)
					curDays += days[j];

				break;
			}
		}

		curDays += Integer.parseInt(s[1].substring(0,2));

		int curMin = curDays*24*60 + Integer.parseInt(s[3].substring(0,2))*60 + Integer.parseInt(s[3].substring(3));

		return (double)curMin/(double)(y*24*60) * 100;
	}

	public static void main(String[] args) {
		YearProgressbar y = new YearProgressbar();
		System.out.println(y.percentage("January 01, 2008 00:00"));
		System.out.println(y.percentage("December 31, 2007 23:59"));
		System.out.println(y.percentage("July 02, 2007 12:00"));
		System.out.println(y.percentage("July 02, 2008 00:00"));
		System.out.println(y.percentage("May 10, 1981 00:31"));
		System.out.println(y.percentage("January 31, 1900 00:47"));
	}
}
