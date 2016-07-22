public class Quipu
{
	public int readKnots(String knots) {
		String res="";
		int cnt=0;

		for (int i=0; i < knots.length(); i++) {
			if ('X' == knots.charAt(i))
				cnt++;
			else {
				res += (char)('0'+cnt);
				cnt=0;
			}
		}

		return Integer.parseInt(res);
	}

	public static void main(String[] args) {
		Quipu q = new Quipu();
		System.out.println(q.readKnots("-XX-XXXX-XXX-"));
		System.out.println(q.readKnots("-XX--XXXX---XXX-"));
		System.out.println(q.readKnots("-X-"));
		System.out.println(q.readKnots("-X-------"));
		System.out.println(q.readKnots("-XXXXXXXXX--XXXXXXXXX-XXXXXXXXX-XXXXXXX-XXXXXXXXX-"));
	}
}
// https://community.topcoder.com/stat?c=problem_solution&cr=7364110&rd=4580&pm=1686

//My Answer
//public class Quipu
//{
//	public int readKnots(String knots) {
//		String res="";
//
//		for (int i=1; i < knots.length(); i++) {
//			if ('X' == knots.charAt(i)) {
//				int cnt=1;
//				int j=i+1;
//				for (; knots.charAt(j) == 'X'; j++) cnt++;
//
//				res += cnt;
//				i=j-1;
//			}
//			else if ('-' == knots.charAt(i) && '-' == knots.charAt(i-1))
//				res += "0";
//		}
//
//		return Integer.parseInt(res);
//	}
//}
