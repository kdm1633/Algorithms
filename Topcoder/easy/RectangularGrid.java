public class RectangularGrid
{
	public long countRectangles(int width, int height) {
		long res = 0;

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(i == j) continue;

				res += (height-i)*(width-j);
			}
		}

		return res;
	}
}
