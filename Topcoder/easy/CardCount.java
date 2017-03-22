import java.util.Arrays;

public class CardCount
{
	public String[] dealHands(int numPlayers, String deck) {
		String[] res = new String[numPlayers];
		for(int i=0; i < res.length; i++)
			res[i] = "";
		
		int rem = (deck.length()%numPlayers == 0) ? 0 : deck.length()%numPlayers;
		int len = deck.length()-rem;
		for(int i=0, j=0; i < len; i++,j=(j+1)%numPlayers)
			res[j] += deck.charAt(i);
		
		return res;
	}

	public static void main(String[] args) {
		CardCount c = new CardCount();
		System.out.println(Arrays.toString(c.dealHands(6,"012345012345012345")));
		System.out.println(Arrays.toString(c.dealHands(4,"111122223333")));
		System.out.println(Arrays.toString(c.dealHands(1,"012345012345012345")));
		System.out.println(Arrays.toString(c.dealHands(6,"01234")));
		System.out.println(Arrays.toString(c.dealHands(2,"")));
	}
}
