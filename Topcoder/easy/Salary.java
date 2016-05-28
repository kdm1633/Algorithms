public class Salary
{
	public int howMuch(String[] arrival, String[] departure, int wage) {
		int arr, dep;
		double res=0;
		double[] t = new double[86400];
		
		for(int i=0; i < arrival.length; i++) {
			arr = toSecond(arrival[i]);
			dep = toSecond(departure[i]);

			for(int j=arr; j < dep; j++)
				t[j] = 1;
		}

		for(int i=0; i < 21600; i++)
			if(t[i] != 0) {t[i] *= 1.5; res += t[i];}

		for(int i=21600; i < 64800; i++)
			if(t[i] != 0) res += t[i];

		for(int i=64800; i < 86400; i++)
			if(t[i] != 0) {t[i] *= 1.5; res += t[i];}
		
		return (int)(res * wage / 3600);
	}
	
	public int toSecond(String str) {
		int h = Integer.parseInt(str.substring(0,2));
		int m = Integer.parseInt(str.substring(3,5));
		int s = Integer.parseInt(str.substring(6,8));

		return h*3600+m*60+s;
	}
	
	public static void main(String[] args) {
		Salary s = new Salary();
		
		System.out.println(s.howMuch(new String[]{"08:00:00","13:00:00","19:27:32"},new String[]{"12:00:00","17:00:00","20:48:10"},1000));
		System.out.println(s.howMuch(new String[]{"01:05:47","16:48:12"}, new String[]{"09:27:30","21:17:59"}, 2000));//33920
		System.out.println(s.howMuch(new String[]{"00:00:00"}, new String[]{"23:59:59"}, 10000));
		System.out.println(s.howMuch(new String[]{"10:00:00"}, new String[]{"18:00:00"}, 10000));
		System.out.println(s.howMuch(new String[]{"22:19:46"}, new String[]{"23:12:46"}, 5320));
		System.out.println(s.howMuch(
			new String[]{"00:11:13", "02:59:22", "04:42:01", "06:33:45", "08:22:30", "09:21:27", "11:15:50", "12:40:14", "13:55:51"},
			new String[]{"01:48:51", "03:22:59", "06:33:07", "06:45:47", "08:23:15", "09:34:07", "11:48:51", "12:47:18", "16:01:53"}, 9998)); //87238
	}
}

//public class Salary
//{
//	public int howMuch(String[] arrival, String[] departure, int wage) {
//		int h,h1,h2,m,m1,m2,s,s1,s2, rHour, rMin, rSec;
//		double res=0;
//		
//		for(int i=0; i < arrival.length; i++) {
//			h1 = Integer.parseInt(arrival[i].substring(0,2));
//			h2 = Integer.parseInt(departure[i].substring(0,2));
//			m1 = Integer.parseInt(arrival[i].substring(3,5));
//			m2 = Integer.parseInt(departure[i].substring(3,5));
//			s1 = Integer.parseInt(arrival[i].substring(6,8));
//			s2 = Integer.parseInt(departure[i].substring(6,8));
//			
//			h = (h2-h1>=0) ? h2-h1 : 24+(h2-h1);
//			
//			if(m2-m1>=0) m = m2-m1;
//			else {h--; m = 60+(m2-m1);}
//			
//			if(s2-s1>=0) s = s2-s1;
//			else {
//				if(m==0) {h--; m=60;}
//				m--;
//				s = 60+(s2-s1);
//			}
//
//			if(h1>=6 && h1<=17) {
//				if(h2>=h1 && h2<=17 || (h2==18 && (m2+s2)==0))
//					res += wageCal(h,m,s,wage);
//				else {
//					rHour = ((m1+s1)!=0) ? 17-h1 : 18-h1;
//					rMin = (s1==0) ? (60-m1)%60 : 59-m1;
//					rSec = (60-s1)%60;
//
//					res += wageCal(rHour,rMin,rSec,wage);
//
//					if(h2>=18 || h2<=5 || (h2==6 && m2+s2==0))
//						res += wageCal((h2>=18) ? h2-18 : 6+h2,m2,s2,wage*1.5);
//					else {
//						res += wageCal(12,0,0,wage*1.5);
//
//						res += wageCal(h2-6,m2,s2,wage);
//					}
//				}
//			}
//			else {
//				if(h1+12>h2 && (h2>=18 || h2<=5 || (h2==6 && m2+s2==0)))
//					res += wageCal(h,m,s,wage*1.5);
//				else {
//					rHour = (h1>=18) ? 12 - h1%18 : 6-h1;
//					if((m1+s1)!=0) rHour--;
//					rMin = (s1==0) ? (60-m1)%60 : 59-m1;
//					rSec = (60-s1)%60;
//
//					res += wageCal(rHour,rMin,rSec,wage*1.5);
//
//					if((h2>=6 && h2<=17) || (h2==18 && (m2+s2==0)))
//						res += wageCal(h2-6,m2,s2,wage);
//					else {
//						res += wageCal(12,0,0,wage);
//						
//						res += wageCal((h2>=18) ? h2-18 : h2+6,m2,s2,wage*1.5);
//					}
//				}
//			}
//		}
//		
//		return (int)res;
//	}
//	
//	public double wageCal(double h, double m, double s, double wage) {
//		return (h + m/60 + s/3600)*wage;
//	}
//	
//	public static void main(String[] args) {
//		Salary s = new Salary();
//		
//		System.out.println(s.howMuch(new String[]{"08:00:00","13:00:00","19:27:32"},new String[]{"12:00:00","17:00:00","20:48:10"},1000));
//		System.out.println(s.howMuch(new String[]{"01:05:47","16:48:12"}, new String[]{"09:27:30","21:17:59"}, 2000));//33920
//		System.out.println(s.howMuch(new String[]{"00:00:00"}, new String[]{"23:59:59"}, 10000));
//		System.out.println(s.howMuch(new String[]{"10:00:00"}, new String[]{"18:00:00"}, 10000));
//		System.out.println(s.howMuch(new String[]{"22:19:46"}, new String[]{"23:12:46"}, 5320));
//		System.out.println(s.wageCal(3,19,14,9998*1.5) + " " + s.wageCal(3,44,41,9998));
//		System.out.println(s.howMuch(
//			new String[]{"00:11:13", "02:59:22", "04:42:01", "06:33:45", "08:22:30", "09:21:27", "11:15:50", "12:40:14", "13:55:51"},
//			new String[]{"01:48:51", "03:22:59", "06:33:07", "06:45:47", "08:23:15", "09:34:07", "11:48:51", "12:47:18", "16:01:53"}, 9998)); //87238
//	}
//}
