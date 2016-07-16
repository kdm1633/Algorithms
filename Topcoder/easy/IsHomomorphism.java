import java.util.Arrays;

public class IsHomomorphism
{
	public String[] numBad(String[] source, String[] target, int[] mapping) {
		int row = source.length, col = source[0].length();
		String[] res1 = new String[row*col];

		int idx=0;
		for(int i=0; i < row; i++) {
			for(int j=0; j < col; j++) {
				int n1 = mapping[source[i].charAt(j) - '0'];
				int n2 = target[mapping[i]].charAt(mapping[j]) - '0';

				if(n1!=n2) res1[idx++] = "(" + i + "," + j + ")";
			}
		}

		String[] res2 = new String[idx];

		for(int i=0; i < idx; i++)
			res2[i] = res1[i];

		return res2;
	}

	public static void main(String[] args) {
		IsHomomorphism i = new IsHomomorphism();
		System.out.println(Arrays.toString(i.numBad(new String[]{"0000","0123","0202","0321"}, new String[]{"0000","0123","0202","0321"},new int[]{0,1,2,3})));
		System.out.println(Arrays.toString(i.numBad(new String[]{"0123456","1234560","2345601","3456012","4560123","5601234","6012345"},new String[]{"0123456","1234560","2345601","3456012","4560123","5601234","6012345"},new int[]{1,3,2,1,2,1,1})));
		System.out.println(Arrays.toString(i.numBad(new String[]{"012", "120", "210"},new String[]{"012", "120", "110"},new int[]{0,1,2})));
		System.out.println(Arrays.toString(i.numBad(new String[]{"012", "120", "210"},new String[]{"012", "120", "210"},new int[]{1,2,0})));
		System.out.println(Arrays.toString(i.numBad(new String[]{"01","10"},new String[]{"10","01"},new int[]{1,0})));
	}
}
