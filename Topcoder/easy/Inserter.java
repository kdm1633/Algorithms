public class Inserter
{
	public String insert(String[] commands, String original) {
		String res="";

		LOOP:
		for (int i=0; i < commands.length; i++) {
			String[] s = commands[i].split("#");

			int idx = Integer.parseInt(s[s.length-1].substring(1));
			int pos = 0;
			for (int j=0; j < idx; j++) {
				if (original.indexOf(s[3],pos) == -1) continue LOOP;
				pos = original.indexOf(s[3],pos)+1;
			}
			pos--;
			original = original.substring(0,pos) + s[1] + original.substring(pos);
		}

		return original;
	}

	public static void main(String[] args) {
		Inserter i = new Inserter();
		System.out.println(i.insert(new String[]{"#<B># #$# 2","#comes # #before this# 1"},"$100 before this $300"));
		System.out.println(i.insert(new String[]{"#,# # and# 1","#,# # and# 2","#,# # and# 3"},"lions and tigers and bears"));
		System.out.println(i.insert(new String[]{"#import java.util.*; # #public class # 1"},"public class Inserter"));
		System.out.println(i.insert(new String[]{"# # # # 1","# # # # 2","# # # # 3","# # # # 4","# # # # 5","# # # # 6"},"add lots of spaces"));
		System.out.println(i.insert(new String[]{"# # # # 6","# # # # 5","# # # # 4","# # # # 3","# # # # 2","# # # # 1"},"order matters quite a bit"));
		System.out.println(i.insert(new String[]{"#A# #..# 2","#A# #..# 5","#A# #..# 123456789"},"...."));
	}
}
