import java.util.Arrays;
import java.util.ArrayList;

public class InterestingDigits {
    public static int[] digits(int base) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        
        for(int i=2; i < base; i++)
            if(base % i == 1) results.add(i);
        
        return results.stream().mapToInt(i->i).toArray();
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(digits(10)));
		System.out.println(Arrays.toString(digits(3)));
		System.out.println(Arrays.toString(digits(9)));
		System.out.println(Arrays.toString(digits(26)));
		System.out.println(Arrays.toString(digits(30)));
	}
}

// http://quangpham313.blog.com/2011/02/12/srm-150-division-2-level-2-interesting-digits/