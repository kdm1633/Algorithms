import java.util.Arrays;

public class ShuffleMethod
{
	int n,f,cnt;
	boolean[] fixed, used;
	int[] ts;
	int[] sn;					// sn: selected numbers
	int[][] pn;					// pn: possible numbers
	int[] idx;
	
	boolean search(int[] r) {
		for (int a=r[0]; idx[a] < n-2-f; idx[a]++) {
			sn[a] = pn[a][idx[a]];
			used[sn[a]] = true;
			
			int i = a;
			cnt = 1+ts.length-r.length;
			while (true) {
				if (sn[sn[i]] != 0) {
					if (sn[sn[i]] == ts[i-1]) {
						int cnt1=0;
						for (int k=0; k < r.length; k++)
							if(!used[r[k]]) cnt1++;
						
						int[] temp = new int[cnt1];
						for (int k=0,l=0; k < r.length; k++)
							if(!used[r[k]]) temp[l++] = r[k];
						
						return search(temp);
					}
					else break;
				}
				
				for (int j=sn[i]; idx[j] < n-2-f; idx[j]++) {
					if (pn[j][idx[j]] == ts[i-1] && !used[ts[i-1]]) {
						sn[j] = ts[i-1]; break;
					}
				}
				
				if(sn[sn[i]] == 0) break;
				
				if(++cnt == ts.length) return true;
				
				i = sn[i]; used[sn[i]] = true;
			}
			
			for (int j=0; j < r.length; j++) {
				used[r[j]] = false;
				sn[r[j]] = 0;
			}
			for (int j=1; j < r.length; j++)
				idx[r[j]] = 1;
		}
		
		return false;
	}

	public int[] oneTime(int[] twoShuffle) {
		ts = twoShuffle;
		n = twoShuffle.length+1;
		f = 0;

		fixed = new boolean[n];
		used = new boolean[n];
		idx = new int[n];
		sn = new int[n];

		for (int i=1; i < n; i++) {
			if (i == ts[i-1]) {
				fixed[i] = true;
				sn[i] = i;
				f++;
			}
		}
		
		if(f == ts.length) return ts;

		pn = new int[n][n-2-f];
		for (int i=1; i < n; i++) {
			if(fixed[i]) continue;
			for (int j=1, k=1; j < n; j++) {
				if(i==j || j==twoShuffle[i-1] || fixed[j]) continue;
				pn[i][k++] = j;
			}
		}
		
		for (int i=1; i < n; i++)
			idx[i] = 1;
		
		int[] r = new int[ts.length-f];
		for (int i=0,j=1; j < n; j++)
			if(!fixed[j]) r[i++] = j;
		
		if(search(r)) {
			int[] res = new int[n-1];
			System.arraycopy(sn,1,res,0,res.length);
			return res;
		}

		return new int[0];
	}

	public static void main(String[] args) {
		ShuffleMethod s = new ShuffleMethod();
		System.out.println(Arrays.toString(s.oneTime(new int[]{3,4,1,2})));
		System.out.println(Arrays.toString(s.oneTime(new int[]{1,2,3,4})));
		System.out.println(Arrays.toString(s.oneTime(new int[]{5,1,2,3,4})));
		System.out.println(Arrays.toString(s.oneTime(new int[]{2,4,6,5,1,8,10,9,3,12,11,13,7,15,16,17,14})));
		System.out.println(Arrays.toString(s.oneTime(new int[]{2,4,6,5,1,8,10,9,3,12,11,13,7})));
		System.out.println(Arrays.toString(s.oneTime(new int[]{10,9,12,8,13,3,4,1,5,11,6,2,7})));
	}
}
