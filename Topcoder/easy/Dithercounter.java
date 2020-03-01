public class DitherCounter		// This is equal to 
{
	public int count (String dithered, String[] screen) {
		int num = 0;
		for (int i = 0; i < screen.length; i++)
			for (int j = 0; j < screen[0].length(); j++)
				if (dithered.indexOf(screen[i].charAt(j)) != -1)
					num++;

		return num;
	}

	public static void main(String[] args) {
		DitherCounter d = new DitherCounter();
		System.out.println(d.count("BW", new String[]{"AAAAAAAA","ABWBWBWA","AWBWBWBA","ABWBWBWA","AWBWBWBA","AAAAAAAA"}));
		System.out.println(d.count("BW", new String[]{"BBBBBBBB","BBWBWBWB","BWBWBWBB","BBWBWBWB","BWBWBWBB","BBBBBBBB"}));
		System.out.println(d.count("ACEGIKMOQSUWY", new String[]{
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			"ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"}));
		System.out.println(d.count("CA", new String[]{"BBBBBBB","BBBBBBB","BBBBBBB"}));
		System.out.println(d.count("DCBA", new String[]{"ACBD"}));
	}
}
