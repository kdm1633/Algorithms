import java.util.ArrayList;

public class PenLift
{
	int len, size;
	boolean[] usedS, usedV;
	int[] nv;					// num of vertices
	int[][] adj1, adj2;

	ArrayList<Integer> xv, yv;

	boolean contains(int x,int y) {
		for (int i = 0; i < xv.size(); i++)
			if (xv.get(i)==x && yv.get(i)==y)
				return true;

		return false;
	}

	int dfs(int i) {
		usedS[i] = true;

		int nov = 0;

		for (int j = 0; j < xv.size(); j++) {
			if (!usedV[j] && adj2[i][j]!=0 && nv[j]%2==1) {
				nov++;
				usedV[j] = true;
			}
		}

		for (int j = 0; j < len; j++)
			if (!usedS[j] && adj1[i][j]!=0)
				nov += dfs(j);

		return nov;
	}

	public int numTimes(String[] segments, int n){
		len = segments.length;
		usedS = new boolean[len];

		adj1 = new int[len][len];

		xv = new ArrayList<Integer>();
		yv = new ArrayList<Integer>();

		int[][] p = new int[len][4];

		for (int i = 0; i < len; i++) {
			String[] segment = segments[i].split(" ");

			for (int j = 0; j < 4; j++)
				p[i][j] = Integer.parseInt(segment[j]);

			if (p[i][2]<p[i][0] || p[i][3]<p[i][1]) {
				int a = p[i][0], b = p[i][1];
				p[i][0] = p[i][2]; p[i][1] = p[i][3];
				p[i][2] = a; p[i][3] = b;
			}
		}

		// merging overapping segments
		for (int i = 0; i < len; i++) {
			if (usedS[i]) continue;

			int a = -1, b = -1, c = -1, d = -1;
			if (p[i][1]==p[i][3]) {a = 0; b = 2; c = 1; d = 3;}
			else if (p[i][0]==p[i][2]) {a = 1; b = 3; c = 0; d = 2;}

			boolean flag = true;
			while (flag) {
				flag = false;
				for (int j = i+1; j < len; j++) {
					if (usedS[j]) continue;

					if (p[i][c]==p[j][c] && p[j][c]==p[j][d]) {
						if (p[j][a]<=p[i][a] && p[i][a]<p[j][b]) {
							p[i][a] = p[j][a];
							if (p[i][b]<p[j][b]) p[i][b] = p[j][b];
							usedS[j] = true;
							flag = true;
						}
						else if (p[i][a]<=p[j][a] && p[j][a]<p[i][b]) {
							if (p[i][b]<p[j][b]) p[i][b] = p[j][b];
							usedS[j] = true;
							flag = true;
						}
					}
				}
			}
		}

		// connecting adjacent segments and adding crossing vertices
		for (int i = 0; i < len; i++) {
			if (usedS[i]) continue;

			for (int j = i+1; j < len; j++) {
				if (usedS[j]) continue;

				if (p[i][0]==p[j][0] && p[i][1]==p[j][1] || p[i][0]==p[j][2] && p[i][1]==p[j][3] ||
					p[i][2]==p[j][0] && p[i][3]==p[j][1] || p[i][2]==p[j][2] && p[i][3]==p[j][3]) {
					adj1[i][j]++; adj1[j][i]++;
				}
				else if (p[i][0]<=p[j][0] && p[j][0]<=p[i][2] && p[j][1]<=p[i][1] && p[i][1]<=p[j][3]) {
					xv.add(p[j][0]); yv.add(p[i][1]);
					adj1[i][j]++; adj1[j][i]++;
				}
				else if (p[j][0]<=p[i][0] && p[i][0]<=p[j][2] && p[i][1]<=p[j][1] && p[j][1]<=p[i][3]) {
					xv.add(p[i][0]); yv.add(p[j][1]);
					adj1[i][j]++; adj1[j][i]++;
				}
			}
		}

		// adding all of the vertices
		for (int i = 0; i < len; i++) {
			if (usedS[i]) continue;

			if (!contains(p[i][0],p[i][1])) {xv.add(p[i][0]); yv.add(p[i][1]);}
			if (!contains(p[i][2],p[i][3])) {xv.add(p[i][2]); yv.add(p[i][3]);}
		}

		nv = new int[xv.size()];
		adj2 = new int[len][xv.size()];

		// connecting vertices into segments
		for (int a = 0; a < xv.size(); a++) {
			int x = xv.get(a);
			int y = yv.get(a);
			for (int i = 0; i < len; i++) {
				if (usedS[i]) continue;

				if ((x==p[i][0] && y==p[i][1]) || (x==p[i][2] && y==p[i][3])) {
					nv[a]++;
					adj2[i][a]++;
				}
				else if (p[i][1]==p[i][3] && (p[i][0]<x && x<p[i][2] && y==p[i][1])) {
					nv[a] += 2;
					adj2[i][a]++;
				}
				else if (p[i][0] == p[i][2] && (p[i][1]<y && y<p[i][3] && x==p[i][0])) {
					nv[a] += 2;
					adj2[i][a]++;
				}
			}
		}

		usedV = new boolean[xv.size()];

		int min = 0;

		// Searching the number of odd vertices in each component
		for (int i = 0; i < len; i++) {
			if (usedS[i]) continue;

			usedS[i] = true;

			int nov = 0;	// number of odd vertices

			for (int j = 0; j < xv.size(); j++) {
				if (!usedV[j] && adj2[i][j]!=0 && nv[j]%2==1) {
					nov++;
					usedV[j] = true;
				}
			}

			for (int j = 0; j < len; j++)
				if (!usedS[j] && adj1[i][j]!=0)
					nov += dfs(j);

			if (n%2 == 0) nov = 0;

			min += (nov == 0) ? 1 : nov/2;
		}

		return min - 1;
	}

