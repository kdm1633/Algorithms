import java.util.Arrays;

public class GoldenChain
{
	public int minCuts(int[] s) {
		int res=0, last=s.length-1;

		Arrays.sort(s);

		for(int i=0; i <= last; ) {
			if(s[i] == 0) i++;
			else {
				s[i]--;
				res++;
				last--;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		GoldenChain g = new GoldenChain();
		System.out.println(g.minCuts(new int[]{3,3,3,3}));
		System.out.println(g.minCuts(new int[]{2000000000}));
		System.out.println(g.minCuts(new int[]{
			1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
			21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,
			38,39,40,41,42,43,44,45,46,47,48,49,50}));
		System.out.println(g.minCuts(new int[]{20000000,20000000,2000000000}));
		System.out.println(g.minCuts(new int[]{10,10,10,10,10,1,1,1,1,1}));
		System.out.println(g.minCuts(new int[]{1,10,10}));
	}
}
