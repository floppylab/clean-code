extern crate rand;

use rand::Rng;
use std::fs::File;
use std::io::{BufRead, BufReader, Result};
use std::collections::HashMap;
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
		let mut v = vec![false; letter_count as usize];
		let mut e: u32 = 0;
		let mut done = true;

		while e < 10 {
			done = true;
			for (i, _ch) in word.chars().enumerate() {
				if !v[i] {
					done = false;
				}
			}

			if done {
				break;
			}

			let mut hit = false;
			let mut guess = String::new();

			println!("Guess a letter: ");
			io::stdin().read_line(&mut guess)
							.expect("Failed to read line");
			let guess: char = match guess.trim().parse() {
				Ok(ch) => ch,
				Err(_) => continue
			};

			// TODO: check if previously entered.

			for (i, ch) in word.chars().enumerate() {
				if guess == ch {
					hit = true;
					v[i] = true;
				}
			}

			if hit {
				println!("Hit!");
			} else {
				println!("Missed, mistake {} out of {}", e + 1, 10);
				e += 1;

				// drawing hangman
				print!("\n");
				if e > 2 {
					println!("    xxxxxxxxxxxxx");
				} else { 
					print!("\n");
				}

				if e > 3 {
					println!("    x           x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 3 {
					println!("    x           x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 4 {
					println!("   xxx          x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 4 {
					println!("  xxxxx         x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if  e > 4 {
					println!("   xxx          x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 5 {
					println!("    x           x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 7 {
					println!("  x x x         x");
				} else if e > 6 {
					println!("  x x           x");
				} else if e > 5 {
					println!("    x           x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 7 {
					println!(" x  x  x        x");
				} else if e > 6 {
					println!(" x  x           x");
				} else if e > 5 {
					println!("    x           x");
				}  else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 5 {
					println!("    x           x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 9 {
					println!("   x x          x");
				} else if e > 8 {
					println!("   x            x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 9 {
					println!(" x     x        x");
				} else if e > 8 {
					println!(" x              x");
				} else if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 1 {
					println!("                x");
				} else {
					print!("\n");
				}

				if e > 0 {
					println!("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				} else {
					println!("\n");
				}

				print!("\n");
			}

			print!("The word: ");

			for (i, ch) in word.chars().enumerate() {
				if v[i] {
					print!(" {} ", ch);
				} else {
					print!(" _ ");
				}
			}
			print!("\n");
		}

		if done {
			println!("You win!");
		} else {
			println!("You lost.");
			println!("The word was: {}", word);
		}

    Ok(())
}
