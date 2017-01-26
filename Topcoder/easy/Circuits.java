public class Circuits
{
	public int howLong(String[] connects, String[] costs) {
		int N = connects.length;
		int cost[][] = new int[N][N];

		for(int i=0; i<N; i++)
			if(!connects[i].equals("")) {
				String t1[] = connects[i].split(" ");
				String t2[] = costs[i].split(" ");
				for(int j=0; j<t1.length; j++) {
					int t = Integer.parseInt(t1[j]);
					int c = Integer.parseInt(t2[j]);
					cost[i][t] = c;
				}
			}

		for(int k=0; k<N; k++)
		for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
			if(cost[i][j]<cost[i][k]+cost[k][j] && cost[i][k]!=0 && cost[k][j]!=0)
				cost[i][j] = cost[i][k]+cost[k][j];
		
		int ans = 0;
		for(int i=0; i<N; i++)
		for(int j=0; j<N; j++)
			if(cost[i][j] > ans) ans = cost[i][j];
		
		return ans;
	}

	public static void main(String[] args) {
		Circuits c = new Circuits();
		System.out.println(c.howLong(new String[]{"1 2","2",""}, new String[]{"5 3","7",""}));
		System.out.println(c.howLong(new String[]{"1 2 3 4 5","2 3 4 5","3 4 5","4 5","5",""}, new String[]{"2 2 2 2 2","2 2 2 2","2 2 2","2 2","2",""}));
		System.out.println(c.howLong(new String[]{"1","2","3","","5","6","7",""}, new String[]{"2","2","2","","3","3","3",""}));
		System.out.println(c.howLong(new String[]{"","2 3 5","4 5","5 6","7","7 8","8 9","10","10 11 12","11","12","12",""}, new String[]{"","3 2 9","2 4","6 9","3","1 2","1 2","5","5 6 9","2","5","3",""}));
		System.out.println(c.howLong(new String[]{"","2 3","3 4 5","4 6","5 6","7","5 7",""}, new String[]{"","30 50","19 6 40","12 10","35 23","8","11 20",""}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=266571&rd=4494&pm=1593
