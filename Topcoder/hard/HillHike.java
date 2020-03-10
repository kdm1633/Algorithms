public class HillHike
{
	public long numPaths(int distance, int maxHeight, int[] _landmarks) {
		long[][][] cache1 = new long[2][52][51];
		long[][][] cache2 = new long[2][52][51];
		cache1[0][0][0] = 1;

		int[] landmarks = new int[_landmarks.length+1];
		System.arraycopy(_landmarks,0,landmarks,0,_landmarks.length);
		landmarks[_landmarks.length] = -1;

		for (int i = 1; i < distance; i++) {
			cache2 = new long[2][52][51];
			for (int j = 1; j <= maxHeight; j++) {
				int ni = (j == maxHeight) ? 1 : 0;
				for (int k = 0; k < landmarks.length; k++) {
					int lm = (j == landmarks[k]) ? k + 1 : k;
					for (int d = -1; d <= 1; d++) {
						cache2[ni][j][lm] += cache1[0][j+d][k];
						cache2[1][j][lm] += cache1[1][j+d][k];
					}
				}
			}
			cache1 = cache2;
		}

		return cache1[1][1][landmarks.length-1];
	}

	public static void main(String[] args) {
		HillHike h = new HillHike();
		System.out.println(h.numPaths(5,2,new int[]{}));
		System.out.println(h.numPaths(2,45,new int[]{}));
		System.out.println(h.numPaths(5,2,new int[]{2,2}));
		System.out.println(h.numPaths(8,3,new int[]{2,2,3,1}));
		System.out.println(h.numPaths(38,11,new int[]{4,5,8,5,6}));
	}
}

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm145
