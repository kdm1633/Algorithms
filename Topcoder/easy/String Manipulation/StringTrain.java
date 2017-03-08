public class StringTrain
{
	public String buildTrain(String[] cars) {
		String train = cars[0];
		for (int i=1; i < cars.length; i++) {
			for (int j = cars[i].length()-1; j > 0; j--) {
				String s1 = cars[i].substring(0,j);
				if (!train.equals(s1) && train.endsWith(s1)) {
					train += cars[i].substring(j);
					break;
				}
			}
		}

		String t="";
		for (int i=0; i < train.length(); i++) {
			char ch = train.charAt(i);
			String s = train.substring(i+1);
			if(s.indexOf(ch) == -1) t += ch;
		}

		return "" + train.length() + " " + t;
	}

	public static void main(String[] args) {
		StringTrain s = new StringTrain();
		System.out.println(s.buildTrain(new String[]{"ABCDE","CDFFF","CDE","CDEGG","GABC"}));
		System.out.println(s.buildTrain(new String[]{"AAAAA","AAAAA","AAAAA"}));
		System.out.println(s.buildTrain(new String[]{"CABABDABAB","CABAB","ABABDABAB","DABAB"}));
		System.out.println(s.buildTrain(new String[]{"ABABAB","ABABAB","ABABABAB","BZZZZZ"}));
		System.out.println(s.buildTrain(new String[]{"A","A","A","AA"}));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=299180&rd=4610&pm=1801
