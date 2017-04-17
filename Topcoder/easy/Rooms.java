import java.util.Arrays;
import java.util.HashSet;

public class Rooms
{
	public int[] finalRooms(String[] rooms, String doors, int start) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(start);
		for (char d : doors.toCharArray()) {
			HashSet<Integer> s2 = new HashSet<Integer>();
			for (int r : set) {
				for (String adj : rooms[r].split(" ")) {
					if (adj.charAt(0) == d) {
						for (String str : adj.substring(2).split(","))
							s2.add(Integer.parseInt(str));
					}
				}
			}
			set = s2;
		}

		int[] res = new int[set.size()];
		int idx=0;
		for (int s : set)
			res[idx++] = s;

		Arrays.sort(res);

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

// https://community.topcoder.com/stat?c=problem_solution&cr=7445961&rd=4700&pm=1095
