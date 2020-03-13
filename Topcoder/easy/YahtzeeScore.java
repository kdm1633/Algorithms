// #1
public class YahtzeeScore		// This problem is equal to Yahtzee.
{
	public int maxPoints(int[] toss) {
		int max=0;
		int[] num = new int[7];

		for(int i=0; i < 5; i++)
			num[toss[i]]++;

		for(int i=1; i < 7; i++)
			if(num[i]*(i) > max) max = num[i]*(i);

		return max;
	}

	public static void main(String[] args) {
		Yahtzee y = new Yahtzee();
		System.out.println(y.maxPoints(new int[]{2,2,3,5,4}));
		System.out.println(y.maxPoints(new int[]{6,4,1,1,3}));
		System.out.println(y.maxPoints(new int[]{5,3,5,3,3}));
	}
}

// #2
// public class YahtzeeScore
// {
// 	public int maxPoints(int[] toss) {
// 		int max = 0;

// 		for(int val = 1; val <= 6; val++) {
// 			int sum = 0;

// 			for (int i = 0; i < 5; i++)
// 				if (val == toss[i]) sum += toss[i];

// 			if (sum > max) max = sum;
// 		}

// 		return max;
// 	}
// }
