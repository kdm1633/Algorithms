public class Whisper
{
	public static String toWhom(String[] usernames, String typed) {
		typed = typed.toLowerCase();

		if(!typed.startsWith("/msg ")) 
			return "not a whisper";
		else {
			typed = typed.substring(5);

			int max = -1, length=0;

			for (int i=0; i < usernames.length; i++) {
				if(typed.startsWith(usernames[i].toLowerCase() + " ") && usernames[i].length() > length) {
					max = i;
					length = usernames[i].length();
				}
			}

			if(max == -1)
				return "user is not logged in";
			else
				return usernames[max];
		}
	}

	public static void main(String[] args) {
		System.out.println(toWhom(new String[]{"John Doe hi there", "John","John Doe","John Doe h"}, 
			"/msg John Doe hi there"));
		System.out.println(toWhom(new String[]{"John","John Doe","John Doe h"}, 
			"/MSG jOHN dOE HI THERE"));
		System.out.println(toWhom(new String[]{"writer"}, 
			"writer hi"));
		System.out.println(toWhom(new String[]{"tester"}, 
			"/msg testerTwo you there"));
		System.out.println(toWhom(new String[]{"lbackstrom"}, 
			"/msg lbackstrom"));
		System.out.println(toWhom(new String[]{"me"}, 
			"/msg  me hi"));
		System.out.println(toWhom(new String[]{"abc"}, 
			" /msg abc note the leading space"));
		System.out.println(toWhom(new String[]{"Wow"}, 
			"/msg Wow "));
		System.out.println(toWhom(new String[]{"msg"}, 
			"/msg"));
		System.out.println(toWhom(new String[]{" ", "  "}, 
			"/msg  "));
	}
}
