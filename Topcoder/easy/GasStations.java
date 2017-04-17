public class GasStations
{
	public double tripCost(int[] dist, int[] price, int _mpg, int tankSize, int tripLength) {
		if(_mpg*tankSize >= tripLength) return 0;
		
		int N = dist.length, lowerPrice=20001, idx=0;
		double lowestCost=0, tank=tankSize, mpg = _mpg;

		for (int i=0; i < N; i++) {
			for (int j=i+1; j < N; j++) {
				if (dist[j] < dist[i]) {
					int temp = dist[i];
					dist[i] = dist[j];
					dist[j] = temp;

					temp = price[i];
					price[i] = price[j];
					price[j] = temp;
				}
			}
		}

		// 1. Searching the lowest-price station at the starting point
		for (int i=0; i < N; i++) {
			if(dist[i] > tank*mpg) break;
			if(price[i] < lowerPrice) {lowerPrice = price[i]; idx=i;}
		}

		tank -= dist[idx]/mpg;

		LOOP:
		for (int i=idx; i < N; i = idx) {
			// 2. Searching the first lowest-price station
			for (int j=i+1; j<N && dist[j]<=dist[i]+tankSize*mpg; j++) {
				if(price[j] < price[i]) {
					if(dist[i]+tank*mpg >= dist[j]) tank -= (dist[j]-dist[i])/mpg;
					else {lowestCost += ((dist[j]-dist[i])/mpg - tank) * price[i]; tank=0;}

					idx = j;
					continue LOOP;
				}
			}

			// 3. Going an ending point if possible
			if (dist[i]+tankSize*mpg >= tripLength || i==N-1) {
				if(dist[i]+tank*mpg < tripLength) lowestCost += ((tripLength-dist[i])/mpg - tank) * price[i];
				
				break;
			}

			// 4. Searching the second lowest-price station
			lowerPrice = price[i+1]; idx = i+1;
			for (int j=i+2; j<N && dist[j]<=dist[i]+tankSize*mpg; j++)
				if(price[j] < lowerPrice) {lowerPrice = price[j]; idx = j;}

			lowestCost += (tankSize-tank) * price[i];
			tank = tankSize - (dist[idx]-dist[i])/mpg;
		}

		return lowestCost;
	}

	public static void main(String[] args) {
		GasStations g = new GasStations();
		System.out.println(g.tripCost(new int[]{100,100},new int[]{1000,1500},20,10,300));
		System.out.println(g.tripCost(new int[]{300,450,525},new int[]{1659,1529,1439},20,20,600));
		System.out.println(g.tripCost(new int[]{300,450,525},new int[]{1659,1439,1529},20,20,600));
		System.out.println(g.tripCost(new int[]{300,125,450,525},new int[]{1659,1729,1439,1529},20,20,600));
		System.out.println(g.tripCost(new int[]{200},new int[]{1000},20,20,400));
		System.out.println(g.tripCost(new int[]{100,400},new int[]{1549,1649},25,16,600));
	}
}
