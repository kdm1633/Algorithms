public class StairClimb
{
	public int stridesTaken(int[] flights, int stairsPerStride) {
		int n = flights.length;
		int sum = 0;
		
		for (int i=0; i < n; i++)
			sum += flights[i]/stairsPerStride + (flights[i]%stairsPerStride+(stairsPerStride-1))/stairsPerStride;
		
		return sum+(n-1)*2;
	}
	public static void main(String[] args) {
		StairClimb s = new StairClimb();
		System.out.println(s.stridesTaken(new int[]{15},2));
		System.out.println(s.stridesTaken(new int[]{15,15},2));
		System.out.println(s.stridesTaken(new int[]{5,11,9,13,8,30,14},3));
	}
}
