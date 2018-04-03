import java.util.Arrays;

public class RPG
{
	public int[] dieRolls(String[] dice) {
		int[] res = new int[3];
		for (int i=0; i < dice.length; i++) {
			String[] sp = dice[i].split("d");
			res[0] += Integer.parseInt(sp[0]);;
			res[1] += Integer.parseInt(sp[0])*Integer.parseInt(sp[1]);
		}
		res[2] = (res[0]+res[1])/2;
		return res;
	}

	public static void main(String[] args) {
		RPG r = new RPG();
		System.out.println(Arrays.toString(r.dieRolls(new String[]{"3d6"})));
		System.out.println(Arrays.toString(r.dieRolls(new String[]{"3d4","1d6"})));
		System.out.println(Arrays.toString(r.dieRolls(new String[]{"6d5","10d10","10d20"})));
		System.out.println(Arrays.toString(r.dieRolls(new String[]{"1d2","2d2","4d2","6d2","8d2"})));
	}
}
