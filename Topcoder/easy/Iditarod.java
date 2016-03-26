public class Iditarod {
	public static int avgMinutes(String[] times) {
		int d, h, m;
	        int sum=0;
	        
	        for(int i=0; i < times.length; i++) {
	        	d = Integer.parseInt(times[i].substring(14)) - 1;
	        	h = Integer.parseInt(times[i].substring(0,2));
	        	m = Integer.parseInt(times[i].substring(3,5));
	        	m += times[i].charAt(6) == 'A' ? 60 * (24*d + h%12 - 8) : 60 * (24*d + 4 + h%12);
	        	sum += m;
	        }
	        
	        return Math.round((float) sum / times.length);
	}
	
	public static void main(String[] args) {
		System.out.println(avgMinutes(new String[]{"12:00 PM, DAY 1","12:01 PM, DAY 1"}));
		System.out.println(avgMinutes(new String[]{"12:00 AM, DAY 2"}));
		System.out.println(avgMinutes(new String[]{"02:00 PM, DAY 19","02:00 PM, DAY 20", "01:58 PM, DAY 20"}));
	}
}
