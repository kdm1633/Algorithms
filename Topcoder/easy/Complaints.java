public class Complaints {
    int howMany(int[] lines) {
		int n=0;
		for(int i=1; i < lines.length; i++) {
			for(int j=i-1; j >= 0; j--) {
				if(lines[j] < lines[i]) n++;
			}
		}
		
		return n;
    }
	
	public static void main(String[] args) {
		Complaints c = new Complaints();
		System.out.println(c.howMany(new int[]{1000,800,900,1400}));
		System.out.println(c.howMany(new int[]{1,2,3,4,5}));
		System.out.println(c.howMany(new int[]{10,9,8,7,6,5}));
		System.out.println(c.howMany(new int[]{0,0,0,0,4000,4000,4000,4000}));
		System.out.println(c.howMany(new int[]{1000,0,4000,2000}));
		System.out.println(c.howMany(new int[]{0}));
	}
}
