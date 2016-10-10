public class PossibleOrders
{
	int N;
	long sum;
	
	long comb(long n, long r) {
		long denom=1, numer=1;
		
		while (r > 0) {denom *= n--; numer *= r--;}

		return denom / numer;
	}

	void calcul(long[] cnt, int rem, int min) {
		for (int i=min; i<=rem; i++) {
			long[] c = new long[N+1];
			System.arraycopy(cnt,0,c,0,N+1);
			
			c[i]++;
			
			if (rem-i>0)
				calcul(c, rem-i, i);
			else if (rem-i==0) {
				long r=N,s=1,f=0,d=1;

				for (int j=N; j>0 && r>0; j--) {
					if(c[j]!=0) {
						if(j>1)
							for (long tot=r; r-c[j]*j != tot; tot-=j)
								s *= comb(tot,j);
						
						r -= c[j]*j;
						f += c[j];
						
						if(j>1 && c[j]>1)
							for (long k=c[j]; k>1; k--)
								d *= k;
						
						if(r==0) {
							for(long k=f; k>1; k--)
								s *= k;
								
							sum += s/d;
						}
					}
				}
			}
		}
	}

	public long howMany(int num, String[] facts) {
		N = num; sum=1;
		String[] str = new String[facts.length];

		// Cartegorizing equal elements
		if (facts.length != 0) {
			for(int i=0; i < str.length; i++)
				str[i] = " ";
			
			for (int i=0; i < facts.length; i++) {
				String[] n = facts[i].split("=");
				
				String s1 = " " + n[0] + " ";
				String s2 = " " + n[1] + " ";
				
				if(s1.contains(s2)) continue;
				
				for (int j=0; j < str.length; j++) {
					if(str[j].contains(s1) && str[j].contains(s2))
						break;
					else if(!str[j].contains(s1) && !str[j].contains(s2) && str[j].length()!=1)
						continue;

					if(!str[j].contains(s1)) str[j] += n[0] + " ";
					if(!str[j].contains(s2)) str[j] += n[1] + " ";

					break;
				}
			}

			for (int i=str.length-1; i > 0; i--) {
				if(str[i].length()==1) continue;

				LOOP:
				for (int j=i-1; j >= 0; j--) {
					String[] n = str[i].split(" ");
					
					for (int k=1; k < n.length-1; k++) {
						String s1 = " " + n[k] + " ";
						if(str[j].contains(s1)) {
							for (int l=1; l < n.length-1; l++) {
								String s2 = " " + n[l] + " ";
								if(!str[j].contains(s2)) str[j] += n[l] + " ";
							}
							str[i] = " ";

							break LOOP;
						}
					}
				}
			}
		}

		// Eliminating empty elements
		for (int i=str.length-1; i > 0; i--) {
			if(str[i].length() != 1) {
				for (int j=i-1; j >= 0; j--) {
					if(str[j].length()==1) {
						str[j] = str[i];
						str[i] = " ";
					}
				}
				if(str[i].length() != 1) break;
			}
		}
		
		// Subtracting equal elements from N
		for (int i=0; i < str.length && str[i].length()!=1; i++)
			N -= str[i].split(" ").length-2;

		for (int i=1; i <= N/2; i++) {
			long[] cnt = new long[N+1];
			
			cnt[i]++;
			calcul(cnt,N-i,i);
		}

		return sum;
	}

	public static void main(String[] args) {
		PossibleOrders p = new PossibleOrders();
		System.out.println(p.howMany(4, new String[]{"0=2","1=3"}));
		System.out.println(p.howMany(4, new String[]{}));
		System.out.println(p.howMany(3, new String[]{"1=1"}));
		System.out.println(p.howMany(3, new String[]{"1=2","2=1"}));
		System.out.println(p.howMany(17, new String[]{}));
	}
}
