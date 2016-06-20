import java.util.Arrays;

public class LeaguePicks
{
	public int[] returnPicks(int pos, int fr, int picks) {
		int cnt=0;

		for(int i=pos, sw=1; i <= picks; i += (sw==1) ? (fr-pos)*2+1 : pos*2-1, sw*=-1, cnt++) {}

		int[] res = new int[cnt];

		for(int i=pos, j=0, sw=1; i <= picks; i += (sw==1) ? (fr-pos)*2+1 : pos*2-1, sw*=-1)
			res[j++] = i;
		
		return res;
	}

	public static void main(String[] args) {
		LeaguePicks l = new LeaguePicks();
		System.out.println(Arrays.toString(l.returnPicks(3,6,15)));
		System.out.println(Arrays.toString(l.returnPicks(1,1,10)));
		System.out.println(Arrays.toString(l.returnPicks(1,2,39)));
		System.out.println(Arrays.toString(l.returnPicks(5,11,100)));
	}
}
