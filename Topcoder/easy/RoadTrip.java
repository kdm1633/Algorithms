public class RoadTrip
{
	public int howMany(String[] map) {
		int max=0;
		char[] d = {'l','r','u','d'};

		for(int idx=0; idx < 4; idx++) {
			for(int a=0; a < map.length; a++) {
				for(int b=0; b < map[0].length(); b++) {
					char D=d[idx];
					boolean chk = (D=='l' || D=='r') ? true : false;
					int i=a, j=b, cnt=0, sw = (D=='r' || D=='d') ? 1 : -1;
					int[][] cmap = new int[map.length][map[0].length()];

					while(i>=0 && i<map.length && j>=0 && j<map[0].length()) {
						if(cmap[i][j] > 4) break;
						
						cmap[i][j]++;

						if(map[i].charAt(j) == 'L') {
							if(D == 'l') {sw=1; D='d';}
							else if(D == 'r') {sw=-1; D='u';}
							else if(D == 'u') {sw=-1; D='l';}
							else if(D == 'd') {sw=1; D='r';}
							chk=!chk;
						}
						else if(map[i].charAt(j) == 'R') {
							if(D == 'l') {sw=-1; D='u';}
							else if(D == 'r') {sw=1; D='d';}
							else if(D == 'u') {sw=1; D='r';}
							else if(D == 'd') {sw=-1; D='l';}
							chk=!chk;
						}
						else if(map[i].charAt(j) == 'B'){
							if(D == 'l') {sw=1; D='r';}
							else if(D == 'r') {sw=-1; D='l';}
							else if(D == 'u') {sw=1; D='d';}
							else if(D == 'd') {sw=-1; D='u';}
						}
						if(chk) j+=sw;
						else i+=sw;
					}

					for(int k=0; k < cmap.length; k++)
						for(int l=0; l < cmap[0].length; l++)
							if(cmap[k][l] != 0) cnt++;

					if(cnt > max) max = cnt;
				}
			}
		}

		return max;
	}
}
