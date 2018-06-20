import java.util.Arrays;

public class GreedyChange
{
	public int smallest(int[] denoms) {
		Arrays.sort(denoms);
		
		int max = denoms[denoms.length-1]*2;
		int[] mins = new int[max+1];

		for (int i=1; i<=max; i++)
			mins[i] = 9999999;

		for (int i=1; i <= max; i++)
			for (int j=0; j < denoms.length; j++)
				if(denoms[j] <= i)
					mins[i] = Math.min(mins[i], 1 + mins[i-denoms[j]]);

		int index=0;

		for (int i=1; i <= max; i++) {
			while (1+index < denoms.length && denoms[1+index]<=i)
				index++;

			if (mins[i] != 1+mins[i-denoms[index]])
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		GreedyChange g = new GreedyChange();
		System.out.println(g.smallest(new int[]{1,25,10,5}));
		System.out.println(g.smallest(new int[]{1,3,4}));
		System.out.println(g.smallest(new int[]{1,10,10,20,25}));
		System.out.println(g.smallest(new int[]{1,15,25}));
		System.out.println(g.smallest(new int[]{1,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62,64,66,68,70,72,74,76,78,80,82,84,86,88,90,92,94,96,500000}));
		System.out.println(g.smallest(new int[]{500000,499999,1}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=157974&rd=4474&pm=1579
