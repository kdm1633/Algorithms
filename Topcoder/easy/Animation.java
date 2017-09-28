import java.util.Arrays;
import java.util.ArrayList;

public class Animation {
	public String[] animate(int speed, String init) {
		ArrayList<String> res = new ArrayList<String>();
		char[] cb = init.toCharArray();
		char[] x = init.replace('L','X').replace('R','X').toCharArray();
		char[] next = new char[init.length()];
		for (int i=0; i < next.length; i++)
			next[i] = '.';

		while (true) {
			res.add(String.valueOf(x));

			int dnum=0;
			for (; dnum < x.length; dnum++)
				if(x[dnum] != '.') break;

			if(dnum == x.length) break;
			
			for (int j=0; j < cb.length; j++) {
				if(cb[j]=='L' && j-speed>=0)
					next[j-speed] = (next[j-speed] == '.') ? 'L' : 'B';
				else if(cb[j]=='R' && j+speed<cb.length)
					next[j+speed] = (next[j+speed] == '.') ? 'R' : 'B';
				else if(cb[j]=='B') {
					if(j-speed >= 0) next[j-speed] = (next[j-speed] == '.') ? 'L' : 'B';
					if(j+speed < cb.length) next[j+speed] = (next[j+speed] == '.') ? 'R' : 'B';
				}
			}
			
			for (int j=0; j < x.length; j++)
				x[j] = (next[j] == '.') ? '.' : 'X';
			
			System.arraycopy(next,0,cb,0,cb.length);
			for (int j=0; j < next.length; j++)
				next[j] = '.';
		}
		
		return res.toArray(new String[0]);
	}


	public static void main(String[] args) {
		Animation a = new Animation();
		System.out.println(Arrays.toString(a.animate(2,"..R....")));
		System.out.println(Arrays.toString(a.animate(3,"RR..LRL")));
		System.out.println(Arrays.toString(a.animate(2,"LRLR.LRLR")));
		System.out.println(Arrays.toString(a.animate(10,"RLRLRLRLRL")));
		System.out.println(Arrays.toString(a.animate(1,"...")));
		System.out.println(Arrays.toString(a.animate(1,"LRRL.LR.LRR.R.LRRL.")));
	}
}
