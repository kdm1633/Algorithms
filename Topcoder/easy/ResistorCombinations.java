import java.util.ArrayList;
import java.util.HashSet;

public class ResistorCombinations
{
	double t, closest, res;

	ArrayList<ArrayList<Integer>> getSet(ArrayList<Integer> copy, int idx, int n, int size) {
		ArrayList<ArrayList<Integer>> S = new ArrayList<ArrayList<Integer>>();
		for (int i = idx; i < size; i++) {
			ArrayList<Integer> A = new ArrayList<Integer>(copy);
			A.add(i);
			if (n < size/2) S.addAll(getSet(A,i+1,n+1,size));
			S.add(A);
		}

		return S;
	}

	HashSet<Double> getAllCombos(ArrayList<Double> r) {
		if (r.size() <= 1) return new HashSet<Double>(r);

		ArrayList<Double> A, B;
		HashSet<Double> comboA, comboB;
		HashSet<Double> ret = new HashSet<Double>();

		ArrayList<ArrayList<Integer>> S = getSet(new ArrayList<Integer>(),0,1,r.size());

		for (int i = 0; i < S.size(); i++) {
			A = new ArrayList<Double>();
			B = new ArrayList<Double>(r);
			for (int j = S.get(i).size()-1; j >= 0; j--)
				A.add(B.remove((int)S.get(i).get(j)));
			comboA = getAllCombos(A);
			comboB = getAllCombos(B);
			for (double EA : comboA) {
				ret.add(EA);
				for (double EB : comboB) {
					ret.add(EB);
					ret.add(EA+EB);
					ret.add((EA*EB)/(EA+EB));
				}
			}
		}

		return ret;
	}

	public double closestValue(String[] resistances, double target) {
		t = target;
		closest = res = Double.MAX_VALUE;

		ArrayList<Double> r = new ArrayList<Double>();
		for (int i = 0; i < resistances.length; i++)
			r.add(Double.parseDouble(resistances[i]));

		for (double d : getAllCombos(r))
			if (Math.abs(t-d) < closest) {res = d; closest = Math.abs(t-d);}

		return res;
	}

	public static void main(String[] args) {
		ResistorCombinations r = new ResistorCombinations();
		System.out.println(r.closestValue(new String[]{"2","3","5"},2.5));
		System.out.println(r.closestValue(new String[]{"2","3","5"},1));
		System.out.println(r.closestValue(new String[]{"10.25","13.31","6.777","12.2"},10.5));
		System.out.println(r.closestValue(new String[]{"10000","2000","300","40","5"},20000));
		System.out.println(r.closestValue(new String[]{"125.10000","00270.9","000625.55","90.100000","0015.60000"},153));
		System.out.println(r.closestValue(new String[]{"3.414","0.81","5.719","7.925","8.298"},2.131));
		System.out.println(r.closestValue(new String[]{"3", "4", "5", "6"},7));
	}
}

// References
// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm171
