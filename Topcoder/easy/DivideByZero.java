import java.util.Arrays;
import java.util.HashSet;

public class DivideByZero
{
	public int CountNumbers(int[] numbers) {
		HashSet<Integer> paper = new HashSet<Integer>();
		for (int i : numbers) paper.add(i);

		int old = 0;
		while (paper.size() > old) {
			old = paper.size();
			HashSet<Integer> clone = (HashSet)paper.clone();
			for (int a : clone)
				for (int b : clone)
					if (a>b) paper.add(a/b);
		}

		return paper.size();
	}

	public static void main(String[] args) {
		DivideByZero d = new DivideByZero();
		System.out.println(d.CountNumbers(new int[]{9,2}));
		System.out.println(d.CountNumbers(new int[]{8,2}));
		System.out.println(d.CountNumbers(new int[]{50}));
		System.out.println(d.CountNumbers(new int[]{1,5,8,30,15,4}));
		System.out.println(d.CountNumbers(new int[]{1,2,4,8,16,32,64}));
		System.out.println(d.CountNumbers(new int[]{6,2,18}));
	}
}

// https://apps.topcoder.com/wiki/display/tc/SRM+610
