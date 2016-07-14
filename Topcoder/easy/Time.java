public class Time
{
	public String whatTime(int sec) {
		return sec/3600 + ":" + sec%3600/60 + ":" + sec%60;
	}

	public static void main(String[] args) {
		Time t = new Time();
		System.out.println(t.whatTime(0));
		System.out.println(t.whatTime(3661));
		System.out.println(t.whatTime(5436));
		System.out.println(t.whatTime(86399));
	}
}
