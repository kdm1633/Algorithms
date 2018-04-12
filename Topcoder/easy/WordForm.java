public class WordForm { // The problem name is Stemmer.
	public String getSequence(String word) {
		word = word.toUpperCase();
		char c = word.charAt(0);
		String res = (c=='A' || c=='E' || c=='I' || c=='O' || c=='U') ? "V" : "C";
		boolean consonant = (res.equals("C")) ? true : false;

		for (int i=1; i < word.length(); i++) {
			c = word.charAt(i);
			if (c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
				if(consonant) {res += "V"; consonant = false;}
			}
			else if (c=='Y' && consonant) {
				res += "V";
				consonant = false;
			}
			else if (!consonant) {
				res += "C";
				consonant = true;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		WordForm w = new WordForm();
		System.out.println(w.getSequence("WHEREABOUTS"));
		System.out.println(w.getSequence("yoghurt"));
		System.out.println(w.getSequence("YipPy"));
		System.out.println(w.getSequence("AyYyEYye"));
		System.out.println(w.getSequence("yC"));
	}
}
