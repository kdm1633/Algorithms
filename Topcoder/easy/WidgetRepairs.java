public class WidgetRepairs {
    public static int days(int[] arrivals, int numPerDay) {
		int n = arrivals.length, rest=0, opDay=0, i=0;

        while(i < n || rest > 0) {
			if(i < n) rest += arrivals[i++];
			
			if(rest == 0) continue;

			rest = (rest > numPerDay) ? rest-numPerDay : 0;

			opDay++;
		}
        
		return opDay;
    }

	public static void main(String[] args) {
		System.out.println(days(new int[]{ 10, 0, 0, 4, 20 }, 8));
		System.out.println(days(new int[]{ 0, 0, 0 }, 10));
		System.out.println(days(new int[]{ 100, 100 }, 10));
		System.out.println(days(new int[]{ 27, 0, 0, 0, 0, 9 }, 9));
		System.out.println(days(new int[]{ 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 }, 3));
	}
}