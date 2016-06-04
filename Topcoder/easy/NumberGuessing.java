import java.util.Map;
import java.util.TreeMap;

public class NumberGuessing
{
	public class GuessResult {
		public Integer guess;
		public Map<Integer, Integer> probs;

		public GuessResult(Integer guess, Map<Integer, Integer> probs) {
			this.guess = guess;
			this.probs = probs;
		}
	}

	public int bestGuess(int range, int[] guesses, int numLeft) {
		TreeMap<Integer, Boolean> guessSet = new TreeMap<Integer, Boolean>();
		for (int i : guesses) {
			guessSet.put(i, false);
		}
		return guess(range, guessSet, numLeft).guess;
	}

	GuessResult guess(int range, TreeMap<Integer, Boolean> guesses, int numLeft) {
		if (numLeft == 0) {
			int best = guessLast(range, guesses);
			guesses.put(best, true);
			Map<Integer, Integer> result = calculateProbs(range, guesses);
			guesses.remove(best);
			return new GuessResult(best, result);
		}

		GuessResult best = null;
		int bestRange = -1;

		for (int i = 1; i <= range; i++) {
			if (guesses.containsKey(i)) continue;

			guesses.put(i, true);
			GuessResult result = guess(range, guesses, numLeft - 1);
			guesses.remove(i);

			int winRange = result.probs.get(i);
			if (winRange > bestRange) {
				best = result;
				best.guess = i;
				bestRange = winRange;
			}
		}
		return best;
	}

	int guessLast(int range, TreeMap<Integer, Boolean> guesses) {
		if (guesses.isEmpty()) {
			return 1;
		}
		int best = -1, winRange = -1;

		int prev = -1;
		for (int g : guesses.keySet()) {
			if (prev == -1) {
				best = winRange = g - 1;
			} else if (g - prev > 1 && (g - prev - 2) / 2 + 1 > winRange) {
				best = prev + 1;
				winRange = (g - prev - 2) / 2 + 1;
			}
			prev = g;
		}
		if (range - prev > winRange) {
			best = prev + 1;
			winRange = range - prev;
		}
		return best;
	}

	Map<Integer, Integer> calculateProbs(int range, TreeMap<Integer, Boolean> guesses) {
		Map<Integer, Integer> probs = new TreeMap<Integer, Integer>();
		int prev = -1;
		int g = -1;
		boolean gFlag = false;
		for (Map.Entry<Integer, Boolean> next : guesses.entrySet()) {
			if(gFlag) {
				int winRange = (prev == -1) ? g : (g - prev - 1) / 2 + 1;
				winRange += (next.getKey() - g - 1) / 2;
				probs.put(g, winRange);
			}
			prev = g;
			g = next.getKey();
			gFlag = next.getValue();
		}
		int winRange = (prev == -1) ? g : (g - prev - 1) / 2 + 1;
		winRange += range - g;
		probs.put(g, winRange);

		return probs;
	}

	public static void main(String[] args) {
		NumberGuessing n = new NumberGuessing();
		System.out.println(n.bestGuess(1000, new int[]{500}, 1));
		System.out.println(n.bestGuess(1000000, new int[]{}, 1));
		System.out.println(n.bestGuess(1000, new int[]{}, 2));
		System.out.println(n.bestGuess(100, new int[]{27,80}, 1));
		System.out.println(n.bestGuess(20, new int[]{18,13,8,3}, 0)); //2
		System.out.println(n.bestGuess(10, new int[]{}, 6)); //9
	}
}

// https://bitbucket.org/ruippeixotog/topcoder-srm-148/src/b1ac4c1ccad3575fe4e431871c68fe1f9d991950/numberguessing-java/NumberGuessing.java?at=master&fileviewer=file-view-default
