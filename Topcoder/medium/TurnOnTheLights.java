public class TurnOnTheLights
{
	int[] dr = {1,-1,0,0};
	int[] dc = {0,0,-1,1};

	public int countLights(String[] floor, int K, int row, int col) {
		int rlen = floor.length, clen = floor[0].length();
		int max = 0;

		for (int i = 0; i < 4; i++) {
			int nRow = row + dr[i], nCol = col + dc[i];
			int count = 0;
			for (int j = 0; j < K; j++) {
				if (nRow<0 || nRow>=rlen || nCol<0 || nCol>=clen) break;
				if (floor[nRow].charAt(nCol) == 'Y') {
					if (floor[nRow-dr[i]].charAt(nCol-dc[i]) != 'Y') count++;
					for (int k = 0; k < 4; k++) {
						int nbRow = nRow + dr[k], nbCol = nCol + dc[k];
						if (nbRow<0 || nbRow>=rlen || nbCol<0 || nbCol>=clen) continue;
						if (nRow-dr[i]==nbRow && nCol-dc[i]==nbCol) continue;
						if (floor[nbRow].charAt(nbCol) == 'Y') count++;
					}
				}
				nRow += dr[i];
				nCol += dc[i];
			}
			if (count > max) max = count;
		}

		return max;
	}

	public static void main(String[] args) {
		TurnOnTheLights t = new TurnOnTheLights();
		System.out.println(t.countLights(new String[]{"n"},50,0,0));
		System.out.println(t.countLights(new String[]{
			"YNNYYYY",
			"YNYNYYY",
			"NYYYYYN",
			"YYNYYYY"},4,1,1));
		System.out.println(t.countLights(new String[]{
			"NNNNY",
			"NNNNN",
			"NNNNN"},2,1,2));
		System.out.println(t.countLights(new String[]{
			"YNYNY",
			"NYNYY",
			"NNNNN"},1,2,4));
		System.out.println(t.countLights(new String[]{
			"NNNYNN",
			"NNNNNN",
			"YNYNNN",
			"YYYYYY",
			"YYNYNY",
			"NNYYYN",
			"YYYYYY"},5,2,3));
		System.out.println(t.countLights(new String[]{
			"YYYYY",
			"YYYYY",
			"YYYYN",
			"YYYYY",
			"YYYYY"},4,2,4));
	}
}
