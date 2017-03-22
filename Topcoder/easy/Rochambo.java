public class Rochambo {
	public int wins(String opponent) {
		int w=0;
		
		if(opponent.charAt(0) == 'S') w++;
		if(opponent.charAt(1) == 'S') w++;
		
		for (int i=2; i < opponent.length(); i++) {
			char c;
			if(opponent.charAt(i-1) != opponent.charAt(i-2)) c = (char)('R' + 'P' + 'S' - opponent.charAt(i-1) - opponent.charAt(i-2));
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

//public class Rochambo {
//    public int wins(String opponent) {
//        int w=0;
//        if(opponent.charAt(0) == 'S') w++;
//        if(opponent.charAt(1) == 'S') w++;
//        
//        String str;
//        for (int i=2; i < opponent.length(); i++) {
//            char prev1 = opponent.charAt(i-1), prev2 = opponent.charAt(i-2), p2 = opponent.charAt(i);
//            
//            char prediction;
//            if(prev1 == prev2) prediction = prev1;
//            else {
//                if(prev1 == 'R') prediction = (prev2 == 'P') ? 'S' : 'P';
//                else if(prev1 == 'P') prediction = (prev2 == 'R') ? 'S' : 'R';
//                else prediction = (prev2 == 'R') ? 'P' : 'R';
//            }
//            
//            char p1 = (prediction == 'R') ? 'P' : (prediction == 'P') ? 'S' : 'R';
//            if(p2 != p1) {
//                if(p2 == 'R' && p1 == 'P') w++;
//                if(p2 == 'P' && p1 == 'S') w++;
//                if(p2 == 'S' && p1 == 'R') w++;
//            }
//        }
//        
//        return w;
//    }
//}
