import java.util.Arrays;

public class SkipRope
{
	public int[] partners(int[] candidates, int height) {
		int[] res = new int[2];
		int[] weight = {101,101};
		
		int idx = 0;
		for (int i=0; i < candidates.length; i++) {
			int curWeight = Math.abs(candidates[i]-height);
			if(curWeight==weight[0] && candidates[i]>res[0]) {res[0] = candidates[i]; idx = i;}
			else if(curWeight < weight[0]) {res[0] = candidates[i]; weight[0] = curWeight; idx = i;}
		}
		
		for (int i=0; i < candidates.length; i++) {
			if(idx == i) continue;
			int curWeight = Math.abs(candidates[i]-height);
			if(curWeight==weight[1] && candidates[i]>res[1]) {res[1] = candidates[i];}
			else if(curWeight < weight[1]) {res[1] = candidates[i]; weight[1] = curWeight;}
		}
		
		Arrays.sort(res);
		
		return res;
	}

	public static void main(String[] args) {
		SkipRope s = new SkipRope();
		System.out.println(Arrays.toString(s.partners(new int[]{102, 99, 104},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{102, 97, 104},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{101, 100, 99},100)));
		System.out.println(Arrays.toString(s.partners(new int[]{75, 117, 170, 175, 168, 167, 167, 142, 170, 85, 89, 170},169)));
		System.out.println(Arrays.toString(s.partners(new int[]{134, 79, 164, 86, 131, 78, 99, 150, 105, 163, 150, 110, 90, 137, 127, 130, 121, 
 93, 97, 131, 170, 137, 171, 153, 137, 138, 92, 103, 149, 110, 156},82)));
	}
}
