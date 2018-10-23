package com.floppylab.refactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

	public static void main(final String... args) {

		ArrayList<String> w = new ArrayList<String>();
		HashMap<Integer, ArrayList<String>> d = new HashMap<>();
		BufferedReader br  = null;
		final Scanner scanner = new Scanner(System.in);
		String line;

		try {
			br = new BufferedReader(new InputStreamReader(Hangman.class.getResourceAsStream(("/words.in"))));

			// reading text file line by line
			while ((line = br.readLine()) != null){
				w.add(line.trim());
			}

			// sorting words by length
			for(int i= 0; i < w.size(); i++) {
				if(!d.containsKey(w.get(i).length())) {
					d.put(w.get(i).length(), new ArrayList<>());
				}
				d.get(w.get(i).length()).add(w.get(i));
			}

			System.out.print("Number of letters in the word? ");
			int l = scanner.nextInt();

			if(d.containsKey(l))  
			{
				// choose a random word with the given length
				String word = d.get(l).get(new Random().nextInt(d.get(l).size()));
				boolean[] v = new boolean[word.length()];
				int e = 0;
				boolean done = true;

				while (e < 10) {

					done = true;
					for (int i = 0; i < word.length(); ++i) {
						if (!v[i]) {
							done = false;
						}
					}
					if (done) {
						break;
					}
					
					System.out.print("Guess a letter: ");
					char chr = scanner.next().charAt(0);
					
					// TODO check if previously entered
					boolean hit = false;
					for (int i = 0; i < word.length(); ++i) {
						if (word.charAt(i) == chr && !v[i]) {
							v[i] = true;
							hit = true;
						}
					}
					if (hit) {
						System.out.print("Hit!\n");
					} else {

						System.out.printf(
								"Missed, mistake #%d out of %d\n",
								e + 1, 10
								);
						++e;

						// drawing hangman
						System.out.print("\n");
						if(e>2) System.out.println("    xxxxxxxxxxxxx");
						else System.out.print("\n");

						if(e>3) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>3) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>4) System.out.println("   xxx          x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>4) System.out.println("  xxxxx         x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>4) System.out.println("   xxx          x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>5) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>7) System.out.println("  x x x         x");
						else if(e>6) System.out.println("  x x           x");
						else if(e>5) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>7) System.out.println(" x  x  x        x");
						else if(e>6) System.out.println(" x  x           x");
						else if(e>5) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>5) System.out.println("    x           x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>9) System.out.println("   x x          x");
						else if(e>8) System.out.println("   x            x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>9) System.out.println(" x     x        x");
						else if(e>8) System.out.println(" x              x");
						else if (e > 1) System.out.println("                x");
						else System.out.print("\n");

						if(e>1) System.out.println("                x");
						else System.out.print("\n");

						if(e>1) System.out.println("                x");
						else System.out.print("\n");

						if(e>0) System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
						else System.out.println("\n");
						System.out.print("\n");

					}
					System.out.print("The word: ");
					for (int i = 0; i < word.length(); ++i) {
						if (v[i]) {
							System.out.print(" " + word.charAt(i)+ " ");
						} else {
							System.out.print(" _ ");
						}
					}
					System.out.append("\n\n");
				}
				
				// printing final result
				if (done) {
					System.out.print("You won!\n");
				} else {
					System.out.print("You lost.\n");
					System.out.println("The word was: " + word);
				}
			}
			else 
			{
				System.out.print("Sorry, no words like that.\n");
			}

		} catch (IOException e) {
			// TODO nice exception catching
			e.printStackTrace();
		}
		scanner.close();
	}
}
