import java.util.Arrays;

public class ShuffleMethod
{
	int n;

	int[] ts;

	boolean[] flag;
	int[] sn;				// selected number
	int[][] pn;				// possible number

	boolean visit(int cnt) {
		for (int i = 0; i < n; i++) {
			if (flag[i+1]) continue;

			for (int j = 0; j < pn[i].length; j++) {
				if (flag[pn[i][j]]) continue;

				sn[i] = pn[i][j];
				flag[sn[i]] = true;

				int a = sn[i]-1;
				int b = i;
				int cnt1 = cnt+1;
				boolean[] used = new boolean[n];
				for (int k = 0; k < pn[a].length; k++) {
					if (flag[pn[a][k]] || pn[a][k]!=ts[b] || sn[a]!=0) continue;

					sn[a] = ts[b];
					flag[sn[a]] = true;
					used[a] = true;
					cnt1++;
					if (cnt1 == n) return true;
					b = a;
					a = sn[a]-1;
					k = -1;
					if (ts[b] == sn[a]) return visit(cnt1);
				}

				flag[sn[i]] = false;

				for (int k = 0; k < n; k++)
					if (used[k]) {flag[sn[k]] = false; sn[k] = 0;}
			}
		}

		return false;
	}

	public int[] oneTime(int[] twoShuffle) {
		n = twoShuffle.length;
		ts = twoShuffle;

		flag = new boolean[n+1];
		sn = new int[n];

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (i+1 == ts[i]) {
				flag[i+1] = true;
				sn[i] = i+1;
				cnt++;
			}
		}
		if (cnt == n) return sn;

		pn = new int[n][n-2-cnt];

		for (int i = 0; i < n; i++) {
			if (flag[i+1]) continue;

			for (int j = 0, k = 0; j < n; j++) {
				if (i==j || j+1==ts[i] || flag[j+1]) continue;
				pn[i][k++] = j+1;
			}
		}

		if (visit(cnt)) return sn;

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
		System.out.println(Arrays.toString(s.oneTime(new int[]{7, 46, 13, 47, 48, 33, 23, 45, 10, 37, 12, 26, 16, 42, 34, 15, 50, 11, 44, 39, 17, 25, 38, 28, 27, 21, 5, 40, 36, 35, 31, 14, 1, 19, 24, 30, 43, 29, 9, 6, 49, 4, 8, 20, 3, 41, 22, 2, 32, 18})));
	}
}
