import java.util.Arrays;

public class Carbon14
{
	public int[] dateRange(int concentration, int err) {
		return new int[]{(int)(-8267 * Math.log(((double)(concentration+err)/10000))),(int)Math.ceil((-8267 * Math.log(((double)(concentration-err)/10000))))};
	}

	public static void main(String[] args) {
		Carbon14 c = new Carbon14();
		System.out.println(Arrays.toString(c.dateRange(5000,100)));
		System.out.println(Arrays.toString(c.dateRange(5000,0)));
		System.out.println(Arrays.toString(c.dateRange(1,0)));
		System.out.println(Arrays.toString(c.dateRange(3456,18)));
	}
}
