import java.util.Arrays;

public class BirthdayReminders
{
	public String[] remind(String[] friendNames, int[] birthDates, int currentDate, String[] occasions, int[] days, int k) {
		int bLen = birthDates.length, oLen = occasions.length;
		int[][] o = new int[bLen][oLen];
		int[][] cnt = new int[bLen][oLen];

		for (int i=0; i < o.length; i++) {
			for (int j=0; j < o[0].length; j++) {
				int rem = currentDate - birthDates[i];
				int qoutient = (rem%days[j] == 0) ? rem/days[j] : rem/days[j]+1;
				o[i][j] = birthDates[i] + qoutient*days[j];
				cnt[i][j] = qoutient;
			}
		}

		String[] res = new String[k];

		for (int idx=0; idx < k; idx++) {
			int min = o[0][0];
			int mi=0,mj=0;
			for (int i=0; i < o.length; i++) {
				for (int j=0; j < o[0].length; j++) {
					if (o[i][j] < min) {
						min = o[i][j];
						mi = i;
						mj = j;
					}
					else if (o[i][j]==min && (j<mj || (j==mj && i<mi))) {
						mi = i;
						mj = j;
					}
				}
			}
			res[idx] = "" + o[mi][mj] + ". " + friendNames[mi] + " " + occasions[mj] + " (" + cnt[mi][mj] + ")";
			o[mi][mj] = min+days[mj];
			cnt[mi][mj]++;
		}

		return res;
	}

	public static void main(String[] args) {
		BirthdayReminders b = new BirthdayReminders();
		System.out.println(Arrays.toString(b.remind(new String[]{"John", "Jack", "Bill"},new int[]{50, 100, 150},500,new String[]{"birthday", "decimal birthday", "binary birthday"},new int[]{365, 1000, 512},10)));
		System.out.println(Arrays.toString(b.remind(new String[]{"Zero", "Two", "Three"},new int[]{0, 2, 3},24,new String[]{"threeday", "twoday"},new int[]{3,2},10)));
		System.out.println(Arrays.toString(b.remind(new String[]{"Jessica Alba", "Angelina Jolie", "Paris Hilton", "Britney Spears"},new int[]{4135, 1980, 4065, 4353},14091,new String[]{"Venus year", "Earth year", "Mars year", "Jupiter year", "Saturn year"},new int[]{225, 365, 687, 4332, 10760},20)));
	}
}

// References
// http://community.topcoder.com/stat?c=problem_solution&cr=22654835&rd=13503&pm=8481
