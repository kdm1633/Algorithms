import java.util.Arrays;

public class UndergroundVault
{
	int n;
	int cnt;

	boolean[][] d;
	boolean[] visit;
	boolean[] seal;

	void explore(int i) {
		if(seal[i] || visit[i]) return;

		cnt++;
		visit[i] = true;

		for (int j=0; j < n; j++)
			if(d[i][j]) explore(j);
	}

	public int[] sealOrder(String[] rooms) {
		n = rooms.length;
		d = new boolean[n][n];
		visit = new boolean[n];
		seal = new boolean[n];

		for (int i=0; i < n; i++) {
			String[] x = rooms[i].split(",");

			for (String s : x)
				if(s != "") d[i][Integer.parseInt(s)] = true;
		}

		int[] sol = new int[n];

		for (int i=0; i < n; i++) {
			int maxi = -1;
			int max = -1;

			for (int j=0; j < n; j++) {
				if (!seal[j]) {
					visit = new boolean[n];
					seal[j] = true;

					cnt=0;
					explore(0);
					if(cnt > max) {max = cnt; maxi = j;}

					seal[j] = false;
				}
			}

			seal[maxi] = true;
			sol[i] = maxi;
		}

		return sol;
	}

	public static void main(String[] args) {
		UndergroundVault u = new UndergroundVault();
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2",""})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2","3","1"})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"3,5","2","8","","","6,7","","1,8","4"})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1,2","3","3,5","4","",""})));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=2059354&rd=4660&pm=1939
