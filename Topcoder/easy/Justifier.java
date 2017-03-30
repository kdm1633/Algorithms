import java.util.Arrays;

public class Justifier
{
	public String[] justify(String[] textIn) {
		int longest=0;
		for (int i=0; i < textIn.length; i++)
			if (textIn[i].length() > longest) longest = textIn[i].length();

		for (int i=0; i < textIn.length; i++)
			for (int j=textIn[i].length(); j < longest; j++)
				textIn[i] = " " + textIn[i];

		return textIn;
	}

	public static void main(String[] args) {
		Justifier j = new Justifier();
		System.out.println(Arrays.toString(j.justify(new String[]{"BOB","TOMMY","JIM"})));
		System.out.println(Arrays.toString(j.justify(new String[]{"JOHN","JAKE","ALAN","BLUE"})));
		System.out.println(Arrays.toString(j.justify(new String[]{"LONGEST","A","LONGER","SHORT"})));
	}
}
