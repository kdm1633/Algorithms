import java.util.ArrayList;
import java.util.ListIterator;

public class Optimizer
{
	String s;
	int i;
	
	enum T {
		prod, sum, var, num;
	}
	
	class expr {
		T type;
		String sval;
		double dval;
		ArrayList<expr> lval;
		
		expr() {
			type = null;
			sval = "";
			dval = 0;
			lval = new ArrayList<expr>();
		}
	}
	
	expr expr1() {
		expr r = new expr();
		r.type = T.sum;
		r.lval.add(expr2());
		while (i<s.length() && s.charAt(i)=='+') {
			i++;
			r.lval.add(expr2());
		}
		if(r.lval.size()==1) return r.lval.get(0);
		
		return r;
	}
	
	expr expr2() {
		expr r = new expr();
		r.type = T.prod;
		r.lval.add(expr3());
		while (i < s.length() && s.charAt(i)=='*') {
			i++;
			r.lval.add(expr3());
		}
		if(r.lval.size()==1) return r.lval.get(0);
		
		return r;
	}
	
	expr expr3() {
		if (i < s.length() && s.charAt(i)=='(') {
			i++;
			expr r = expr1();
			i++;
			return r;
		}

		String tok="";
		while (i < s.length() && Character.isLetterOrDigit(s.charAt(i)))
			tok += s.charAt(i++);

		expr r = new expr();

		if(Character.isDigit(tok.charAt(0))) {
			r.type = T.num;
			r.dval = Integer.parseInt(tok);
		}
		else {
			r.type = T.var;
			r.sval = tok;
		}
		
		return r;
	}
	
	expr execsum(expr e) {
		double dsum=0;
		for (ListIterator<expr> it = e.lval.listIterator(); it.hasNext();) {
			expr e1 = it.next();

			if(e1.type == T.num) {dsum += e1.dval; it.remove();}
		}
		
		if (dsum!=0 || e.lval.size() == 0) {
			expr e2 = new expr();
			e2.type = T.num;
			e2.dval = dsum;
			e.lval.add(e2);
		}
		
		if(e.lval.size() == 1) return e.lval.get(0);
		
		return e;
	}
	
	expr execprod(expr e) {
		double dprod=1;
		for (ListIterator<expr> it = e.lval.listIterator(); it.hasNext();) {
			expr e1 = it.next();

			if (e1.type == T.num) {dprod *= e1.dval; it.remove();}
			
			if (dprod == 0) {
				e = new expr();
				e.type = T.num;
				e.dval = 0;
				return e;
			}
		}
		
		if (dprod!=1 || e.lval.size()==0) {
			expr e2 = new expr();
			e2.type = T.num;
			e2.dval = dprod;
			e.lval.add(e2);
		}

		if(e.lval.size() == 1) return e.lval.get(0);
	
		return e;
	}
	
	expr optimize(expr e) {
		expr r;
		switch (e.type) {
			case sum:
				r = new expr();
				r.type = T.sum;
				for (expr e1 : e.lval) {
					e1 = optimize(e1);
					
					switch (e1.type) {
						case sum:
							for(expr e2 : e1.lval)
								r.lval.add(e2);
							break;
						default:
							r.lval.add(e1);
					}
				}
				return execsum(r);
			case prod:
				r = new expr();
				r.type = T.prod;
				for (expr e1 : e.lval) {
					e1 = optimize(e1);
					
					switch (e1.type) {
						case prod:
							for(expr e2 : e1.lval)
								r.lval.add(e2);
							break;
						default:
							r.lval.add(e1);
					}
				}
				return execprod(r);
			default:
				return e;
		}
	}
	
	int nops(expr e) {
		int s=0;
		
		switch (e.type) {
			case sum:
				s += e.lval.size()-1;
				for(expr e1 : e.lval)
 					s += nops(e1);
				break;
			case prod:
				s += 10*(e.lval.size()-1);
				for(expr e2 : e.lval)
					s += nops(e2);
				break;
		}
		
		return s;
	}
	
	public int reduce(String expression) {
		s="";
		for(i=0; i < expression.length(); i++)
			if(expression.charAt(i) != ' ')
				s += expression.charAt(i);
		
		i=0;
		expr r = expr1();		// Parsing
		expr r2 = optimize(r);	// Optimizing
		return nops(r2);		// Calculating
	}
	
	public static void main(String[] args) {
		Optimizer o = new Optimizer();
		System.out.println(o.reduce("  alpha*beta+5*006  "));
		System.out.println(o.reduce("a * b * 00 + 1 * 5"));
		System.out.println(o.reduce("dx + a * b * 0 + 1 * c"));
		System.out.println(o.reduce("5 * (3 + 4 + c) + (a + c) * (c + d)"));
		System.out.println(o.reduce("9 * ((4 + 4)) * (7) * (3 + 1) + 504"));
		System.out.println(o.reduce("((((aa))))"));
		System.out.println(o.reduce("(1 + 0 * a) * c + (0 + 0 * b) * d"));
		System.out.println(o.reduce("5 * d + 5 * b"));
		System.out.println(o.reduce("(a*5)*4+((a+4)+5)"));
		System.out.println(o.reduce("(a*5)*(b*6)"));
		System.out.println(o.reduce("(1)+0+1*(w+6)*1"));
	}
}

// https://community.topcoder.com/stat?c=problem_solution&cr=287496&rd=4482&pm=1574
