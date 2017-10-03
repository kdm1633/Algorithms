import java.text.DecimalFormat;
import java.util.Arrays;

public class Planets
{
	int n;

	double G = 6.673e-11;
	double t = 3600;

	double[][] v;
	double[][] pos;
	double[] m;
	String[] sp;

	double kvad(double a) {return a*a;}

	void update(int nr) {
		double[] f = new double[3];
		for (int i=0; i < n; i++) {
			if(i==nr) continue;

			double dist = Math.sqrt(kvad(pos[i][0]-pos[nr][0]) + kvad(pos[i][1]-pos[nr][1]) + kvad(pos[i][2]-pos[nr][2]));
			double F = G*m[i]*m[nr] / kvad(dist);
			for (int k=0; k < 3; k++)
				f[k] += F*((pos[i][k]-pos[nr][k])/dist); // 이 부분 설명
		}

		for (int j=0; j < 3; j++)
			v[nr][j] += f[j]*t/m[nr];
	}

	void move(int nr) {
		for (int j=0; j < 3; j++)
			pos[nr][j] += v[nr][j]*t;
	}

	DecimalFormat df = new DecimalFormat("0.000");

	String form(double a) {
		boolean neg = a<0;
		if(neg) a = -a;
		int eksp=0;
		while(Math.pow(10,eksp+1) <= a) eksp++;
		a /= Math.pow(10,eksp);
		String ans = df.format(a).replace(",",".");
		if(ans.equals("10.000")) {ans="1.000"; eksp++;}
		if(neg && !ans.equals("0.000")) ans = "-"+ans;
		ans = ans+"E"+eksp;
		return ans;
	}

	public String[] locations(String[] planets, int time) {
		n = planets.length;
		v = new double[n][3];
		pos = new double[n][3];
		m = new double[n];

		for (int i=0; i < n; i++) {
			sp = planets[i].split(" ");
			pos[i][0] = Double.parseDouble(sp[0]);
			pos[i][1] = Double.parseDouble(sp[1]);
			pos[i][2] = Double.parseDouble(sp[2]);
			v[i][0] = Double.parseDouble(sp[3]);
			v[i][1] = Double.parseDouble(sp[4]);
			v[i][2] = Double.parseDouble(sp[5]);
			m[i] = Double.parseDouble(sp[6]);
		}

		for (int i=0; i < time; i++) {
			for (int j=0; j < n; j++)
				update(j);
			for (int j=0; j < n; j++)
				move(j);
		}

		String[] svar = new String[n];
		for (int i=0; i < n; i++)
			svar[i] = form(pos[i][0]) + " " + form(pos[i][1]) + " " + form(pos[i][2]);

		return svar;
	}

	public static void main(String[] args) {
		Planets p = new Planets();
		System.out.println(Arrays.toString(p.locations(new String[]{"0 0 0 0 0 0 1.98892E30","1.496E11 0 0 0 29785.391801 0 5.972E24"}, 100)));
		System.out.println(Arrays.toString(p.locations(new String[]{"0 0 -.00000001 0 0 0 1.98892E30","1.496E11 0 0 0 29785.391801 0 5.972E24"},1)));
		System.out.println(Arrays.toString(p.locations(new String[]{"0 000E0000 .0000 0 0 0 1.98892E30","1.496E8 0 0 0 0 0 5.972E24"},1)));
		System.out.println(Arrays.toString(p.locations(new String[]{"0 0 0.0000 0 0 0 1.98892E30","1.496E11 0 0 0 0 0 5.972E24"},50)));
		System.out.println(Arrays.toString(p.locations(new String[]{"5.05E9 -5.45E9 7.43E9 63.36 -66.61 37.53 4.43E49","3.25E9 -3.34E9 -2.64E9 -93.91 85.61 -34.32 7.90E49","4.97E8 -4.78E9 4.70E9 -2.032 -46.67 66.06 1.74E49","3.31E9 -2.58E9 4.98E9 26.73 -40.55 -64.62 4.10E48","1.66E9 2.34E9 2.2E9 -90.23 92.23 -53.40 4.23E49"},100)));
		System.out.println(Arrays.toString(p.locations(new String[]{"0 0 0 0 0 0 1000","500 500 866.02540378443864676372317 0 0 0 1000","1000 1000 0 0 0 0 1000"},100)));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=261024&rd=4702&pm=1522
