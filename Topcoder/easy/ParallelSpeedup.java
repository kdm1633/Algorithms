public class ParallelSpeedup
{
	public int numProcessors(int k, int overhead) {
		int min = k;
		for (int num = 2, j = 0, d = 1; ; num++, j += d++) {
			int cycleTime = (k%num == 0) ? k/num : k/num+1;
			int total = cycleTime + (j+d)*overhead;
			if(min <= total) return num-1;
			min = total;
		}
	}

	public static void main(String[] args) {
		ParallelSpeedup p = new ParallelSpeedup();
		System.out.println(p.numProcessors(12,1));
		System.out.println(p.numProcessors(50,3));
		System.out.println(p.numProcessors(9,10));
		System.out.println(p.numProcessors(3333,2));
		System.out.println(p.numProcessors(1000000,4));
	}
}
