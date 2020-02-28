public class VendingMachine
{
	int rows, cols;
	int ts;				// a total of seconds
	int ci, cj;			// current i, current j;
	int[][] p;

	void addSecs(int nj) {
		int a = Math.abs(nj - cj);
		int b = cols - Math.abs(nj - cj);
		ts += (a < b) ? a : b;
	}

	void setMaxCol() {
		int max = -1, mj = cj;

		for (int j = 0; j < cols; j++) {
			int sum = 0;

			for (int i = 0; i < rows; i++)
				if (p[i][j] > 0) sum += p[i][j];

			if (sum > max) {max = sum; mj = j;}
		}

		if (mj!=cj) {addSecs(mj); cj = mj;}
	}

	public int motorUse(String[] prices, String[] purchases) {
		rows = prices.length;
		cols = prices[0].split(" ").length;
		int pcLen = purchases.length;
		ts = 0;
		p = new int[rows][];

		int[][] pc = new int[pcLen][3];
		int[] t = new int[pcLen];

		for (int i = 0; i < rows; i++) {
			String[] sp = prices[i].split(" ");
			p[i] = new int[cols];
			for (int j = 0; j < cols; j++)
				p[i][j] = Integer.parseInt(sp[j]);
		}

		for (int i = 0; i < pcLen; i++) {
			String[] sp = purchases[i].split("[:,]");
			for (int j = 0; j < 3; j++)
				pc[i][j] = Integer.parseInt(sp[j]);
		}

		t[0] = 5;
		for (int i = 1; i < pcLen; i++)
			t[i] = pc[i][2] - pc[i-1][2];

		ci = 0; cj = 0;

		for (int i = 0; i < pcLen; i++) {
			if (t[i]>=5) setMaxCol();
			addSecs(pc[i][1]);
			ci = pc[i][0] ; cj = pc[i][1];
			if (p[ci][cj] == 0) return -1;
			p[ci][cj] = 0;
		}

		setMaxCol();

		return ts;
	}

	public static void main(String[] args) {
		VendingMachine v = new VendingMachine();
		System.out.println(v.motorUse(new String[]{"100 100 100"}, new String[]{"0,0:0", "0,2:5", "0,1:10"}));
		System.out.println(v.motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:5", "0,1:10", "0,4:15"}));
		System.out.println(v.motorUse(new String[]{"100 200 300 400 500 600"}, new String[]{"0,2:0", "0,3:4", "0,1:8", "0,4:12"}));
		System.out.println(v.motorUse(new String[]{"100 100 100"}, new String[]{"0,0:10", "0,0:11"}));
		System.out.println(v.motorUse(new String[]{"100 200 300", "600 500 400"}, new String[]{"0,0:0", "1,1:10", "1,2:20", "0,1:21", "1,0:22", "0,2:35"}));
	}
}
