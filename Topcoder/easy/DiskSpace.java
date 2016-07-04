import java.util.Arrays;

public class DiskSpace {
	public int minDrives(int[] used, int[] total) {
		int i, len = used.length, tot=0, res=0;
		
		for(i=0; i < len; i++)
			tot += used[i];
		
		Arrays.sort(total);
		
		for(i=len-1; tot > 0 && i >= 0; i--, res++)
			tot -= total[i];
		
		return res;
	}

	public static void main(String[] args) {
		DiskSpace d = new DiskSpace();
		System.out.println(d.minDrive(new int[]{300,525,110}, new int[]{350,600,115}));
		System.out.println(d.minDrive(new int[]{1,200,200,199,200,200}, new int[]{1000,200,200,200,200,200}));
		System.out.println(d.minDrive(new int[]{750,800,850,900,950}, new int[]{800,850,900,950,1000}));
		System.out.println(d.minDrive(new int[]{49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49}, new int[]{50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50}));
		System.out.println(d.minDrive(new int[]{331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385}, new int[]{992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906}));
	}
}
