import java.util.PriorityQueue;

public class CavePassage
{
	class Item implements Comparable<Item>
	{
		int state;
		int prior;

		Item(int s, int p) {
			state = s;
			prior = p;
		}

		public int compareTo(Item o) {
			if(prior > o.prior) return 1;
			else if(prior == o.prior) return 0;
			else return -1;
		}
	}

	boolean trusted(String[] table, int bits) {
		if(Integer.bitCount(bits) == 1) return true;

		int N = table.length;
		for (int i = 0; i < N; i++) {
			if ((bits & (1 << i)) > 0) {
				boolean good = false;
				for (int j = 0; j < N; j++)
					if(i!=j && table[i].charAt(j) == 'Y' && (bits & (1 << j))>0) good = true;

				if(!good) return false;
			}
		}

		return true;
	}

	public int minimalTime(int[] travelersWeights, int[] travelersTimes, String[] trustTable, int bridgeStrength) {
		int N = travelersWeights.length;
		int[] speed = new int[1 << N];
		for (int b = 1; b < (1 << N); b++) {
			if (!trusted(trustTable, b)) {
				speed[b] = -1;
				continue;
			}

			speed[b] = 0;
			int tweight = 0;
			for (int i = 0; i < N; i++) {
				if ((b & (1 << i)) > 0) {
					tweight += travelersWeights[i];
					speed[b] = Math.max(speed[b], travelersTimes[i]);
				}
			}
			if(tweight > bridgeStrength) speed[b] = -1;
		}

		int M = 1 << N;

		PriorityQueue<Item> q = new PriorityQueue<Item>();
		q.add(new Item(0,0));
		int[] prior = new int[2 << N];
		for (int i = 1; i < prior.length; i++)
			prior[i] = Integer.MAX_VALUE;

		while (q.size() != 0) {
			int s = q.peek().state;
			int p = q.peek().prior;
			q.poll();

			if(prior[s] != p) continue;

			int moveable = ((s & M) > 0) ? s & (M - 1) : ~s & (M - 1);
			for (int m = moveable; m != 0; m = (m - 1) & moveable) {
				if (speed[m] != -1) {
					int s2 = s ^ m ^ M;
					int p2 = p + speed[m];
					if (p2 < prior[s2]) {
						prior[s2] = p2;
						q.add(new Item(s2,p2));
					}
				}
			}
		}

		int trg = (2 << N) - 1;
		if(prior[trg] == Integer.MAX_VALUE) return -1;

		return prior[trg];
	}

	public static void main(String[] args) {
		CavePassage c = new CavePassage();
		System.out.println(c.minimalTime(new int[]{ 1, 1, 1 }, new int[]{ 2, 3, 4 }, new String[]{ "YYY", "YYY", "YYY" }, 2));
		System.out.println(c.minimalTime(new int[]{ 1, 1, 1 }, new int[]{ 2, 3, 4 }, new String[]{ "YYY", "YYY", "NYY" }, 2));
		System.out.println(c.minimalTime(new int[]{ 1, 1, 1 }, new int[]{ 7, 13, 19 }, new String[]{ "YYN", "NYY", "YNY" }, 3));
		System.out.println(c.minimalTime(new int[]{ 43 }, new int[]{ 23 }, new String[]{ "Y" }, 42));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=251074&rd=13513&pm=10123
