import java.util.Arrays;
import java.util.TreeSet;

public class T9Input {
	String[] dic;
	
	String getNum(String s) {
		String pn = "";
		for (int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c >= 'a' && c <= 'c') pn += "2";
			else if(c >= 'd' && c <= 'f') pn += "3";
			else if(c >= 'g' && c <= 'i') pn += "4";
			else if(c >= 'j' && c <= 'l') pn += "5";
			else if(c >= 'm' && c <= 'o') pn += "6";
			else if(c >= 'p' && c <= 's') pn += "7";
			else if(c >= 't' && c <= 'v') pn += "8";
			else if(c >= 'w' && c <= 'z') pn += "9";
		}
    
		String zero = "";
		for (int i=0; i < dic.length; i++) {
			if(dic[i].startsWith(pn+" ")) {
				String sn = dic[i].substring(pn.length());
				for (int j=0; j < sn.lastIndexOf(" " + s)/(pn.length()+1); j++)
					zero += "0";
				
				break;
			}
		}

		return pn+zero;
	}

	public String[] getKeypresses(String[] messages) {
		TreeSet<String> ts = new TreeSet<String>();
		for (int i=0; i < messages.length; i++) {
			String[] sp = messages[i].split(" ");
			for (int j=0; j < sp.length; j++)
				if(sp[j].length() > 0) ts.add(sp[j]);
		}
		
		int idx=0;
		dic = new String[ts.size()];
		for (int i=0; i < dic.length; i++)
			dic[i] = "";
		
		for (String s : ts) {
			String pn = "";
			for (int i=0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(c >= 'a' && c <= 'c') pn += "2";
				else if(c >= 'd' && c <= 'f') pn += "3";
				else if(c >= 'g' && c <= 'i') pn += "4";
				else if(c >= 'j' && c <= 'l') pn += "5";
				else if(c >= 'm' && c <= 'o') pn += "6";
				else if(c >= 'p' && c <= 's') pn += "7";
				else if(c >= 't' && c <= 'v') pn += "8";
				else if(c >= 'w' && c <= 'z') pn += "9";
			}
			for (int i=0; i < dic.length; i++) {
				if(dic[i].startsWith(pn+ " ")) {dic[i] += " " +s; break;}
				else if(dic[i].length() == 0) {dic[idx++] = pn + " " + s; break;}
			}
		}

		String[] res = new String[messages.length];
		for (int i=0; i < res.length; i++)
			res[i] = "";
		
		for (int i=0; i < messages.length; i++) {
			String s = messages[i];
			for (int j=0; j < s.length(); j++) {
				char c = s.charAt(j);
				
				if(c == ' ') res[i] += '#';
				else {
					int k = s.indexOf(' ',j);
					String word = (k != -1) ? s.substring(j,k) : s.substring(j);
					res[i] += getNum(word);
					
					if(k == -1) break;
					j = k-1;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		T9Input t = new T9Input();
		System.out.println(Arrays.toString(t.getKeypresses(new String[]{"the tie", "the tie"})));
		System.out.println(Arrays.toString(t.getKeypresses(new String[]{" hey joe   ", "   "})));
		System.out.println(Arrays.toString(t.getKeypresses(new String[]{"cba cba cba cba cba cba cba cba", "abc acb bac bca cab cba"})));
		System.out.println(Arrays.toString(t.getKeypresses(new String[]{"the longest case for t nine is probably when", "you enter seven two letter sequences from the", "same key and then repeat the alphabetically", "last case over and over again for the entire", "list of messages", "", "these paragraphs demonstrate how efficient t", "nine is since there is only one time where you", "must use the zero key"})));
		System.out.println(Arrays.toString(t.getKeypresses(new String[]{"cca ccc c cccb ccca cccc"})));
	}
}
