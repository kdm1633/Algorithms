public class DQuads
{
	public int count(String[] flights) {
		int n = flights.length;
		int count=0;
		int[][] a = new int[n][n];

		for (int i=0; i < n; i++) {
			if(flights[i].length() == 0) continue;

			String[] s = flights[i].split(" ");
			for (int j=0; j < s.length; j++)
				a[i][Integer.parseInt(s[j])]++;
		}

		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++) {
				for (int k=0; k < n; k++) {
					for (int l=0; l < n; l++) {
						if(i==j || i==k || i==l || j==k || j==l || k==l) continue;
						if(a[i][j]==0 || a[j][k]==0 || a[k][l]==0 || a[l][i]==0) continue;
						if(a[i][k]>0 || a[k][i]>0 || a[j][l]>0 || a[l][j]>0) continue;
						count += a[i][j]*a[j][k]*a[k][l]*a[l][i];
					}
				}
			}
		}

		return count/4;
	}

	public static void main(String[] args) {
		DQuads d = new DQuads();
		System.out.println(d.count(new String[]{"1 1 1 1 1 1 1 1 1 1","2","3","0"}));
		System.out.println(d.count(new String[]{"1 1 1 1 1 1 1 1 1 1","2","3","0 1"}));
		System.out.println(d.count(new String[]{"","6 0 2","","6 6 4","6 5 5 0","",""}));
		System.out.println(d.count(new String[]{"1", "0 2", "3 1", "0"}));
		System.out.println(d.count(new String[]{"3 4 8 3 7","0","4 0","","1 7 7 0","0 0 2","5 4 8 3 8","5 4 5 5 6",""}));
		System.out.println(d.count(new String[]{"3 3 6","0","5 5 6 3","2 4 1 4","6 3 6 6","3","5 0 2"}));
		System.out.println(d.count(new String[]{"8 1 2 4 8 12 4 5 11 10 6 2","5 3 15 7 15 15 12 0 8 9 2 0 13 9 8 7 4 7 9 11 11","6 7 11 9 10 1 12 9","6 6 9 7 6 1 14 1 6 7 10 6 15 6 14 16 10 11 13 4 7","14 15 16 0 13 2 5 16 6","2 7 16 13 16 10 16 0 8 6 0 2 6","8 8 4 11 3 14 9 14 14 0 5 10 13 3 11 9 5 7","13 15 6 1 3 13 6 6 8 9 6 4 10","4 0 1 4 12 1 2 0 14 9 6 4 16 10 7 6 9 7 13 14","11 12 4 12","6 4 4 9 3 1 8 0 14 14 9 14 16 5 8 16 5 12 4 5 1 12","14 7 14 8 4 16 6 3 13 6 10 7 13 3","15 4","12 14 14 0 8 12 11 4 3 1 12 1","13 4 4 6 12 0","9 0 2 9 5 10","6 15 6 13 4 5 1 6"}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=114853&rd=4497&pm=1663
