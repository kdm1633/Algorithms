import java.util.Arrays;

public class BridgeCrossing
{
	int n, min;
	boolean[] a;
	int[] times;

	void go(int t, int num) {
		for (int i = 0; i < n; i++) {
			if (!a[i]) continue;

			a[i] = false;

			for (int j = i+1; j < n; j++) {
				if (!a[j]) continue;

				a[j] = false;

				if (num==2 && t+times[j]<min) min = t+times[j];

				for (int k = 0; k < n; k++) {
					if (!a[k]) {
						a[k] = true;
						go(t+times[j]+times[k],num-1);
						a[k] = false;
						break;
					}
				}

				a[j] = true;
			}

			a[i] = true;
		}
	}

	public int minTime(int[] _times) {
		if (_times.length == 1) return _times[0];

		times = _times;
		n = times.length;
		min = 1000;
		a = new boolean[n];
		for (int i = 0; i < n; i++)
			a[i] = true;

		Arrays.sort(times);

		go(0,n);

		return min;
	}

	public static void main(String[] args) {
		BridgeCrossing b = new BridgeCrossing();
		System.out.println(b.minTime(new int[]{ 1, 2, 5, 10 }));
		System.out.println(b.minTime(new int[]{ 1, 2, 3, 4, 5 }));
		System.out.println(b.minTime(new int[]{ 100 }));
		System.out.println(b.minTime(new int[]{ 1, 2, 3, 50, 99, 100 }));
	}
}
