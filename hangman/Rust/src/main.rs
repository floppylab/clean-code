extern crate rand;

use rand::Rng;
use std::fs::File;
use std::io::{BufRead, BufReader, Result};
use std::collections::{HashMap, HashSet};
use std::io;

fn main() -> Result<()> {
    let file = File::open("resources/words.in")?;
		let mut word_map = HashMap::new();
    for line in BufReader::new(file).lines() {
				let word = line?;
				let list = word_map.entry(word.len() as u32).or_insert(Vec::new());
				list.push(word);
    }

		let mut letter_count = String::new();
		println!("Number of letters in the word?");
		io::stdin().read_line(&mut letter_count)
            .expect("Failed to read line");
		let letter_count: u32 = match letter_count.trim().parse() {
				Ok(num) => num,
				Err(_) => panic!("Must be a positive integer!")
		};

		let words: &Vec<String> = match word_map.get(&letter_count) {
        Some(list) => list,
        None => panic!("Sorry, no words like that.")
    };

		let word = rand::thread_rng().choose(&words).unwrap();
		let mut solved = vec!['_'; letter_count as usize];
		let mut guessed: HashSet<char> = HashSet::new();
		let mut misses: u32 = 0;
		let mut count: u32 = 0;

		while misses < 10 {
			let mut hit = false;
			let mut guess = String::new();
			println!("Guess a letter");
			io::stdin().read_line(&mut guess)
							.expect("Failed to read line");
			let guess: char = match guess.trim().parse() {
				Ok(ch) => ch,
				Err(_) => continue
			};

			if guessed.contains(&guess) {
				println!("You have already guessed: {}\n", guess);
				continue;
			} else {
				guessed.insert(guess);
			}

			for (i, ch) in word.chars().enumerate() {
				if guess == ch {
					hit = true;
					count += 1;
					solved[i] = ch;
				}
			}

			if count == letter_count {
				println!("You win! The word was: {}", word);
				break;
			}

			if !hit {
				misses += 1;

				// drawing hangman
				print!("\n");
				if misses > 2 {
					println!("    xxxxxxxxxxxxx");
				} else { 
					print!("\n");
				}

				if misses > 3 {
					println!("    x           x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 3 {
					println!("    x           x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 4 {
					println!("   xxx          x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 4 {
					println!("  xxxxx         x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if  misses > 4 {
					println!("   xxx          x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 5 {
					println!("    x           x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 7 {
					println!("  x x x         x");
				} else if misses > 6 {
					println!("  x x           x");
				} else if misses > 5 {
					println!("    x           x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 7 {
					println!(" x  x  x        x");
				} else if misses > 6 {
					println!(" x  x           x");
				} else if misses > 5 {
					println!("    x           x");
				}  else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 5 {
					println!("    x           x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 9 {
					println!("   x x          x");
				} else if misses > 8 {
					println!("   x            x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 9 {
					println!(" x     x        x");
				} else if misses > 8 {
					println!(" x              x");
				} else if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if misses > 0 {
					println!("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				} else {
					println!("\n");
				}

				print!("\n");
			}

			let current: String = solved.iter().collect();
			println!("The word: {}", current);
		}

		if misses >= 10 {
			println!("You lose. The word was: {}", word);
		}

    Ok(())
}
