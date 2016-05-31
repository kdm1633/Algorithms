public class CCipher
{
	public String decode(String cipherText, int shift) {
		String res="";

		for(int i=0,ch=0; i < cipherText.length(); i++) {
			ch = (cipherText.charAt(i) - shift < 65) ? 91 + (cipherText.charAt(i) - 65 - shift) : cipherText.charAt(i) - shift;
			res += (char)ch;
		}

		return res;
	}

	public static void main(String[] args) {
		CCipher c = new CCipher();
		System.out.println(c.decode("VQREQFGT", 2));
		System.out.println(c.decode("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10));
		System.out.println(c.decode("TOPCODER", 0));
		System.out.println(c.decode("ZWBGLZ", 25));
		System.out.println(c.decode("DBNPCBQ", 1));
		System.out.println(c.decode("LIPPSASVPH", 4));
	}
}
