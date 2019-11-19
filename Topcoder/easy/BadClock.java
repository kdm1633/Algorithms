public class BadClock
{
	public double nextAgreement (String trueTime, String skewTime, int hourlyGain) {
		double tSec = Double.parseDouble(trueTime.substring(0,2))*3600 + Double.parseDouble(trueTime.substring(3,5))*60 + Double.parseDouble(trueTime.substring(6));
		double sSec = Double.parseDouble(skewTime.substring(0,2))*3600 + Double.parseDouble(skewTime.substring(3,5))*60 + Double.parseDouble(skewTime.substring(6));

		double sum = (hourlyGain < 0) ? sSec - tSec : tSec - sSec;
		if (sum < 0) sum += 43200;	// 12 hours are 43,200 seconds.

		return Math.abs(sum / hourlyGain);
	}

	public static void main(String[] args) {
		BadClock b = new BadClock();
		System.out.println(b.nextAgreement("07:07:07","07:07:07",1776));
		System.out.println(b.nextAgreement("11:59:58","12:03:28",-3));
		System.out.println(b.nextAgreement("12:03:28","11:59:58",3));
		System.out.println(b.nextAgreement("03:03:02","03:01:47",5));
		System.out.println(b.nextAgreement("03:03:02","03:01:47",-5));
		System.out.println(b.nextAgreement("07:08:09","09:08:07",-321));
		System.out.println(b.nextAgreement("11:59:59","12:00:00",3600));
		System.out.println(b.nextAgreement("11:59:59","12:00:00",1));
	}
}
