public class LevelUp
{
	public int toNextLevel(int[] expNeeded, int received) {
		for (int i=0; i < expNeeded.length; i++)
			if(expNeeded[i] > received) return expNeeded[i]-received;

		return 0;
	}

	public static void main(String[] args) {
		LevelUp l = new LevelUp();
		System.out.println(l.toNextLevel(new int[]{150,450,900,1800},133));
		System.out.println(l.toNextLevel(new int[]{150,450,900,1800},312));
		System.out.println(l.toNextLevel(new int[]{150,450,900,1800},612));
		System.out.println(l.toNextLevel(new int[]{150,450,900,1800},450));
		System.out.println(l.toNextLevel(new int[]{2,150,450,900,1800},2));
	}
}
