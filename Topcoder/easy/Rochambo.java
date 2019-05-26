public class Rochambo {
	public int wins(String opponent) {
		int w=0;
		
		if(opponent.charAt(0) == 'S') w++;
		if(opponent.charAt(1) == 'S') w++;
		
		for (int i=2; i < opponent.length(); i++) {
			char c;
			if(opponent.charAt(i-2) != opponent.charAt(i-1)) c = (char)('R' + 'P' + 'S' - opponent.charAt(i-1) - opponent.charAt(i-2));
			else c = opponent.charAt(i-1);
			
			if(c == opponent.charAt(i)) w++;
		}
		
		return w;
	}

	public static void main(String[] args) {
		Rochambo r = new Rochambo();
		System.out.println(r.wins("PS"));
		System.out.println(r.wins("PSRRPS"));
		System.out.println(r.wins("PSRPSRPRSR"));
		System.out.println(r.wins("SRPSRPSPRSPRPSRPSRP"));
		System.out.println(r.wins("RPPPRRPSSSRRRSRSPPSSPRRPSRRRRSPPPPSSPSSSSSRSSSRPRR"));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=144400&rd=4620&pm=1810
