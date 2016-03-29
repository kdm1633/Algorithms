import java.util.Map;
import java.util.HashMap;

public class StringDup
{
	public static char getMax(String param0) {
                // Map elements are inserted as a linked list.
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		int max=0;
		char ch=0;

		for(int i=param0.length()-1; i >= 0; i--) {
			if(!hmap.containsKey(param0.charAt(i)))
				hmap.put(param0.charAt(i),1);
			else
				hmap.replace(param0.charAt(i), hmap.get(param0.charAt(i))+1);
		}

		for(Map.Entry<Character,Integer> entry : hmap.entrySet()) {
			if(entry.getValue() >= max) {
				max = entry.getValue();
				ch = entry.getKey();
			}
		}

		return ch;
	}

	public static void main(String[] args) {
		System.out.println(getMax("aaiicccnn"));
		System.out.println(getMax("aabbccdd"));
		System.out.println(getMax("ab2sbf2dj2skl"));
	}
}
