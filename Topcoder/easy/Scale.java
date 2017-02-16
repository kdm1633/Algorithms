import java.util.Arrays;

public class Scale
{
	public String[] scale(int x, int y, String[] image) {
		int m = image.length;
		int n = image[0].length();
		char[][] big = new char[y*m][x*n];
		String[] sol = new String[y];

		for(int i=0; i < y; i++)
			sol[i] = "";

		for(int i=0; i < m; i++)
		for(int j=0; j < n; j++)
		for(int k=y*i; k < y*(i+1); k++)
		for(int l=x*j; l < x*(j+1); l++)
			big[k][l] = image[i].charAt(j);

		for (int i=0; i < y; i++) {
			for (int j=0; j < x; j++) {
				double sum=0;
				for(int k=m*i; k < m*(i+1); k++)
					for(int l=n*j; l < n*(j+1); l++)
						sum += big[k][l];
				
				sol[i] += (char)(sum/(m*n) + 0.5);
			}
		}

		return sol;
	}

	public static void main(String[] args) {
		Scale s = new Scale();
		System.out.println(Arrays.toString(s.scale(3,3,new String[]{"AB","BC"})));
		System.out.println(Arrays.toString(s.scale(2,4,new String[]{"AB","BC"})));
		System.out.println(Arrays.toString(s.scale(51,43,new String[]{"......",".X....",".X....",".X....",".X....",".XXXX.","......"})));
		System.out.println(Arrays.toString(s.scale(4,4,new String[]{"...AAA...","...AAA..."})));
		System.out.println(Arrays.toString(s.scale(4,4,new String[]{"......",".X....",".X....",".X....",".X....",".XXXX.","......"})));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=307638&rd=5002&pm=2294
