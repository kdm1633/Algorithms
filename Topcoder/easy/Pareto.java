public class Pareto
{
	public int optima(String[] policy) {
		if(policy.length == 1) return 1;
		
		int[][] grade = new int[policy.length][policy[0].split(" ").length];

		for (int i=0; i < policy.length; i++) {
			String[] feeling = policy[i].split(" ");

			for (int j=0; j < feeling.length; j++) {
				switch (feeling[j]) {
					case "awful":
						grade[i][j]=1;
						break;
					case "bad":
						grade[i][j]=2;
						break;
					case "fair":
						grade[i][j]=3;
						break;
					case "fairly-happy":
						grade[i][j]=4;
						break;
					case "happy":
						grade[i][j]=5;
						break;
					case "ecstatic":
						grade[i][j]=6;
						break;
				}
			}
		}

		int res=grade.length;
		for (int i=0; i < grade.length; i++) {
			for (int j=0; j < grade.length; j++) {
				if(i==j) continue;

				boolean worse = false, better = false;
				for (int k=0; k < grade[0].length; k++) {
					if(grade[i][k] > grade[j][k]) {worse=true; break;}
					else if(grade[i][k] < grade[j][k]) better=true;
				}

				if(!worse && better) {res--; break;}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		Pareto p = new Pareto();
		System.out.println(p.optima(new String[]{"bad bad fairly-happy awful", "bad bad bad awful",	"ecstatic awful ecstatic ecstatic"}));
		System.out.println(p.optima(new String[]{"bad ecstatic","bad bad", "awful ecstatic", "fair happy", "fairly-happy fair",	"fairly-happy fairly-happy", "fair happy"}));
		System.out.println(p.optima(new String[]{"happy","bad","fairly-happy","bad","happy"}));
		System.out.println(p.optima(new String[]{"bad bad bad bad bad happy fairly-happy"}));
		System.out.println(p.optima(new String[]{"fair fair fair fair fair fair fair fair","bad fair fair fair fair fair fair fair","fairly-happy fair fair fair fair fair fair fair","happy bad bad bad bad bad bad bad","bad happy happy happy happy happy happy happy"}));
		System.out.println(p.optima(new String[]{"happy bad awful ecstatic fair bad fair awful", "fair awful bad awful ecstatic awful bad awful", "awful awful happy awful ecstatic awful bad fair", "bad bad bad happy happy ecstatic awful ecstatic", "bad bad awful awful fairly-happy fair fair happy", "fair bad bad fair happy bad ecstatic fair"}));
		System.out.println(p.optima(new String[]{"fair happy fair fairly-happy happy happy happy", "happy fair fairly-happy fair fair fair happy", "happy happy fair fair fairly-happy fair happy", "happy fair fair fairly-happy happy happy happy", "happy fair happy fairly-happy happy happy happy", "fair fair happy fair fair fair fairly-happy"}));
		System.out.println(p.optima(new String[]{"ecstatic bad fair fair fair ecstatic ecstatic", "ecstatic happy ecstatic awful awful fair awful", "happy fairly-happy bad happy fair fair ecstatic", "awful happy fair fairly-happy fair fair bad", "awful fairly-happy fair bad happy happy happy", "happy happy bad fair happy ecstatic fairly-happy", "fair happy ecstatic bad fairly-happy fair fair", "fairly-happy bad awful bad awful bad ecstatic", "fairly-happy awful bad fair ecstatic bad awful", "fairly-happy bad bad bad awful awful fair", "awful bad bad ecstatic ecstatic fair bad", "fair bad bad fair ecstatic fair ecstatic", "bad awful happy happy fairly-happy happy happy", "ecstatic fair fair awful happy fair happy", "fairly-happy fair awful awful happy awful fair", "bad fair fair fairly-happy bad happy happy", "bad bad fair ecstatic fairly-happy ecstatic bad", "bad fair happy fair awful fair ecstatic", "awful bad bad awful bad awful fairly-happy", "fair fair ecstatic bad bad happy awful", "awful bad ecstatic awful fair fairly-happy happy", "happy bad fair awful awful ecstatic bad", "happy bad bad ecstatic fair fair bad", "bad fairly-happy bad awful fair happy ecstatic", "awful awful happy bad happy ecstatic bad", "awful fair awful awful ecstatic fair fair", "bad fairly-happy awful happy awful bad ecstatic", "ecstatic happy happy fair fairly-happy fair bad", "happy awful happy bad bad fairly-happy fair", "ecstatic fair awful awful awful bad fairly-happy", "fair fair bad fairly-happy awful fair fair", "fair fairly-happy bad happy happy awful fair", "happy ecstatic awful fair fair awful ecstatic", "ecstatic awful fair ecstatic ecstatic happy bad", "awful bad fair ecstatic happy awful fair", "ecstatic happy fair happy happy bad ecstatic", "bad awful awful awful happy ecstatic bad", "ecstatic fair fair bad awful ecstatic bad", "bad happy bad ecstatic bad awful happy", "fairly-happy bad ecstatic awful fair fair awful", "fairly-happy fair awful awful ecstatic bad fair", "fairly-happy bad happy bad fair happy happy", "happy ecstatic fair fairly-happy fair bad bad", "bad bad fairly-happy happy bad bad bad", "happy happy fair fair bad fair awful", "awful fair bad bad happy fair fair", "fair ecstatic happy happy awful fair bad", "awful fairly-happy happy fair happy awful bad", "awful fair bad happy happy ecstatic ecstatic", "bad bad fair ecstatic happy ecstatic ecstatic"}));
		System.out.println(p.optima(new String[]{"fair happy fairly-happy", "fair happy fair", "awful ecstatic fair", "awful ecstatic fair", "fair happy fair", "fair happy fair"}));
	}
}
