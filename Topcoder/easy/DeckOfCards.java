public class DeckOfCards {
	public String IsValid(int n, int[] value, String suit) {
		if(n == 1) return "Perfect";
		
		for (int i=0; i < n-1; i++)
			for (int j=i+1; j < n; j++)
				if(value[i]==value[j] && suit.charAt(i)==suit.charAt(j)) return "Not perfect";
		
		for (int i=0; i < n-1; i++) {
			for (int j=i+1; j < n; j++) {
				int v1 = value[i], v2 = value[j];
				char s1 = suit.charAt(i), s2 = suit.charAt(j);
				boolean b1 = false, b2 = false;
				for (int k=0; k < n; k++) {
					if(!b1 && v1==value[k] && s2==suit.charAt(k)) b1 = true;
					else if(!b2 && v2==value[k] && s1==suit.charAt(k)) b2 = true;
				}
				if(!b1 && !b2) return "Not perfect";
			}
		}
    
		return "Perfect";
	}

	public static void main(String[] args) {
		DeckOfCards d = new DeckOfCards();
		System.out.println(d.IsValid(1,new int[]{10},"z"));
		System.out.println(d.IsValid(3,new int[]{1,2,3},"hhh"));
		System.out.println(d.IsValid(4,new int[]{2,3,2,3},"hcch"));
		System.out.println(d.IsValid(3,new int[]{1,1,1},"hch"));
		System.out.println(d.IsValid(4,new int[]{1,2,3,4},"hhcc"));
	}
}

// I recommend using Set.
