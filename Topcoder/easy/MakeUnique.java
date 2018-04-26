public class MakeUnique
{
	public String eliminated(String original) {
		if(original.length() == 1) return original;

		char[] o = original.toCharArray();
		
		boolean[] letter = new boolean[100];
		
		int lSize=0;
		for (int i=0; i < o.length; i++) {
			if(!letter[o[i]]) {
				letter[o[i]] = true;
				lSize++;
			}
		}
		
		char[] l = new char[lSize];
		
		int idx=0;
		for (char c='A'; c <= 'Z'; c++)
			if(letter[c]) l[idx++] = c;
		
		int shortest = 51;
		int[] lIdx = new int[lSize];
		int[] sIdx = new int[lSize];
		
		for (int i=0,j=0; i < o.length; i++) {
			if (o[i] == l[j]) {
				lIdx[j++] = i;
				if (j == lSize) {
					j--;
					int len = lIdx[j]-lIdx[0]+1;
					if (len < shortest) {
						shortest = len;
						for (int a=0; a < lSize; a++)
							sIdx[a] = lIdx[a];
					}
					else if (len == shortest) {
						for (int k=0; k < lSize; k++) {
							if(sIdx[k] > lIdx[k]) break;
							else if(sIdx[k] < lIdx[k]) {
								for (int a=0; a < lSize; a++)
									sIdx[a] = lIdx[a];
								break;
							}
						}
					}
				}
				else if(i == o.length-1) j--;
			}

			if (i==o.length-1 && j>0) {
				j--;
				i = lIdx[j];
			}
		}
		
		if(shortest == 51) return "";
		
		for (int i=0; i < o.length; i++)
			o[i] = '.';
		for (int i=0; i < lSize; i++)
			o[sIdx[i]] = l[i];
		
		return new String(o);
	}

	public static void main(String[] args) {
		MakeUnique m = new MakeUnique();
		System.out.println(m.eliminated("ABBBXCXABCX"));	// ".......ABCX"
		System.out.println(m.eliminated("ABBBXCXABCB"));	// "A..B.CX...."
		System.out.println(m.eliminated("ABBBXCABCB"));		// ""
		System.out.println(m.eliminated("AABACBXABX"));		// ".AB.C.X..."
		System.out.println(m.eliminated("CABDEAFDEGSDABCDEADFGSEFBGS"));	// "............ABCDE..FGS....."
		System.out.println(m.eliminated("AAAAAA"));			// ".....A"
	}
}
