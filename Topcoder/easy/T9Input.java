import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class T9Input {
	public String[] getKeypresses(String[] messages) {
		HashMap<String,TreeSet<String>> map = new HashMap<String,TreeSet<String>>();
		HashMap dict = new HashMap();
		for (int i = 0; i < messages.length; i++) {
			String[] sp = messages[i].split(" ");
			for (int j = 0; j < sp.length; j++) {
				String str = "";
				for (int k = 0; k < sp[j].length(); k++) {
					int num = 0;
					char c = sp[j].charAt(k);
					if (c <= 'c') num = 2;
					else if (c <= 'f') num = 3;
					else if (c <= 'i') num = 4;
					else if (c <= 'l') num = 5;
					else if (c <= 'o') num = 6;
					else if (c <= 's') num = 7;
					else if (c <= 'v') num = 8;
					else num = 9;
					str += num;
				}
				TreeSet<String> ts = (!map.containsKey(str)) ? new TreeSet<String>() : map.get(str);
				ts.add(sp[j]);
				map.put(str,ts);
				dict.put(sp[j],str);
			}
		}

		String[] res = new String[messages.length];
		for (int i = 0; i < messages.length; i++) {
			String str = "";
			for (int j = 0; j < messages[i].length(); j++) {
				if (messages[i].charAt(j) == ' ') {
					str += "#";
					continue;
				}

				int j0 = j;
				while (j+1 < messages[i].length() && messages[i].charAt(j+1) != ' ') j++;
				String word = messages[i].substring(j0,j+1);
				str += dict.get(word);
				int hash = map.get(dict.get(word)).headSet(word).size();
				while (hash-- > 0) str += "0";
			}
			res[i] = str;
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
