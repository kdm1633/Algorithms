public class BigBurger {
    public static int maxWait(int[] arrival, int[] service) {
        if(arrival.length == 1) return 0;

        int max=0, wTime=0;
        int last = arrival[0] + service[0];

        for(int i=1; i < arrival.length; i++) {
            if (last <= arrival[i]) {
                last = arrival[i] + service[i];
                continue;
            }
            else {
                wTime = last - arrival[i];
                last += service[i];
            }
            if(wTime > max) max = wTime;
        }

        return max;
    }
	
	public static void main(String[] args) {
		System.out.println(maxWait(new int[]{3,3,9}, new int[]{2,15,4}));
		System.out.println(maxWait(new int[]{182}, new int[]{11}));
		System.out.println(maxWait(new int[]{2,10,11}, new int[]{3,4,3}));
		System.out.println(maxWait(new int[]{2,10,12}, new int[]{15,1,15}));
	}
}
