import java.util.LinkedList;
import java.util.Queue;

public class PowerOutage
{
	public int estimateTimeOut(int[] fromJunction, int[] toJunction, int[] ductLength) {
		int n = fromJunction.length;
		int sum = 0;
		int len = 0;
		int[] dlSum = new int[50];

		for (int i = 0; i < n; i++)
			sum += ductLength[i];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);

		while (q.size() != 0) {
			int jn = q.poll();
			for (int i = 0; i < n; i++) {
				if (fromJunction[i] == jn) {
					q.add(toJunction[i]);
					dlSum[toJunction[i]] += dlSum[jn] + ductLength[i];
					if (dlSum[toJunction[i]] > len) len = dlSum[toJunction[i]];
				}
			}
		}

		return 2*sum - len;
	}

	public static void main(String[] args) {
		PowerOutage p = new PowerOutage();
		System.out.println(p.estimateTimeout(new int[]{0}, new int[]{1}, new int[]{10}));
		System.out.println(p.estimateTimeout(new int[]{0,1,0}, new int[]{1,2,3}, new int[]{10,10,10}));
		System.out.println(p.estimateTimeout(new int[]{0,0,0,1,4}, new int[]{1,3,4,2,5}, new int[]{10,10,100,10,5}));
		System.out.println(p.estimateTimeout(new int[]{0,0,0,1,4,4,6,7,7,7,20}, new int[]{1,3,4,2,5,6,7,20,9,10,31}, new int[]{10,10,100,10,5,1,1,100,1,1,5}));
		System.out.println(p.estimateTimeout(new int[]{0,0,0,0,0}, new int[]{1,2,3,4,5}, new int[]{100,200,300,400,500}));
	}
}

// References
// http://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm144
