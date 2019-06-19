import java.util.Arrays;
import java.text.DecimalFormat;

public class Planets
{
	public String[] locations(String[] planets, int time) {
		double G = 6.673E-11;
		double t = 3600;

		int n = planets.length;

		double[] f = new double[3];
		double[] m = new double[n];
		double[][] v = new double[n][3];
		double[][] p = new double[n][3];
		
		for (int i = 0; i < n; i++) {
			String[] sp = planets[i].split(" ");
			p[i][0] = Double.parseDouble(sp[0]);
			p[i][1] = Double.parseDouble(sp[1]);
			p[i][2] = Double.parseDouble(sp[2]);
			v[i][0] = Double.parseDouble(sp[3]);
			v[i][1] = Double.parseDouble(sp[4]);
			v[i][2] = Double.parseDouble(sp[5]);
			m[i] = Double.parseDouble(sp[6]);
		}

		for (int i = 0; i < time; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (j == k) continue;
					double xd = p[k][0] - p[j][0];
					double yd = p[k][1] - p[j][1];
					double zd = p[k][2] - p[j][2];
					double d = Math.sqrt(xd*xd + yd*yd + zd*zd);
					double F = (G*m[k]*m[j]) / (d*d);
					f[0] = F*(xd/d);
					f[1] = F*(yd/d);
					f[2] = F*(zd/d);
					for (int l = 0; l < 3; l++)
						v[j][l] += f[l]/m[j]*t;
				}
			}
			for (int j = 0; j < n; j++)
				for (int l = 0; l < 3; l++)
					p[j][l] += v[j][l]*t;
		}

		String[] res = new String[n];

		for (int i = 0; i < n; i++) {
			res[i] = "";
			for (int j = 0; j < 3; j++) {
				if(j != 0) res[i] += " ";
				String s = new DecimalFormat("0.000E0").format(p[i][j]);
				if (Math.abs(p[i][j]) < 1)
					s = new DecimalFormat("0.000").format(p[i][j]) + "E0";
				if (s.equals("-0.000E0"))
					s = "0.000E0";
				res[i] += s;
			}
		}

		return res;
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

// References
// https://www.topcoder.com/tc?module=Static&d1=match_editorials&d2=tco03_online_rd_1
// https://community.topcoder.com/stat?c=problem_solution&cr=261024&rd=4702&pm=1522
