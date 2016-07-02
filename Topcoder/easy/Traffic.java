public class Traffic {
	public int time(int[] lights, int speed) {
		float t = 150 / (float)speed;
		float total=t;
		
		for(int k=0; k < lights.length; total += t, k++) {
			for(int i=1; ; i++) {
				if(total < (lights[k]*i)) {
					if(i%2==0) total = lights[k]*i;
					break;
				}
			}
		}
		
		return (int)total;
	}

	public static void main(String[] args) {
		Traffic t = new Traffic();
		System.out.println(t.time(new int[]{10,10,10}, 30));
		System.out.println(t.time(new int[]{10,10,10}, 20));
		System.out.println(t.time(new int[]{10,20,30}, 20));
		System.out.println(t.time(new int[]{10,11,12,13,14,15}, 5));
		System.out.println(t.time(new int[]{60,60,60,60,60,60,60,60,60,60}, 5));
		System.out.println(t.time(new int[]{55,29,26,12,19,39,18,20,23,28,56,20,59,48,33,40,30,60,19}, 25));
	}
}
