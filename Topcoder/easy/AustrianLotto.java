import java.util.Arrays;

public class AustrianLotto
{
	public int[] evaluate(String drawing, String[] picks) {
		String[] sp = drawing.split(" ");
		int[] d = new int[6];
		for (int i=0; i < 6; i++)
			d[i] = Integer.parseInt(sp[i]);

		int[] res = new int[7];

		for (int i=0; i < picks.length; i++) {
			sp = picks[i].split(" ");
			int cnt=0;
			for (int j=0; j < 6; j++)
				for (int k=0; k < 6; k++)
					if(d[j] == Integer.parseInt(sp[k])) cnt++;

			res[cnt]++;
		}

		return res;
	}

	public static void main(String[] args) {
		AustrianLotto a = new AustrianLotto();
		System.out.println(Arrays.toString(a.evaluate("3 11 18 23 37 45",new String[]{"4 7 14 30 33 35", "1 11 12 25 37 38", "11 18 19 20 21 22"})));
		System.out.println(Arrays.toString(a.evaluate("3 18 23 11 37 45",new String[]{"3 11 18 23 37 45"})));
		System.out.println(Arrays.toString(a.evaluate("42 26 33 2 13 14",new String[]{"13 4 36 42 26 12"})));
	}
}
