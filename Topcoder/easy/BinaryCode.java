import java.util.Arrays;

public class BinaryCode {
	public String[] decode(String message) {
		if(message.length()==1) {
			if(message=="0") return new String[]{"0","NONE"};
			else if(message=="1") return new String[]{"NONE","1"};
			else return new String[]{"NONE","NONE"};
		}
		
		int len = message.length();
		int[] m = new int[len];
		int[] d = new int[len];
		String[] res = new String[2];

		for(int i=0; i < len; i++)
			m[i] = message.charAt(i) - '0';

		res[0]="0";
		if(m[0]==0) res[0]+="0";
		else if(m[0]==1) {d[1]=1; res[0] += "1";}
		else res[0]="NONE";

		for(int i=1; i < len; i++) {
			int prev = d[i-1]+d[i];

			if(m[i]==prev) {if(i!=len-1) res[0] += "0";}
			else if(m[i]==prev+1 && i<len-1) {d[i+1]=1; res[0]+="1";}
			else {res[0]="NONE"; break;}
		}

		d = new int[len];

		d[0]=1; res[1]="1";
		if(m[0]==1) res[1]+="0";
		else if(m[0]==2) {d[1]=1; res[1]+="1";}
		else res[1]="NONE";

		for(int i=1; i < len; i++) {
			int prev = d[i-1]+d[i];

			if(m[i]==prev) {if(i!=len-1) res[1] += "0";}
			else if(m[i]==prev+1 && i<len-1) {d[i+1]=1; res[1]+="1";}
			else {res[1]="NONE"; break;}
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryCode b = new BinaryCode();
		System.out.println(Arrays.toString(b.decode("123210122")));
		System.out.println(Arrays.toString(b.decode("11")));
		System.out.println(Arrays.toString(b.decode("22111")));
		System.out.println(Arrays.toString(b.decode("123210120")));
		System.out.println(Arrays.toString(b.decode("3")));
		System.out.println(Arrays.toString(b.decode("12221112222221112221111111112221111")));
	}
}
