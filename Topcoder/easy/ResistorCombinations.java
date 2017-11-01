import java.util.ArrayList;

public class ResistorCombinations
{
	double closest, tg;
	
	void cal(ArrayList<Double> r) {
		for (int i=0; i < r.size(); i++)
			if(Math.abs(r.get(i)-tg) < Math.abs(closest-tg)) closest = r.get(i);
		
		if(r.size() == 1) return;
		
		for (int i=0; i < r.size(); i++) {
			ArrayList<Double> rrr = new ArrayList<Double>(r);
			
			int back = r.size()-1;
			
			Double temp = rrr.get(i);
			rrr.set(i,rrr.get(back));
			rrr.set(back,temp);
			
			for (int j=0; j < r.size()-1; j++) {
				ArrayList<Double> rr = new ArrayList<Double>(rrr);
				rr.remove(back);
				rr.set(j,rr.get(j)+rrr.get(back));
				cal(rr);
				rr.set(j,rrr.get(j)*rrr.get(back) / (rrr.get(j)+rrr.get(back)));
				cal(rr);
			}
		}
	}

	public double closestValue(String[] resistances, double target) {
		closest = 1e20; tg = target;
		
		ArrayList<Double> r = new ArrayList<Double>();
		for (int i=0; i < resistances.length; i++)
			r.add(Double.parseDouble(resistances[i]));
		
		cal(r);
		
		return closest;
	}

	public static void main(String[] args) {
		ResistorCombinations r = new ResistorCombinations();
		System.out.println(r.closestValue(new String[]{"2","3","5"},2.5));
		System.out.println(r.closestValue(new String[]{"2","3","5"},1));
		System.out.println(r.closestValue(new String[]{"10.25","13.31","6.777","12.2"},10.5));
		System.out.println(r.closestValue(new String[]{"10000","2000","300","40","5"},20000));
		System.out.println(r.closestValue(new String[]{"125.10000","00270.9","000625.55","90.100000","0015.60000"},153));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=286907&rd=4660&pm=1941
