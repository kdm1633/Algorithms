public class Champagne
{
	public String howMuch(int height, int glass, int units) {
		int B = 1 << height;
		int i=0,j=0,n,d;
		int[][] amount = new int[21][21];

		amount[0][0] = units*B;

		loop:
		for (i=0; i <= height; i++) {
			for (j=0; j <= i; j++) {
				int f = amount[i][j]-2*B;
				if(f > 0) {
					amount[i+1][j] += f/2;
					amount[i+1][j+1] += f/2;
					amount[i][j] = 2*B;
				}
				glass--;
				if(glass == 0) break loop;
			}
		}

		n = amount[i][j];
		d = 2*B;
		if(n==0) return "0/1";
		if(n==d) return "1/1";

		while(n%2==0 && d%2==0) {n/=2; d/=2;}
		
		return n + "/" + d;
	}

	public static void main(String[] args) {
		Champagne c = new Champagne();
		System.out.println(c.howMuch(1,1,1));
		System.out.println(c.howMuch(2,2,2));
		System.out.println(c.howMuch(2,3,3));
		System.out.println(c.howMuch(3,4,7));
		System.out.println(c.howMuch(3,5,7));
		System.out.println(c.howMuch(20,204,300));
		System.out.println(c.howMuch(20,204,299));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=270505&rd=4472&pm=1525
