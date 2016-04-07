public class TireRotation
{
	public static int getCycle(String initial, String current) {
		char[] c = initial.toCharArray();
		String[] phase = new String[4];

		// Another way is to create a function that returns 1->3, 2->4, 3->2, 4->1.
		phase[0] = initial;
		phase[1] = "" + c[3] + c[2] + c[0] + c[1];
		phase[2] = "" + c[1] + c[0] + c[3] + c[2];
		phase[3] = "" + c[2] + c[3] + c[1] + c[0];

		for (int i=0; i < 4; i++)
			if(phase[i].equals(current)) return i+1;

		return -1;
	}

	public static void main(String[] args) {
		System.out.println(getCycle("ABCD","ABCD"));
		System.out.println(getCycle("ABCD","DCAB"));
		System.out.println(getCycle("ABCD","CDBA"));
		System.out.println(getCycle("ABCD","ABDC"));
		System.out.println(getCycle("ZAXN","XNAZ"));
	}
}
