import java.util.Arrays;

public class PickTeam
{
	int n, bestSum;
	int[] team;
	int[][] nums;
	String[] names, bestTeam;

	void recur(int idx, int size) {
		if(size == team.length) {
			int sum=0;
			for(int i=0; i < team.length; i++)
				for(int j=i+1; j < team.length; j++)
					sum += nums[team[i]][team[j]];

			if(sum > bestSum) {
				bestSum = sum;
				for(int j=0; j < team.length; j++)
					bestTeam[j] = names[team[j]];
			}
			return;
		}

		for (int i=idx; i < n; i++) {
			if(team.length-size+i-1 == n) break;
			team[size] = i;
			recur(i+1, size+1);
		}
	}

	public String[] pickPeople(int teamSize, String[] people) {
		n = people.length;
		bestSum = Integer.MIN_VALUE;

		team = new int[teamSize];
		nums = new int[n][n];
		names = new String[n];
		bestTeam = new String[teamSize];

		for (int i=0; i < n; i++) {
			String[] s = people[i].split(" ");

			names[i] = s[0];

			for(int j=1; j < s.length; j++)
				nums[i][j-1] = Integer.parseInt(s[j]);
		}

		recur(0,0);

		Arrays.sort(bestTeam);

		return bestTeam;
	}

	public static void main(String[] args) {
		PickTeam p = new PickTeam();
		System.out.println(Arrays.toString(p.pickPeople(3, new String[]{"ALICE 0 1 -1 3","BOB 1 0 2 -4","CAROL -1 2 0 2","DAVID 3 -4 2 0"})));
		System.out.println(Arrays.toString(p.pickPeople(2, new String[]{"ALICE 0 1 -1 3","BOB 1 0 2 -4","CAROL -1 2 0 2","DAVID 3 -4 2 0"})));
		System.out.println(Arrays.toString(p.pickPeople(2, new String[]{"A 0 -2 -2","B -2 0 -1","C -2 -1 0"})));
		System.out.println(Arrays.toString(p.pickPeople(13, new String[]{"A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5","A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3","A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8","A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8","B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2","B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2","B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3","B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4","C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4","C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4","C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4","C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2","D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6","D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1","D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3","D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7","E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5","E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8","E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1","E -5 3 -8 8 -2 -2 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"})));
	}
}
