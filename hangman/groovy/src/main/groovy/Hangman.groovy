
class Hangman {

	static void main(final String... args) {

		def final scanner = new Scanner(System.in)
		def wordMap = [] as Map<Integer, List<String>>
		try  {
			wordMap = initWordMap()
		} catch (IOException e) {
			print "------------------------ ATTENTION ------------------------------"
			print "Error found at the file input, please check if word.in is present"
			print "-----------------------------------------------------------------"
			e.printStackTrace()
		}
		runGameInteractions(wordMap, scanner)
		scanner.close()
	}

	private static void runGameInteractions(Map<Integer, List<String>> orderedByLength, Scanner scanner) {
		println "Number of letters in the word? "
		int l = scanner.nextInt()
		if (orderedByLength.containsKey(l)) {
			// choose a random word with the given length
			def word = orderedByLength.get(l).get(new Random().nextInt(orderedByLength.get(l).size()))
			def matrixOfAssertions = new boolean[word.length()]
			def interactions = 0
			def wordFound = true

			while (interactions < 10) {
				wordFound = true

				for (int i = 0; i < word.length(); ++i) {
					if (!matrixOfAssertions[i]) {
						wordFound = false
					}
				}
				if (wordFound) {
					break
				}

				print("Guess a letter: ")
				char chr = scanner.next().charAt(0)

				// TODO check if previously entered
				boolean hit = false
				for (int i = 0; i < word.length(); ++i) {
					if (word.charAt(i) == chr && !matrixOfAssertions[i]) {
						matrixOfAssertions[i] = true
						hit = true
					}
				}
				if (hit) {
					print("Hit!\n")
				} else {

					print("Missed, mistake #${interactions + 1} out of %${10}\n")
					++interactions
					drawHangman(interactions)
				}
				print("The word: ")
				for (int i = 0; i < word.length(); ++i) {
					if (matrixOfAssertions[i]) {
						print(" " + word.charAt(i) + " ")
					} else {
						print(" _ ")
					}
				}
				print("\n\n")
			}

			// printing final result
			showWinner(wordFound, word)
		} else {
			print("Sorry, no words like that.\n")
		}
	}

	private static void showWinner(boolean done, String word) {
		if (done) {
			print("You won!\n")
		} else {
			print("You lost.\n")
			println("The word was: " + word)
		}
	}

	private static void drawHangman(int e) {
		print("\n")
		if (e > 2) println("    xxxxxxxxxxxxx")
		else print("\n")

		if (e > 3) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 3) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 4) println("   xxx          x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 4) println("  xxxxx         x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 4) println("   xxx          x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 5) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 7) println("  x x x         x")
		else if (e > 6) println("  x x           x")
		else if (e > 5) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 7) println(" x  x  x        x")
		else if (e > 6) println(" x  x           x")
		else if (e > 5) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 5) println("    x           x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 9) println("   x x          x")
		else if (e > 8) println("   x            x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 9) println(" x     x        x")
		else if (e > 8) println(" x              x")
		else if (e > 1) println("                x")
		else print("\n")

		if (e > 1) println("                x")
		else print("\n")

		if (e > 1) println("                x")
		else print("\n")

		if (e > 0) println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx")
		else println("\n")
		print("\n")
	}

	private static  Map<Integer, List<String>> initWordMap() throws IOException {
		def inputArray = [] as  List<String>
		def orderedByLength = new HashMap<>() as Map<Integer, List<String>>
		new InputStreamReader(Hangman.class.getResourceAsStream(("/words.in"))).eachLine {
			inputArray.each { String word ->
				if (!orderedByLength.containsKey(word.length())) {
					orderedByLength.put(word.length(), [] as List<String>)
				}
				orderedByLength.get(word.length()).add(word)
			}
		}
		orderedByLength
	}
}
