public class ExerciseMachine {
	public int getPercentages(String time) {
		int total = Integer.parseInt(time.substring(0, 2)) * 60 * 60
			+ Integer.parseInt(time.substring(3, 5)) * 60
			+ Integer.parseInt(time.substring(6, 8));
		int count = 0;
		for (int i = 1; i <= 99; i++) 
			if (total * i % 100 == 0)
				count++;
		
		return count;
	}
	
	public static void main(String[] args) {
		ExerciseMachine e = new ExerciseMachine();
		System.out.println(e.getPercentages("00:30:00"));
		System.out.println(e.getPercentages("00:28:00"));
		System.out.println(e.getPercentages("23:59:59"));
		System.out.println(e.getPercentages("00:14:10"));
		System.out.println(e.getPercentages("00:19:16"));
	}
}
