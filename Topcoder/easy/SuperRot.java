public class SuperRot {
	public String decoder(String message) {
		String res = "";
		for (int i=0; i < message.length(); i++) {
			char ch = message.charAt(i);

			if(ch < '0') res += " ";
			else if(ch <= '4') res += (char)(ch+5);
			else if(ch <= '9') res += (char)(ch-5);
			else if(ch <= 'M') res += (char)(ch+13); 
			else if(ch <= 'Z') res += (char)(ch-13);
			else if(ch <= 'm') res += (char)(ch+13);
			else res += (char)(ch-13);
		}
		
		return res;
	}

	public static void main(String[] args) {
		SuperRot s = new SuperRot();
		System.out.println(s.decoder("Uryyb 28"));
		System.out.println(s.decoder("GbcPbqre"));
		System.out.println(s.decoder(""));
		System.out.println(s.decoder("5678901234"));
		System.out.println(s.decoder("NnOoPpQqRr AaBbCcDdEe"));
		System.out.println(s.decoder("Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ"));
		System.out.println(s.decoder("Gur dhvpx oebja sbk whzcf bire n ynml qbt"));
	}
}
