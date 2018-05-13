public class ProgressBar
{
	public String showProgress(int[] taskTimes, int tasksCompleted) {
		double sum=0,csum=0;
		for (int i=0; i < taskTimes.length; i++)
			sum += taskTimes[i];
		for (int i=0; i < tasksCompleted; i++)
			csum += taskTimes[i];

		int percent = (int)(csum/sum*20);
		char[] res = new char[20];
		for (int i=0; i < percent; i++)
			res[i] = '#';
		for (int i=percent; i < 20; i++)
			res[i] = '.';

		return new String(res);
	}

	public static void main(String[] args) {
		ProgressBar p = new ProgressBar();
		System.out.println(p.showProgress(new int[]{19,6,23,17},3));
		System.out.println(p.showProgress(new int[]{2,3,7,1,4,3},4));
		System.out.println(p.showProgress(new int[]{553,846,816,203,101,120,161,818,315,772},4));
		System.out.println(p.showProgress(new int[]{7,60,468,489,707,499,350,998,1000,716,457,104,597,583,396,862},2));
		System.out.println(p.showProgress(new int[]{419,337,853,513,632,861,336,594,94,367,336,297,966,627,399,433,846,859,80,2},19));
	}
}
