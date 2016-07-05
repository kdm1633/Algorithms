import java.util.Arrays;

public class ImageDithering
{
	public int count(String dithered, String[] screen) {
		int cnt=0;
		char[] d = dithered.toCharArray();

		Arrays.sort(d);

		for(int i=0; i < screen.length; i++) {
			char[] s = screen[i].toCharArray();
			
			Arrays.sort(s);

			for(int j=0,k=0; j < s.length && k < d.length; ) {
				if(d[k] == s[j]) {cnt++; j++;}
				else if(d[k] < s[j]) k++;
				else j++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		ImageDithering d = new ImageDithering();
		System.out.println(d.count("BW",new String[]{"AAAAAAAA","ABWBWBWA","AWBWBWBA","ABWBWBWA","AWBWBWBA","AAAAAAAA"}));
		System.out.println(d.count("BW",new String[]{"BBBBBBBB", "BBWBWBWB", "BWBWBWBB", "BBWBWBWB", "BWBWBWBB", "BBBBBBBB"}));
		System.out.println(d.count("ACEGIKMOQSUWY",new String[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX","ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX","ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX","ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX","ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX","ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"}));
		System.out.println(d.count("CA",new String[]{"BBBBBBB","BBBBBBB","BBBBBBB"}));
		System.out.println(d.count("DCBA",new String[]{"ACBD"}));
	}
}
