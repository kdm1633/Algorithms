public class CircleGame
{
	public int cardsLeft(String deck) {
		StringBuilder sb = new StringBuilder(deck);

		for(int i=0; i < sb.length(); i++) {
			if('K' == sb.charAt(i)) {
				sb.deleteCharAt(i);
				i = -1;
			}
			else if(val(sb.charAt(i)) + val(sb.charAt((i+1) % sb.length())) == 13) {
					sb.deleteCharAt(i);
					sb.deleteCharAt(i % sb.length());
					i = -1;
			}
		}

		return sb.length();
	}

	public int val(char c) {
		if(c == 'A') return 1;
		if(c == 'T') return 10;
		if(c == 'J') return 11;
		if(c == 'Q') return 12;
		if(c == 'K') return 13;

		return c - '0';
	}

	public static void main(String[] args) {
		CircleGame c = new CircleGame();
		System.out.println(c.cardsLeft("KKKKKKKKKK"));
		System.out.println(c.cardsLeft("KKKKKAQT23"));
		System.out.println(c.cardsLeft("KKKKATQ23J"));
		System.out.println(c.cardsLeft("AT68482AK6875QJ5K9573Q"));
		System.out.println(c.cardsLeft("AQK262362TKKAQ6262437892KTTJA332"));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=309617&rd=4545&pm=1735
