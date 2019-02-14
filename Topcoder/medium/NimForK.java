import java.util.Arrays;
import java.util.ArrayList;

public class NimForK
{
	int n,k;
	int[][] m;
	double[][][] cache;

	double getAverage(ArrayList<Integer> take, int here, int remaining, int whoWins) {
		double ret=0;
		for (int i=0; i < take.size(); i++)
			ret += go((here+1)%k, remaining-take.get(i), whoWins);
		return ret / take.size();
	}

	double go(int here, int remaining, int whoWins) {
		if(remaining == 0) return (whoWins == (here+k-1)%k) ? 1.0 : 0.0;

		double prob = cache[remaining][here][whoWins];
		if(prob >= 0.0) return prob;
		prob = 0.0;

		ArrayList<Integer> winningMove = new ArrayList<Integer>();
		ArrayList<Integer> possibleMove = new ArrayList<Integer>();
		ArrayList<Integer> elseMove = new ArrayList<Integer>();
		for (int i=0; i < m[remaining].length; i++) {
			int take = m[remaining][i];
			if (take <= remaining) {
				double p = go((here+1)%k, remaining-take, here);
				if(p == 1.0)
					winningMove.add(take);
				else if(p > 0.0)
					possibleMove.add(take);
				else
					elseMove.add(take);
			}
		}

		if(winningMove.size() > 0)
			prob = getAverage(winningMove, here, remaining, whoWins);
		else if(possibleMove.size() > 0)
			prob = getAverage(possibleMove, here, remaining, whoWins);
		else if(elseMove.size() > 0)
			prob = getAverage(elseMove, here, remaining, whoWins);
		else
			prob = 0;

		cache[remaining][here][whoWins] = prob;

		return prob;
	}

	public int[] winners(int n, int k, String[] moves) {
		this.n = n; this.k = k;
		m = new int[moves.length+1][0];
		cache = new double[51][21][21];

		for (int i=0; i < 51; i++)
			for (int j=0; j < 21; j++)
				for (int l=0; l < 21; l++)
					cache[i][j][l] = -1;

		for (int i=0; i < moves.length; i++) {
			if(moves[i].length() == 0) continue;
			String[] s = moves[i].split(" ");
			m[i+1] = new int[s.length];
			for (int j=0; j < s.length; j++)
				m[i+1][j] = Integer.parseInt(s[j]);
		}

		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i=0; i < k; i++)
			if (go(0,n,i) > 0) ret.add(i+1);

		int[] res = new int[ret.size()];
		for (int i=0; i < res.length; i++)
			res[i] = ret.get(i);

		return res;
	}

	public static void main(String[] args) {
		NimForK n = new NimForK();
		System.out.println(Arrays.toString(n.winners(8,2,new String[]{"1", "1 2", "1 2 3", "1 2 3", "1 2 3", "1 2 3", "1 2 3", "1 2 3"})));
		System.out.println(Arrays.toString(n.winners(7,2,new String[]{"1", "1 2", "1 2 3", "1 2 3", "1 2 3", "1 2 3", "1 2 3"})));
		System.out.println(Arrays.toString(n.winners(5,3,new String[]{"1", "1 2", "1 2 3", "1 2 3", "1 2 3"})));
		System.out.println(Arrays.toString(n.winners(6,3,new String[]{"1", "1 2", "1 2 3", "1 2 3", "1 2 3", "1 2 3"})));
		System.out.println(Arrays.toString(n.winners(1,20,new String[]{""})));
	}
}
