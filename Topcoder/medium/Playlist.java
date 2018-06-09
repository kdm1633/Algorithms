import java.util.Arrays;

public class Playlist
{
	public int[] trackSort(int n, int[] best, int[] a) {
		int[] res = new int[n];
		boolean[] used = new boolean[n+1];

		Arrays.sort(best);

		if (best.length==0 || a.length==0) {
			for (int i=1; i <= n; i++) res[i-1] = i;

			return res;
		}

		int[] cnta = new int[n+1];
		for (int i=0; i < a.length; i++) cnta[a[i]]++;

		int cnt=0;
		for (int i=0; i <= n; i++) if(cnta[i] != 0) cnt++;
		
		int[] an = new int[cnt];
		int[] A = new int[cnt];
		for (int i=0,j=0; i <= n; i++) {
			if (cnta[i] != 0) {
				an[j] = cnta[i];
				A[j++]= i;
			}
		}

		if (best.length > A.length) {
			Arrays.sort(A);

			int spare = best.length-A.length;
			for (int i=0,j=0; i<best.length && j<A.length; i++) {
				if (best[i] >= A[j]) {
					used[best[i]] = true;
					res[A[j]-1] = best[i];
					j++;
				}
				else if (spare-- == 0) {
					if (j == A.length-1) {
						used[best[i]] = true;
						res[A[j]-1] = best[i];
					}
					break;
				}
			}
		}
		else if (best.length == A.length) {
			Arrays.sort(A);

			for (int i=0; i < best.length; i++) {
				used[best[i]] = true;
				res[A[i]-1] = best[i];
			}
		}
		else {
			for (int i=0; i < an.length-1; i++) {
				for (int j=i+1; j < an.length; j++) {
					if (an[j] > an[i]) {
						int temp = an[i];
						an[i] = an[j];
						an[j] = temp;
						temp = A[i];
						A[i] = A[j];
						A[j] = temp;
					}
					else if (an[j]==an[i] && A[j]<A[i]) {
						int temp = an[i];
						an[i] = an[j];
						an[j] = temp;
						temp = A[i];
						A[i] = A[j];
						A[j] = temp;
					}
				}
			}

			int len = best.length;
			int cur = best.length-1;
			cnt=1;
			for(int i=cur-1; i>=0 && an[i]==an[cur]; i--) cnt++;
			for(int i=cur+1; i<an.length && an[i]==an[cur]; i++) {cnt++; len=i+1;}

			Arrays.sort(A,0,len);

			int spare = len-best.length;
			for (int i=0; i < best.length; i++) {
				int min=51, mIdx=-1, sp=spare;
				for (int j=0; j < len; j++) {
					if (Math.abs(A[j]-best[i])<min && res[A[j]-1]==0) {
						if (A[j]<best[i] && sp-- > 0) continue;
						used[best[i]] = true;
						res[A[j]-1] = best[i];
						break;
					}
				}
			}
		}

		for (int i=0,j=1; i < n; i++) {
			if (res[i] != 0) continue;

			for (; j <= n; j++) {
				if (!used[j]) {
					res[i] = j++;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Playlist p = new Playlist();
		System.out.println(Arrays.toString(p.trackSort(3,new int[]{1, 2}, new int[]{3, 2, 3, 3, 1, 2})));	//{3, 1, 2 }
		System.out.println(Arrays.toString(p.trackSort(5,new int[]{}, new int[]{1, 2, 3, 5, 4})));	//{1, 2, 3, 4, 5 }
		System.out.println(Arrays.toString(p.trackSort(6,new int[]{3, 5}, new int[]{1, 2, 3, 4, 5, 2, 3, 2, 6})));	//{1, 3, 5, 2, 4, 6 }
		System.out.println(Arrays.toString(p.trackSort(3,new int[]{3, 2, 1}, new int[]{3, 1, 2, 3, 2, 1, 2, 1, 3})));	//{1, 2, 3 }
		System.out.println(Arrays.toString(p.trackSort(5,new int[]{4, 5, 3}, new int[]{5, 5, 5, 3, 2, 1, 4, 3})));	//{1, 2, 3, 4, 5 }
		System.out.println(Arrays.toString(p.trackSort(10,new int[]{8, 5, 1, 7}, new int[]{6, 6, 4, 4})));	//{1, 2, 3, 5, 4, 7, 6, 8, 9, 10 }
		System.out.println(Arrays.toString(p.trackSort(8,new int[]{6}, new int[]{2, 8, 3, 1, 5, 7, 7, 8, 4, 4})));	//{1, 2, 3, 4, 5, 7, 6, 8 }
	}
}
