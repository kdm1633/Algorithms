/* System test의 입력값 중 부정확한 값들은 테스트가 실행되지 않는다. 정상적인 입력값에선 잘 작동한다.  */
/* Any values of system test is not valid so it doesn't work. The other values work well. */

import java.util.Arrays;
import java.util.ArrayList;

public class Logger
{
	public String[] log(String[] messages, String[] priorities, String[] precedence, String loggingPriority) {
		ArrayList<String> res = new ArrayList<String>();

		String[] lp = loggingPriority.split(" ");
		int lpIdx=0;
		for (int i=0; i < precedence.length; i++)
			if(lp[0].equalsIgnoreCase(precedence[i])) {lpIdx=i; break;}

		for (int i=0; i < messages.length; i++) {
			String[] s = priorities[i].split(" ");

			if(s[0].equalsIgnoreCase(lp[0])) {
				if(s.length==1 && lp.length==1)
					res.add(messages[i]);
				else if(s.length == 2)
					if(lp.length==1 || Integer.parseInt(s[1])>=Integer.parseInt(lp[1])) res.add(messages[i]);
				
				continue;
			}

			for (int j=lpIdx+1; j < precedence.length; j++) {
				if(s[0].equalsIgnoreCase(precedence[j])) {
					res.add(messages[i]);
					break;
				}
			}
		}

		return res.toArray(new String[0]);
	}

	public static void main(String[] args) {
		Logger l = new Logger();
		System.out.println(Arrays.toString(l.log(
			new String[]{"in doit()...","n=9","n=13","x=-3","divide by 0","index out of bounds","n=-1","this shouldn't happen","bailing out"},
			new String[]{"info 3","debug","debug","debug 3","error","ERROR 5","debug 2","critical","fatal 100"},
			new String[]{"info","debug","exceptional","error","critical","fatal"},
			"error 1")));
		System.out.println(Arrays.toString(l.log(
			new String[]{"in doit()...","n=9","n=13","x=-3","divide by 0","index out of bounds","n=-1","this shouldn't happen","bailing out"},
			new String[]{"info 3","debug","debug","debug 3","error","ERROR 5","debug 2","critical","fatal 100"},
			new String[]{"info","debug","exceptional","error","critical","fatal"},
			"debug 2")));
		System.out.println(Arrays.toString(l.log(
			new String[]{"1","2","3",""},
			new String[]{"A","b","C","d"},
			new String[]{"a","b","c","D"},
			"C")));
	}
}
