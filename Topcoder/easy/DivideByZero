/* Code 1 */

import java.util.Arrays;

public class DivideByZero
{
	public int CountNumbers(int[] numbers) {
		Arrays.sort(numbers);
		
		boolean[] bmap = new boolean[101];
		for (int i=0; i < numbers.length; i++)
			bmap[numbers[i]] = true;

		int res = numbers.length;

		for (int i=0; i < numbers.length; i++) {
			if(numbers[i] == 1) continue;

			for (int j=i+1; j < numbers.length; j++) {
				int n = numbers[j]/numbers[i];
				if(!bmap[n]) {
					bmap[n] = true;
					res++;
					int[] temp = new int[numbers.length+1];
					System.arraycopy(numbers, 0, temp, 0, numbers.length);
					temp[temp.length-1] = n;
					Arrays.sort(temp);
					numbers = temp;
					i=-1;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		DivideByZero d = new DivideByZero();
		System.out.println(d.CountNumbers(new int[]{9,2}));
		System.out.println(d.CountNumbers(new int[]{8,2}));
		System.out.println(d.CountNumbers(new int[]{50}));
		System.out.println(d.CountNumbers(new int[]{1,5,8,30,15,4}));
		System.out.println(d.CountNumbers(new int[]{1,2,4,8,16,32,64}));
		System.out.println(d.CountNumbers(new int[]{6,2,18}));
	}
}

/* Code 2 */

//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class DivideByZero
//{
//	public int CountNumbers(int[] numbers) {
//		System.out.println(System.currentTimeMillis());
//		Arrays.sort(numbers);
//
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//
//		for (int i=0; i < numbers.length; i++)
//			nums.add(numbers[i]);
//
//		for (int i=0; i < nums.size(); i++) {
//			if(nums.get(i) == 1) continue;
//			for (int j=i+1; j < nums.size(); j++) {
//				int n = nums.get(j)/nums.get(i);
//				if(nums.indexOf(n) == -1) {
//					nums.add(n);
//					Collections.sort(nums);
//					i=-1;
//					break;
//				}
//			}
//		}
//
//		if(numbers[0] == 1) return nums.size()+1;
//		System.out.println(System.currentTimeMillis());
//
//		return nums.size();
//	}
//
//	public static void main(String[] args) {
//		DivideByZero d = new DivideByZero();
//		System.out.println(d.CountNumbers(new int[]{9,2}));
//		System.out.println(d.CountNumbers(new int[]{8,2}));
//		System.out.println(d.CountNumbers(new int[]{50}));
//		System.out.println(d.CountNumbers(new int[]{1,5,8,30,15,4}));
//		System.out.println(d.CountNumbers(new int[]{1,2,4,8,16,32,64}));
//		System.out.println(d.CountNumbers(new int[]{6,2,18}));
//	}
//}
