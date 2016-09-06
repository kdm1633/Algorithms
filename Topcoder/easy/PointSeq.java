// This code don't work correctly for input4.

import java.util.Arrays;

public class PointSeq
{
	public String[] makeSeq(int[] xs, int[]ys) {
		int len = xs.length;

		for (int i=1; i < len; i++) {
			int idx=i;
			for (int j=i-1; j >= 0; j--) {
				if (xs[idx] < xs[j]) {
					int temp = xs[idx];
					xs[idx] = xs[j];
					xs[j] = temp;

					temp = ys[idx];
					ys[idx] = ys[j];
					ys[j] = temp;

					idx = j;
				}
				else break;
			}
		}

		int[] dx = new int[len];
		int[] dy = new int[len];

		for (int i=0; i < len; i++)
			dx[i] = 100001;

		dx[0] = xs[0]; dx[1] = xs[1];
		dy[0] = ys[0]; dy[1] = ys[1];

		for (int i=2, j=2; i < len; i++) {
			dx[j] = xs[i]; dy[j] = ys[i];

			double x1 = dx[j-1]-dx[j-2], y1 = dy[j-1]-dy[j-2];
			double x2 = dx[j]-dx[j-2], y2 = dy[j]-dy[j-2];
			double a = y1 / x1;
			double b = y2 / x2;

			if(a>b) {
				j++;
				continue;
			}
			
			dx[j-1] = dx[j]; dy[j-1] = dy[j];
			dx[j] = 100001; dy[j] = 100001;
		}

		int k=2;
		for (; k < len; k++) {
			if(dx[k]==100001) break;
		}

		String[] res = new String[k];

		for (int i=0; i < res.length; i++)
			res[i] = dx[i] + "," + dy[i];

		return res;
	}

	public static void main(String[] args) {
		PointSeq p = new PointSeq();
		System.out.println(Arrays.toString(p.makeSeq(new int[]{5,10,15,20}, new int[]{5,5,5,4})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{0,5,10}, new int[]{0,5,0})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{10,9,8,7,6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10}, new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{-3058,-6953,-2111,6350,-9345,-115,-8288,5120,-7013,-4452,-8991,439, -187,-6636,6493,-7694,-1258,206,-7785,4823,-7788,5081,-986,-2641,9029, -302,-4969,-5534,7866,-9222,9318,6776,1239,8878,-444,187,-6530,3485, 9896,-4433,-8842,-840,9937,6264,9671,-7525,-9138,5682,4175,-5459}, new int[]{-4131,-9232,-1401,1942,-4900,2067,5353,7408,-22,9789,358,-7986,7409, -6401,-733,-4263,1243,1538,7568,-2141,3793,-1614,1125,4171,9563,-2577, 5378,7136,-9683,-9024,-5180,6913,5638,137,-587,6127,-1898,9055,9568, -3729,-2772,-5821,-3659,-1359,1330,3851,8480,7688,-8584,8641})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{-100000,99999,100000}, new int[]{0,20000,19999})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{15,5,0}, new int[]{0,0,5})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{-7168, 13471, 30562}, new int[]{-9537, 89464, 37788})));
		System.out.println(Arrays.toString(p.makeSeq(new int[]{0,5,10}, new int[]{0,5,10})));
	}
}
