public class RectangularGrid
{
	public long countRectangles(int width, int height) {
		long res = 0;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(i == j) continue;

				res += (height-i) * (width-j);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		RectangularGrid r = new RectangularGrid();
		System.out.println(r.countRectangles(3,3));
		System.out.println(r.countRectangles(5,2));
		System.out.println(r.countRectangles(10,10));
		System.out.println(r.countRectangles(1,1));
		System.out.println(r.countRectangles(592,964));
	}
}
