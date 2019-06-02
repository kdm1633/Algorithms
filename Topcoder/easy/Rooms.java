import java.util.Arrays;

public class Rooms
{
	public int[] finalRooms(String[] rooms, String doors, int start) {
		int n = rooms.length;
		boolean[] pos = new boolean[n];
		int[][][] nrooms = new int[n][91][];

		for (int i = 0; i < n; i++) {
			String[] sp = rooms[i].split(" ");
			for (int j = 0; j < sp.length; j++) {
				String[] d = sp[j].substring(2).split(",");
				nrooms[i][sp[j].charAt(0)] = new int[d.length];
				for (int k = 0; k < d.length; k++)
					nrooms[i][sp[j].charAt(0)][k] = Integer.parseInt(d[k]);
			}
		}

		pos[start] = true;
LOOP:	for (char d : doors.toCharArray()) {
			boolean[] next = new boolean[n];
			for (int i = 0; i < n; i++) {
				if (pos[i]) {
					if (nrooms[i][d] == null) {pos = next; break LOOP;}
					for (int k = 0; k < nrooms[i][d].length; k++)
						next[nrooms[i][d][k]] = true;
				}
			}
			pos = next;
		}
		
		int cnt = 0;
		for (int i = 0; i < n; i++)
			if (pos[i]) cnt++;
		
		int[] res = new int[cnt];

		cnt = 0;
		for (int i = 0; i < n; i++)
			if (pos[i]) res[cnt++] = i;

		return res;
	}

	public static void main(String[] args) {
		Rooms r = new Rooms();
		System.out.println(Arrays.toString(r.finalRooms(new String[]{"A:0 B:1","A:1 B:0"},"AB",0)));
		System.out.println(Arrays.toString(r.finalRooms(new String[]{"A:1 B:0","A:0 B:1"},"AABAAB",1)));
		System.out.println(Arrays.toString(r.finalRooms(new String[]{"B:1 Z:0","B:0 Z:2","B:2 Z:1"},"BBZZB",0)));
		System.out.println(Arrays.toString(r.finalRooms(new String[]{"A:0,1,2,3","A:0,1,2,3","A:0,1,2,3","A:0,1,2,3"},"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",2)));
		System.out.println(Arrays.toString(r.finalRooms(new String[]{"D:0","D:0","D:0","D:0"},"GDDDDD",3)));
	}
}

// https://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=tco03_qual_rd_1
