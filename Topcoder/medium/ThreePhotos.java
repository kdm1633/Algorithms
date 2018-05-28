import java.util.Arrays;

public class ThreePhotos
{
	public int removeCubes(String[] A, String[] B, String[] C) {
		int n = A.length;
		boolean[][][] c = new boolean[n][n][n];

		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++) {
				if (A[i].charAt(j) == 'N') 
					for (int k=0; k < n; k++)
						c[k][j][i] = true;
				
				if (B[i].charAt(j) == 'N') 
					for (int k=0; k < n; k++)
						c[j][k][i] = true;
				
				if (C[i].charAt(j) == 'N') 
					for (int k=0; k < n; k++)
						c[j][i][k] = true;
				
			}
		}

		for (int i=0; i < n; i++) {
			for (int j=0; j < n; j++) {
				if (A[i].charAt(j) == 'Y') {
					boolean chk = true;
					for (int k=0; k < n; k++) {
						if (!c[k][j][i]) {
							chk = false;
							break;
						}
					}
					if(chk) return -1;
				}
				if (B[i].charAt(j) == 'Y') {
					boolean chk = true;
					for (int k=0; k < n; k++) {
						if (!c[j][k][i]) {
							chk = false;
							break;
						}
					}
					if(chk) return -1;
				}
				if (C[i].charAt(j) == 'Y') {
					boolean chk = true;
					for (int k=0; k < n; k++) {
						if (!c[j][i][k]) {
							chk = false;
							break;
						}
					}
					if(chk) return -1;
				}
			}
		}

		int cnt=0;
		for (int i=0; i < n; i++)
		for (int j=0; j < n; j++)
		for (int k=0; k < n; k++)
			if (c[i][j][k]) cnt++;

		return cnt;
	}

	public static void main(String[] args) {
		ThreePhotos t = new ThreePhotos();
		System.out.println(t.removeCubes(new String[]{"YY","YY"}, new String[]{"YY","YY"}, new String[]{"YY","YY"}));
		System.out.println(t.removeCubes(new String[]{"NNN","NNN","NNN"}, new String[]{"NNN","NNN","NNN"}, new String[]{"NNN","NNN","NNN"}));
		System.out.println(t.removeCubes(new String[]{"NNNNN","NNNNN","NNNNN","YYNNN","NNNNN"}, new String[]{"NNNNN","NNNNN","NNNNN","NNYNY","NNNNN"}, new String[]{"NNYNN","NNNNY","NNNNN","NNNNN","NNNNN"}));
		System.out.println(t.removeCubes(new String[]{"YY","YY"}, new String[]{"YY","YY"}, new String[]{"YN","YN"}));
	}
}
