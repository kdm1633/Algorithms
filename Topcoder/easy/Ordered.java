public class Ordered {
	public String getType(int[] values) {
		boolean nonasc=false,nondes=false,repeat=false;
		String res = "";
		
		if(values[0] < values[1]) res = "ASCENDING ";
		else if(values[0] > values[1]) res = "DESCENDING ";
		
		for (int i=1; i < values.length; i++) {
			if(values[i-1] < values[i]) nondes = true;
			else if(values[i-1] > values[i]) nonasc = true;
			else repeat = true;
		}
		
		if(nonasc && nondes) return "NOTHING";
		
		if (repeat) {
			if(nonasc) res = "NONASCENDING ";
			else if(nondes) res = "NONDESCENDING ";
			
			int cnt = 1;
			int max = 1;
			for (int i=1; i < values.length; i++) {
				if(values[i-1] == values[i]) cnt++;
				else {
					if(max < cnt) max = cnt;
					cnt=1;
				}
			}
			if(max < cnt) max = cnt;
			res += max;
		}
		else {
			int sum=0;
			for (int i=0; i < values.length; i++) {
				sum += values[i];
			}
			int g = gcd(sum,values.length);
			if(g!=0) res += sum/g + "/" + values.length/g;
		}
		
		return res;
	}
	
	int gcd(int a, int b)  {
		return (a==0) ? b : gcd(b%a,a);
	}

	public static void main(String[] args) {
		Ordered o = new Ordered();
		System.out.println(o.getType(new int[]{1,2,4,11}));
		System.out.println(o.getType(new int[]{1,2,2,2,3,4}));
		System.out.println(o.getType(new int[]{6,5,1}));
		System.out.println(o.getType(new int[]{5,5,4,4,1}));
		System.out.println(o.getType(new int[]{1,2,3,4,1}));
		System.out.println(o.getType(new int[]{1000,999,998}));
		System.out.println(o.getType(new int[]{999,1000,1000,1000,1000,1000}));
		System.out.println(o.getType(new int[]{1,1000,1,1000,1,1000}));
		System.out.println(o.getType(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,51}));
		System.out.println(o.getType(new int[]{2,2,1}));
		System.out.println(o.getType(new int[]{1,2,2}));
	}
}
