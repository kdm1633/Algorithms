import java.util.Arrays;

public class QuipuReader
{
	public int[] readKnots(String[] knots) {
		int m = knots.length;
		int n = knots[0].length();

		boolean[] f = new boolean[50], g = new boolean[50];

		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				if(j!=0 && knots[i].charAt(j)=='X' && knots[i].charAt(j-1)=='X') f[j]=true;
				if(knots[i].charAt(j)=='X') g[j]=true;
			}
		}

		for(int j=0; j < n; j++) if(!g[j]) f[j]=true;

		int[] res = new int[m];

		for (int i=0; i < m; i++) {
			for (int j=0; j < n; j++) {
				if(!f[j]) res[i] *= 10;
				if(knots[i].charAt(j) == 'X') res[i] += 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		QuipuReader q = new QuipuReader();
		System.out.println(Arrays.toString(q.readKnots(new String[]{
			"-XXXXXXX--XX-----XXXXX---",
			"---XX----XXX-----XXXX----",
			"-XXXXX---XXXXX--XXXXXXXX-" })));
		System.out.println(Arrays.toString(q.readKnots(new String[]{
			"XX---XXXX",
			"XXX-----X" })));
		System.out.println(Arrays.toString(q.readKnots(new String[]{
			"-XXX---XX----X",
			"--X----X-XXXXX",
			"-XX--XXXX---XX" })));
		System.out.println(Arrays.toString(q.readKnots(new String[]{
			"-------X--------",
			"--XXX----XXXX---",
			"--------------XX" })));
		System.out.println(Arrays.toString(q.readKnots(new String[]{
			"--XXX-XXXXXXXX----------XXXXXXXXX--XXXXXXXX-",
			"--XX----XXXX-----XXXXXX---XXX------XXXXXXXX-",
			"--------------------X----XXXXXXXX--XXXXXXXX-",
			"--XX-------X------XXXX----XXX-------XXXXXX--",
			"--XXX---XXXXX-------X------XX--------X------",
			"-XXXX--XXXXXXX-----------XXXXXXX----XXXXX---",
			"-----------X---XXXXXXXX----XX--------XXX----",
			"-----------X---XXXXXXXX----X----------------",
			"---X--XXXXXXXX--XXXXXXX---XXX---------------",
			"--XX---XXXXXXX--XXXXXXX----XX-------XXXXX---" })));
		System.out.println(Arrays.toString(q.readKnots(new String[]{"X","-"})));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=305142&rd=4580&pm=1694
