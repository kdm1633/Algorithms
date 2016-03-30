import java.util.Arrays;

public class Billboard {
    public static String[] enlarge(String message, String[] letters) {
        String[] enlarged = new String[5];
        
        Arrays.fill(enlarged, "");
        
        for(int i=0, idx=2; i < 5; i++, idx+=6) {
            for(int j=0, k; j < message.length(); j++) {
                for(k=0; k < letters.length; k++) {
                    if(message.charAt(j) == letters[k].charAt(0))
                        break;
                }
                enlarged[i] += letters[k].substring(idx,idx+5) + ".";
            }
            enlarged[i] = enlarged[i].substring(0, enlarged[i].length()-1);
        }
        
        return enlarged;
    }

	public static void main(String[] args) {
		String[] strs = enlarge("TOPCODER", new String[]{"T:#####-..#..-..#..-..#..-..#.." ,
			"O:#####-#...#-#...#-#...#-#####" ,"P:####.-#...#-####.-#....-#...." ,"C:.####-#....-#....-#....-.####" ,
			"D:####.-#...#-#...#-#...#-####." ,"E:#####-#....-####.-#....-#####" ,"R:####.-#...#-####.-#.#..-#..##"});

		for(String s : strs)
			System.out.println(s);

		System.out.println();

		strs = enlarge("DOK", new String[]{"D:####.-#...#-#...#-#...#-####." ,
			"O:#####-#...#-#...#-#...#-#####" ,"K:#...#-#..#.-###..-#..#.-#...#"});

		for(String s : strs)
			System.out.println(s);

		System.out.println();

		strs = enlarge("RANDOMNESS", new String[]{"S:##.##-#####-#.#.#-#.#.#-####." ,
			"N:#####-#####-#####-#####-#####" ,"R:#####-#####-##.##-#####-#####" ,"A:.....-.....-.....-.....-....." ,
			"D:#.#.#-.#.#.-#.#.#-.#.#.-#.#.#" ,"O:#####-#...#-#.#.#-#...#-#####" ,"E:#....-.#...-..#..-...#.-....#" ,
			"M:#....-.....-.....-.....-....." ,"X:#...#-.#.#.-..#..-.#.#.-#...#"});

		for(String s : strs)
			System.out.println(s);
	}
}