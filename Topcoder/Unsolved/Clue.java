import java.util.Arrays;

public class Clue
{
	public String[] whodunit(String[] cards, String[] guesses) {//guesses's order: SLW
//		String[] res = {"L1","L2","L3","L4","L5","L6","L7","L8","L9","S1","S2","S3","S4","S5","S6","W1","W2","W3","W4","W5","W6"};
//		StringBuilder remCards = new StringBuilder("L1L2L3L4L5L6L7L8L9S1S2S3S4S5S6W1W2W3W4W5W6");

		StringBuilder loc = new StringBuilder("L1L2L3L4L5L6L7L8L9");
		StringBuilder sus = new StringBuilder("S1S2S3S4S5S6");
		StringBuilder wp = new StringBuilder("W1W2W3W4W5W6");
		
		StringBuilder p2 = new StringBuilder("");
		StringBuilder p3 = new StringBuilder("");
		
		for (int k=0; k < cards.length; k++) {
			char c = cards[k].charAt(0);

			if(c=='L') loc.delete(loc.indexOf(cards[k]),loc.indexOf(cards[k])+2);
			else if(c=='S') sus.delete(sus.indexOf(cards[k]),sus.indexOf(cards[k])+2);
			else  wp.delete(wp.indexOf(cards[k]),wp.indexOf(cards[k])+2);
		}
		
		for (int i=0; i < guesses.length; i++) {
			String[] sp = guesses[i].split(" ");
			
			int[] g = new int[5];
			for (int j=0; j < 5; j++)
				g[j] = Integer.parseInt(sp[j]);
			
			String s1 = "L"+g[2], s2 = "S"+g[1], s3 = "W"+g[3];
			
			if (g[0] == 1) {
				if (g[4] == 0) {
					if(loc.indexOf(s1) == -1) s1 = ".";
					if(sus.indexOf(s2) == -1) s2 = ".";
					if(wp.indexOf(s3) == -1) s3 = ".";
					
					if(!s1.equals("."))  {
						for (int j=0; j < loc.length(); j+=2) {
							String s = loc.substring(j,j+2);
							if(s.equals(s1)) continue;
							if(p2.indexOf(s) != -1) p2.delete(p2.indexOf(s),p2.indexOf(s)+2);
							if(p3.indexOf(s) != -1) p3.delete(p3.indexOf(s),p3.indexOf(s)+2);
						}
						loc = new StringBuilder(s1);
					}
					if(!s2.equals("."))  {
						for (int j=0; j < sus.length(); j+=2) {
							String s = sus.substring(j,j+2);
							if(s.equals(s1)) continue;
							if(p2.indexOf(s) != -1) p2.delete(p2.indexOf(s),p2.indexOf(s)+2);
							if(p3.indexOf(s) != -1) p3.delete(p3.indexOf(s),p3.indexOf(s)+2);
						}
						sus = new StringBuilder(s2);
					}
					if(!s3.equals("."))  {
						for (int j=0; j < wp.length(); j+=2) {
							String s = wp.substring(j,j+2);
							if(s.equals(s1)) continue;
							if(p2.indexOf(s) != -1) p2.delete(p2.indexOf(s),p2.indexOf(s)+2);
							if(p3.indexOf(s) != -1) p3.delete(p3.indexOf(s),p3.indexOf(s)+2);
						}
						wp = new StringBuilder(s3);
					}
				}
				else if (g[4] == 2) {
					char c = sp[5].charAt(0);
					if(c=='L' && loc.indexOf(sp[5])!=-1) loc.delete(loc.indexOf(sp[5]),loc.indexOf(sp[5])+2);
					else if(c=='S' && sus.indexOf(sp[5])!=-1) sus.delete(sus.indexOf(sp[5]),sus.indexOf(sp[5])+2);
					else if(wp.indexOf(sp[5])!=-1) wp.delete(wp.indexOf(sp[5]),wp.indexOf(sp[5])+2);
					
					if (p2.indexOf(sp[5]) != -1) p2.delete(p2.indexOf(sp[5]),p2.indexOf(sp[5])+2);
					if (p3.indexOf(sp[5]) != -1) p3.delete(p3.indexOf(sp[5]),p3.indexOf(sp[5])+2);
					
					if (loc.indexOf(s1)!=-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)==-1 && p2.indexOf(s1) == -1) p2.append(s1);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)!=-1 && wp.indexOf(s3)==-1 && p2.indexOf(s2) == -1) p2.append(s2);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)!=-1 && p2.indexOf(s3) == -1) p2.append(s3);
				}
				else if (g[4] == 3) {
					char c = sp[5].charAt(0);
					if(c=='L' && loc.indexOf(sp[5])!=-1) loc.delete(loc.indexOf(sp[5]),loc.indexOf(sp[5])+2);
					else if(c=='S' && sus.indexOf(sp[5])!=-1) sus.delete(sus.indexOf(sp[5]),sus.indexOf(sp[5])+2);
					else if(wp.indexOf(sp[5])!=-1) wp.delete(wp.indexOf(sp[5]),wp.indexOf(sp[5])+2);
					
					if (p2.indexOf(sp[5]) != -1) p2.delete(p2.indexOf(sp[5]),p2.indexOf(sp[5])+2);
					if (p3.indexOf(sp[5]) != -1) p3.delete(p3.indexOf(sp[5]),p3.indexOf(sp[5])+2);
					
					if (loc.indexOf(s1)!=-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)==-1 && p2.indexOf(s1) == -1) p2.append(s1);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)!=-1 && wp.indexOf(s3)==-1 && p2.indexOf(s2) == -1) p2.append(s2);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)!=-1 && p2.indexOf(s3) == -1) p2.append(s3);
				}
			}
			else if (g[0] == 2) {
				if (g[4] == 0) {
					if(loc.indexOf(s1)!=-1 && p3.indexOf(s1) == -1) p3.append(s1);
					if(sus.indexOf(s2)!=-1 && p3.indexOf(s2) == -1) p3.append(s2);
					if(wp.indexOf(s3)!=-1 && p3.indexOf(s3) == -1) p3.append(s3);
				}
				else if (g[4] == 1) {
					if (loc.indexOf(s1)!=-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)==-1 && p3.indexOf(s1) == -1) p3.append(s1);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)!=-1 && wp.indexOf(s3)==-1 && p3.indexOf(s2) == -1) p3.append(s2);
					if (loc.indexOf(s1)==-1 && sus.indexOf(s2)==-1 && wp.indexOf(s3)!=-1 && p3.indexOf(s3) == -1) p3.append(s3);
				}
				else if (g[4] == 3) {
					if(loc.indexOf(s1)!=-1 && p3.indexOf(s1)==-1) p3.append(s1);
					if(sus.indexOf(s2)!=-1 && p3.indexOf(s2)==-1) p3.append(s2);
					if(wp.indexOf(s3)!=-1 && p3.indexOf(s3)==-1) p3.append(s3);
				}
			}
			else if (g[0] == 3) {
				if (g[4] == 0) {
					if(loc.indexOf(s1)!=-1 && p2.indexOf(s1)==-1) p2.append(s1);
					if(sus.indexOf(s2)!=-1 && p2.indexOf(s2)==-1) p2.append(s2);
					if(wp.indexOf(s3)!=-1 && p2.indexOf(s3)==-1) p2.append(s3);
				}
				else if (g[4] == 1) {}
				else if (g[4] == 2) {
					if(loc.indexOf(s1)!=-1 && p2.indexOf(s1)==-1) p2.append(s1);
					if(sus.indexOf(s2)!=-1 && p2.indexOf(s2)==-1) p2.append(s2);
					if(wp.indexOf(s3)!=-1 && p2.indexOf(s3)==-1) p2.append(s3);
				}
			}
		}
		
		String t1 = "", t2 = "", t3 = "";
		for (int i=0; i < p2.length(); i+=2) {
			String s = p2.substring(i,i+2);
			if(p3.indexOf(s) != -1) {
				if(s.charAt(0) == 'L') t1 += s.substring(1);
				else if(s.charAt(0) == 'S') t2 += s.substring(1);
				else t3 += s.substring(1);
			}
		}
		
		if(t1.length() != 0) {
			char[] ch = t1.toCharArray();
			Arrays.sort(ch);
			t1 = "";
			for (int i=0; i < ch.length; i++) t1 += "L"+ch[i];
			loc = new StringBuilder(t1);
		}
		if(t2.length() != 0) {
			char[] ch = t2.toCharArray();
			Arrays.sort(ch);
			t2 = "";
			for (int i=0; i < ch.length; i++) t2 += "S"+ch[i];
			sus = new StringBuilder(t2);
		}
		if(t3.length() != 0) {
			char[] ch = t3.toCharArray();
			Arrays.sort(ch);
			t3 = "";
			for (int i=0; i < ch.length; i++) t3 += "W"+ch[i];
			wp = new StringBuilder(t3);
		}
		
		String s = loc.append(sus).append(wp).toString();
		
		String[] res = new String[s.length()/2];
		for (int i=0,j=0; i < res.length; i++,j+=2) {
			res[i] = s.substring(j,j+2);
		}

		return res;
	}

	public static void main(String[] args) {//output: LSW
		Clue c = new Clue();
		System.out.println(Arrays.toString(c.whodunit(new String[]{"S1","S2","S4","S3","S5","W5"},new String[]{"1 1 1 1 0 N0"})));
		System.out.println(Arrays.toString(c.whodunit(new String[]{"L3","S2","S4","S3","S5","W5"},new String[]{"2 1 1 1 0 N0"})));
		System.out.println(Arrays.toString(c.whodunit(new String[]{"W4","W1","L5","L9","S3","L2"},new String[]{"2 3 8 4 1 W4","1 3 8 3 3 W3"})));
		System.out.println(Arrays.toString(c.whodunit(new String[]{"W4","W1","L5","L9","S3","L2"},new String[]{"1 3 5 4 0 N0"})));
		System.out.println(Arrays.toString(c.whodunit(new String[]{"W4","W1","L5","L9","S3","L2"},new String[]{})));
		System.out.println(Arrays.toString(c.whodunit(new String[]{"L5","L7","L8","S5","W5","W6"},new String[]{"2 6 1 6 3 N0","3 6 5 4 1 L5",
														  "1 6 1 3 2 W3","2 3 5 1 3 N0","3 5 7 1 1 S5","1 6 1 1 3 L1","2 1 2 5 3 N0","3 4 6 5 1 W5","1 3 3 4 2 W4",
														  "2 6 4 1 3 N0","3 4 3 6 1 W6","1 4 6 1 2 S4","2 2 5 6 3 N0","3 6 7 4 1 L7","1 6 4 1 3 L4","2 6 5 1 1 L5",
														  "3 4 3 1 2 N0","1 6 2 1 3 L2","2 6 3 1 0 N0","3 6 3 1 0 N0"})));
	}
}
