public class PrefixCode
{
	public String isOne(String[] words) {
		for(int i=0; i < words.length; i++) {
			for(int j=0; j < words.length; j++) {
				if(i==j) continue;
				if(words[j].startsWith(words[i])) return "No, " + i;
			}
		}
		
		return "Yes";
	}

	public static void main(String[] args) {
		PrefixCode p = new PrefixCode();
		System.out.println(p.isOne(new String[]{"trivial"}));
		System.out.println(p.isOne(new String[]{"10001", "011", "100", "001", "10"}));
		System.out.println(p.isOne(new String[]{"no", "nosy", "neighbors", "needed"}));
		System.out.println(p.isOne(new String[]{"1010", "11", "100", "0", "1011"}));
		System.out.println(p.isOne(new String[]{"No", "not"}));
		System.out.println(p.isOne(new String[]{"1Jd", "1FApgJG", "doKBPas8sr", "eF94b", "ap", "tQluf", "iMEynp"}));
		System.out.println(p.isOne(new String[]{"6G9Lnpzw", "kA", "SyW9fFaF", "k", "SyW9fFa", "6G", "6", "SyW9f"}));
	}
}
