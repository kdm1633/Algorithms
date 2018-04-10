public class BadClock
{
	public double nextAgreement (String trueTime, String skewTime, int hourlyGain) {
		String[] tt = trueTime.split(":");
		String[] st = skewTime.split(":");
		double tsec = Double.parseDouble(tt[0])*3600 + Double.parseDouble(tt[1])*60 + Double.parseDouble(tt[2]);
		double ssec= Double.parseDouble(st[0])*3600 + Double.parseDouble(st[1])*60 + Double.parseDouble(st[2]);
	
		if(hourlyGain > 0) return (tsec-ssec+3600*12)%(3600*12) / hourlyGain;
		else return -1*(ssec-tsec+3600*12)%(3600*12) / hourlyGain;
	}

	public static void main(String[] args) {
		BadClock b = new BadClock();
		System.out.println(b.nextAgreement("07:07:07","07:07:07",1776));
		System.out.println(b.nextAgreement("11:59:58","12:03:28",-3));
		System.out.println(b.nextAgreement("12:03:28","11:59:58",3));
		System.out.println(b.nextAgreement("03:03:02","03:01:47",5));
		System.out.println(b.nextAgreement("03:03:02","03:01:47",-5));
		System.out.println(b.nextAgreement("07:08:09","09:08:07",-321));
		System.out.println(b.nextAgreement("11:59:59", "12:00:00", 3600));
		System.out.println(b.nextAgreement("11:59:59", "12:00:00", 1));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=266685&rd=4665&pm=1969