	public static void main(String[] args) {
		PenLift p = new PenLift();
		System.out.println(p.numTimes(new String[]{"-10 0 10 0","0 -10 0 10"},1));
		System.out.println(p.numTimes(new String[]{"-10 0 0 0","0 0 10 0","0 -10 0 0","0 0 0 10"},1));
		System.out.println(p.numTimes(new String[]{"-101 0 0 0","0 0 10 0","0 -10 0 0","0 0 0 10"},4));
		System.out.println(p.numTimes(new String[]{"0 0 1 0",   "2 0 4 0",   "5 0 8 0",   "9 0 13 0",
			"0 1 1 1",   "2 1 4 1",   "5 1 8 1",   "9 1 13 1",
			"0 0 0 1",   "1 0 1 1",   "2 0 2 1",   "3 0 3 1",
			"4 0 4 1",   "5 0 5 1",   "6 0 6 1",   "7 0 7 1",
			"8 0 8 1",   "9 0 9 1",   "10 0 10 1", "11 0 11 1",
			"12 0 12 1", "13 0 13 1"},1));
		System.out.println(p.numTimes(new String[]{"-2 6 -2 1",  "2 6 2 1",  "6 -2 1 -2",  "6 2 1 2",
			"-2 5 -2 -1", "2 5 2 -1", "5 -2 -1 -2", "5 2 -1 2",
			"-2 1 -2 -5", "2 1 2 -5", "1 -2 -5 -2", "1 2 -5 2",
			"-2 -1 -2 -6","2 -1 2 -6","-1 -2 -6 -2","-1 2 -6 2"},5));
		System.out.println(p.numTimes(new String[]{"-252927 -1000000 -252927 549481","628981 580961 -971965 580961",
			"159038 -171934 159038 -420875","159038 923907 159038 418077",
			"1000000 1000000 -909294 1000000","1000000 -420875 1000000 66849",
			"1000000 -171934 628981 -171934","411096 66849 411096 -420875",
			"-1000000 -420875 -396104 -420875","1000000 1000000 159038 1000000",
			"411096 66849 411096 521448","-971965 580961 -909294 580961",
			"159038 66849 159038 -1000000","-971965 1000000 725240 1000000",
			"-396104 -420875 -396104 -171934","-909294 521448 628981 521448",
			"-909294 1000000 -909294 -1000000","628981 1000000 -909294 1000000",
			"628981 418077 -396104 418077","-971965 -420875 159038 -420875",
			"1000000 -1000000 -396104 -1000000","-971965 66849 159038 66849",
			"-909294 418077 1000000 418077","-909294 418077 411096 418077",
			"725240 521448 725240 418077","-252927 -1000000 -1000000 -1000000",
			"411096 549481 -1000000 549481","628981 -171934 628981 923907",
			"-1000000 66849 -1000000 521448","-396104 66849 -396104 1000000",
			"628981 -1000000 628981 521448","-971965 521448 -396104 521448",
			"-1000000 418077 1000000 418077","-1000000 521448 -252927 521448",
			"725240 -420875 725240 -1000000","-1000000 549481 -1000000 -420875",
			"159038 521448 -396104 521448","-1000000 521448 -252927 521448",
			"628981 580961 628981 549481","628981 -1000000 628981 521448",
			"1000000 66849 1000000 -171934","-396104 66849 159038 66849",
			"1000000 66849 -396104 66849","628981 1000000 628981 521448",
			"-252927 923907 -252927 580961","1000000 549481 -971965 549481",
			"-909294 66849 628981 66849","-252927 418077 628981 418077",
			"159038 -171934 -909294 -171934","-252927 549481 159038 549481"},824759));
	}
}
