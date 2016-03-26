public class Bullets {
	public static int match(String[] guns, String bullet) {
		int len = bullet.length();
        
	        for(int i=0; i < guns.length; i++) {
	            for(int j=0; j < len; j++) {
	                if(guns[i].equals(bullet))
	                    return i;
	                else
	                    guns[i] = guns[i].substring(1) + guns[i].substring(0,1);
	            }
	        }
	        
	        return -1;
	}
	
	public static void main(String[] args) {
	    	System.out.println(match(new String[]{"| | | |","|| || |"," |||| "}, "|| || |"));
		System.out.println(match(new String[]{"||| |","| | || "}, "|||| "));
		System.out.println(match(new String[]{"|| || ||","| | | | ","||||||||"}, "||| ||| "));
		System.out.println(match(new String[]{}, "| | | |"));
		System.out.println(match(new String[]{"|| || ||","| | | | ","||| ||| ","||||||||"}, "|| ||| |"));
	}
}
