import java.util.LinkedList;

public class Escape
{
	int[] dx = {1,0,-1,0};
	int[] dy = {0,1,0,-1};
	int[][] map, dist;
	boolean[][] used;

	class node {
		int x,y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public int lowest(String[] harmful, String[] deadly) {
		if(harmful.length == 0 && deadly.length == 0) return 0;

		map = new int[501][501];
		dist = new int[501][501];
		used = new boolean[501][501];

		setMap(harmful, 1);
		setMap(deadly, 2);
		
		return bfs();
	}

	void setMap(String[] str, int v) {
		for(int i=0; i < str.length; i++) {
			String[] s = str[i].split(" ");
			
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);
			
			if(x1 > x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}

			if(y1 > y2) {
				int temp = y1;
				y1 = y2;
				y2 = temp;
			}
			
			for(int a=x1; a <= x2; a++)
				for(int b=y1; b <= y2; b++)
					map[a][b] = v;

		}
	}
	
	int bfs() {
		LinkedList<node> q = new LinkedList<node>();

		q.add(new node(0,0));

		map[0][0]=2;

		int min=-1;

		while(!q.isEmpty()) {
			node n = q.poll();

			if(n.x==500 && n.y==500) min = dist[500][500];

			for(int i=0; i < 4; i++) {
				int x = n.x + dx[i];
				int y = n.y + dy[i];

				if(x<0 || y<0 || x>500 || y>500 || map[x][y]==2) continue;

				if(used[x][y] == true) {
					if(dist[n.x][n.y] + map[x][y] < dist[x][y]) {
						dist[x][y] = dist[n.x][n.y] + map[x][y];

						q.add(new node(x,y));
					}
				}
				else {
					used[x][y] = true;
					dist[x][y] = dist[n.x][n.y] + map[x][y];

					q.add(new node(x,y));
				}
			}
		}

		return min;
	}
	
	public static void main(String[] args) {
		Escape e = new Escape();
		System.out.println(e.lowest(new String[]{}, new String[]{}));
		System.out.println(e.lowest(new String[]{"500 0 0 500"}, new String[]{"0 0 0 0"}));
		System.out.println(e.lowest(new String[]{"0 0 250 250","250 250 500 500"}, new String[]{"0 251 249 500","251 0 500 249"}));
		System.out.println(e.lowest(new String[]{"0 0 250 250","250 250 500 500"}, new String[]{"0 250 250 500","250 0 500 250"}));
		System.out.println(e.lowest(new String[]{"468 209 456 32","71 260 306 427","420 90 424 492","374 253 54 253","319 334 152 431","38 93 204 84","246 0 434 263","12 18 118 461","215 462 44 317","447 214 28 475","3 89 38 125","157 108 138 264","363 17 333 387","457 362 396 324","95 27 374 175","381 196 265 302","105 255 253 134","0 308 453 55","169 28 313 498","103 247 165 376","264 287 363 407","185 255 110 415","475 126 293 112","285 200 66 484","60 178 461 301","347 352 470 479","433 130 383 370","405 378 117 377","403 324 369 133","12 63 174 309","181 0 356 56","473 380 315 378"},new String[]{"250 384 355 234","28 155 470 4","333 405 12 456","329 221 239 215","334 20 429 338","85 42 188 388","219 187 12 111","467 453 358 133","472 172 257 288","412 246 431 86","335 22 448 47","150 14 149 11","224 136 466 328","369 209 184 262","274 488 425 195","55 82 279 253","153 201 65 228","208 230 132 223","369 305 397 267","200 145 98 198","422 67 252 479","231 252 401 190","312 20 0 350","406 72 207 294","488 329 338 326","117 264 497 447","491 341 139 438","40 413 329 290","148 245 53 386","147 70 186 131","300 407 71 183","300 186 251 198","178 67 487 77","98 158 55 433","167 231 253 90","268 406 81 271","312 161 387 153","33 442 25 412","56 69 177 428","5 92 61 247"}));
	}
}

// References
// https://github.com/jskonhovd/TopCoder/blob/master/Java/Escape.java
