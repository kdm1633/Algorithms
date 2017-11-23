import java.util.Arrays;

public class Swimmers
{
	public int[] getSwimTimes(int[] distances, int[] speeds, int current) {
		int[] res = new int[distances.length];
		for (int i=0; i < distances.length; i++) {
			if(distances[i] == 0) res[i] = 0;
			else if(speeds[i] <= current) res[i] = -1;
			else res[i] = (int)((double)distances[i]/(speeds[i]+current) + (double)distances[i]/(speeds[i]-current));
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Swimmers s = new Swimmers();
		System.out.println(Arrays.toString(s.getSwimTimes(new int[]{300,300,300}, new int[]{1,2,3}, 2)));
		System.out.println(Arrays.toString(s.getSwimTimes(new int[]{500,500}, new int[]{4,5}, 2)));
		System.out.println(Arrays.toString(s.getSwimTimes(new int[]{0,0}, new int[]{1,2}, 1)));
		System.out.println(Arrays.toString(s.getSwimTimes(new int[]{0,1}, new int[]{0,0}, 0)));
		System.out.println(Arrays.toString(s.getSwimTimes(
		new int[]{ 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583, 7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691,7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823, 7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919 },
		new int[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 99, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 51 },
		6)));
	}
}

// References
// https://community.topcoder.com/stat?c=problem_solution&cr=110079&rd=4650&pm=1888
