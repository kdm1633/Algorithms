public class ParallelSpeedup
{
	public int numProcessors(int k, int overhead) {
		int num=1, min=k;
		for (int i=2, j=0, d=1; ; i++, j += d++) {
			int cycle = (k%i==0) ? k/i : k/i+1;
			int time = cycle + (j+d)*overhead;
			if(time >= min) return num;
			num = i; min = time;
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
