import java.util.Arrays;

public class Workshop
{
	public int pictureFrames(int[] pieces) {
		Arrays.sort(pieces);

		int res = 0;
		int n = pieces.length;

		for (int i=0; i < n-2; i++)
		for (int j=i+1; j < n-1; j++)
		for (int k=j+1; k < n; k++)
			if(pieces[i]+pieces[j] > pieces[k])
				res++;

		return res;
	}

	public static void main(String[] args) {
		Workshop w = new Workshop();
		System.out.println(w.pictureFrames(new int[]{1,2,3,4,5}));
		System.out.println(w.pictureFrames(new int[]{8,5,3}));
		System.out.println(w.pictureFrames(new int[]{4,23,76,22,87,3,1,99}));
		System.out.println(w.pictureFrames(new int[]{10000,9999,9998,9997,9996,1,2,3,4,5}));
		System.out.println(w.pictureFrames(new int[]{100}));
	}
}
