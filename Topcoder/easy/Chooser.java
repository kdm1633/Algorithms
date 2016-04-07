public class Chooser
{
	public static int numSets(int[] easy, int[] middle, int[] hard) {
		if(easy.length == 0 || middle.length == 0 || hard.length == 0)
			return 0;

		int sum = 0, cnt=0;

		for (int i=0; i < easy.length; i++) {
			for (int j=0; j < middle.length; j++) {
				for (int k=0; k < hard.length; k++) {
					sum = easy[i] + middle[j] + hard[k];
					if(sum >= 60 && sum <= 75) cnt++;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(numSets(new int[]{5,10,15}, new int[]{10,25}, new int[]{45}));
		System.out.println(numSets(new int[]{5,5,5}, new int[]{15,15,15}, new int[]{45,45,45}));
		System.out.println(numSets(new int[]{}, new int[]{15,25}, new int[]{30,35,40}));
	}
}
