import java.util.Arrays;

public class SkipRope
{
	public int[] partners(int[] candidates, int height) {
		Arrays.sort(candidates);

		int[] res = new int[2];

		int best = 201;
		for (int i = 0; i < candidates.length-1; i++) {
			if (Math.abs(candidates[i] - height) + Math.abs(candidates[i+1] - height) <= best) {
				best = Math.abs(candidates[i] - height) + Math.abs(candidates[i+1] - height);
				res[0] = candidates[i]; res[1] = candidates[i+1];
			}
			else break;
		}

		return res;
	}

	public static void main(String[] args) {
		SkipRope s = new SkipRope();
		System.out.println(Arrays.toString(s.partners(new int[]{102, 99, 104},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{102, 97, 104},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{101, 100, 99},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{75, 117, 170, 175, 168, 167, 167, 142, 170, 85, 89, 170},169)));
		System.out.println(Arrays.toString(s.partners(new int[]{134, 79, 164, 86, 131, 78, 99, 150, 105, 163, 150, 110, 90, 137, 127, 130, 121, 93, 97, 131, 170, 137, 171, 153, 137, 138, 92, 103, 149, 110, 156},82)));
	}
}
