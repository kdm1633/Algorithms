import java.util.ArrayList;
import java.util.Arrays;

public class UndergroundVault
{
	int n;

	boolean canBeSealed(int[][] adj, boolean[] sealed, int room) {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i==room || k==room) continue;
					if (adj[i][j] > adj[i][k] + adj[k][j])
						adj[i][j] = adj[i][k] + adj[k][j];
				}
			}
		}

		for (int i = 0; i < n; i++)
			if (!sealed[i] && adj[0][i]==1000000)
				return false;

		return true;
	}

	public int[] sealOrder(String[] rooms) {
		n = rooms.length;
		int[][] adj = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				adj[i][j] = 1000000;
		
		for (int i = 0; i < n; i++) {
			adj[i][i] = 1;

			if (rooms[i].length() == 0) continue;

			String[] next = rooms[i].split(",");
			for (int j = 0; j < next.length; j++)
				adj[i][Integer.parseInt(next[j])] = 1;
		}

		boolean[] sealed = new boolean[n];
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (sealed[j]) continue;

				int[][] temp1 = new int[n][n];
				int[][] temp2 = new int[n][n];
				for (int k = 0; k < n; k++)
				for (int l = 0; l < n; l++)
					temp1[k][l] = temp2[k][l] = adj[k][l];

				for (int k = 0; k < n; k++)
					temp1[j][k] = temp2[j][k] = 1000000;

				if (canBeSealed(temp2,sealed,j)) {
					sealed[j] = true;
					adj = temp1;
					ret.add(j);
					break;
				}
			}
		}

		ret.add(0);

		int[] ra = new int[ret.size()];
		for (int i = 0; i < ra.length; i++)
			ra[i] = ret.get(i);

		return ra;
	}

	public static void main(String[] args) {
		UndergroundVault u = new UndergroundVault();
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2",""})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2","3","1"})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"3,5","2","8","","","6,7","","1,8","4"})));
		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1,2","3","3,5","4","",""})));
	}
}

//import java.util.Arrays;
//
//public class UndergroundVault
//{
//	int n;
//	int cnt;
//
//	boolean[][] d;
//	boolean[] visit;
//	boolean[] seal;
//
//	void explore(int i) {
//		if(seal[i] || visit[i]) return;
//
//		cnt++;
//		visit[i] = true;
//
//		for (int j=0; j < n; j++)
//			if(d[i][j]) explore(j);
//	}
//
//	public int[] sealOrder(String[] rooms) {
//		n = rooms.length;
//		d = new boolean[n][n];
//		visit = new boolean[n];
//		seal = new boolean[n];
//
//		for (int i=0; i < n; i++) {
//			String[] x = rooms[i].split(",");
//
//			for (String s : x)
//				if(s != "") d[i][Integer.parseInt(s)] = true;
//		}
//
//		int[] sol = new int[n];
//
//		for (int i=0; i < n; i++) {
//			int maxi = -1;
//			int max = -1;
//
//			for (int j=0; j < n; j++) {
//				if (!seal[j]) {
//					visit = new boolean[n];
//					seal[j] = true;
//
//					cnt=0;
//					explore(0);
//					if(cnt > max) {max = cnt; maxi = j;}
//
//					seal[j] = false;
//				}
//			}
//
//			seal[maxi] = true;
//			sol[i] = maxi;
//		}
//
//		return sol;
//	}
//
//	public static void main(String[] args) {
//		UndergroundVault u = new UndergroundVault();
//		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2",""})));
//		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1","2","3","1"})));
//		System.out.println(Arrays.toString(u.sealOrder(new String[]{"3,5","2","8","","","6,7","","1,8","4"})));
//		System.out.println(Arrays.toString(u.sealOrder(new String[]{"1,2","3","3,5","4","",""})));
//	}
//}

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm171
// https://community.topcoder.com/stat?c=problem_solution&cr=2059354&rd=4660&pm=1939
