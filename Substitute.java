public class Substitute
{	
    public static int getValue(String key, String code) {
        String dval = "";
        int result	;
        
        key = key.substring(9) + key.substring(0,9);

		// Eliminate cases that don't exist in variable key.
        for(int i=0; i < code.length(); i++) {
            if(key.indexOf(code.charAt(i)) != -1)
                dval += code.charAt(i);
        }
        
		result = key.indexOf(dval.charAt(0));
        
        for(int i=1; i < dval.length(); i++)
			result = (result * 10) + key.indexOf(dval.charAt(i));
        
        return result;
    }

	public static void main(String[] args) {
		System.out.println(getValue("TRADINGFEW", "LGXWEV"));
		System.out.println(getValue("ABCDEFGHIJ", "XJ"));
		System.out.println(getValue("CRYSTALBUM", "MMA"));
	}
}

// REFERENCES
// https://github.com/karahiyo/topcoder/blob/master/SRM160/EASY/Substitute.java
