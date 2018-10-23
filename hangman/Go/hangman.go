package main
import (
	"fmt"
	"math/rand"
	"io/ioutil"
	"strings"
	"strconv"
	"sort"
)

func main(){
	// Reading text file, store it in string format, split it line by line
	br, err := ioutil.ReadFile("resources/words.in")
	
    if err != nil {
        fmt.Print(err)
	}

	temp := string(br)
	line := strings.Split(temp,"\n")

	// Sorting words by length
	d := make(map[string][]string)
	for i := range line {
		length := strconv.Itoa(len(line[i]))
		d[length] = append(d[length], line[i])
	}

	var keys []string
	for k := range d {
		keys = append(keys, k)
	}

	sort.Strings(keys)
	
	fmt.Print("Number of letters in the word? ")
	var l string
	fmt.Scanln(&l)

	_, contains := d[l]

	if contains {
		word := d[l][rand.Intn(len(d[l]))]

		v := make([]bool, len(word))
		e := 0
		done := true

		for e < 10 {
			done = true
			for i := 0; i < len(word); i++ {
				if(!v[i]){
					done = false
				}
			}

			if (done) {
				break
			}
			
			fmt.Println(word)
			fmt.Print("Guess a letter: ")
			var char string
			fmt.Scanln(&char)

			hit := false
			for i := 0; i < len(word); i++{
				if(string(word[i]) == char && !v[i]){
					v[i] = true
					hit = true
				}
			}

			if(hit) {
				fmt.Println("Hit!")
			} else {
				e++
				fmt.Print("Missed, mistake %d out %d \n", e, 10)

				// Drawing hangman

				fmt.Print("\n")
				if(e>2) { 
					fmt.Println("    xxxxxxxxxxxxx") 
				} else {
					fmt.Print("\n")
				}

				if(e>3) {
					fmt.Println("    x           x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {fmt.Print("\n")}

				if(e>3) {
					fmt.Println("    x           x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>4) {
					fmt.Println("   xxx          x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>4) {
					fmt.Println("  xxxxx         x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>4) {
					fmt.Println("   xxx          x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>5) {
					fmt.Println("    x           x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>7) {
					fmt.Println("  x x x         x")
				} else if(e>6) { 
					fmt.Println("  x x           x") 
				} else if(e>5) { 
					fmt.Println("    x           x") 
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>7) {
					fmt.Println(" x  x  x        x")
				} else if(e>6) { 
					fmt.Println(" x  x           x") 
				} else if(e>5) { 
					fmt.Println("    x           x") 
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>5) {
					fmt.Println("    x           x")
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {fmt.Print("\n")}

				if(e>9) {
					fmt.Println("   x x          x")
				} else if(e>8) {
					fmt.Println("   x            x")
				} else if (e > 1) {
					fmt.Println("                x")
				} else { 
					fmt.Print("\n") 
				}

				if(e>9) {
					fmt.Println(" x     x        x")
				} else if(e>8) { 
					fmt.Println(" x              x") 
				} else if (e > 1) { 
					fmt.Println("                x") 
				} else {
					fmt.Print("\n")
				}

				if(e>1) { 
					fmt.Println("                x") 
				} else { 
					fmt.Print("\n") 
				}

				if(e>1) { 
					fmt.Println("                x") 
				} else { 
					fmt.Print("\n") 
				}

				if(e>0) { 
					fmt.Println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx") 
				} else { 
					fmt.Println("\n") 
				}

				fmt.Print("\n")
			}

			fmt.Print("The word: ")
			for i := 0; i < len(word); i++ {
				if(v[i]) {
					fmt.Print(" " + string(word[i]) + " ")
				} else {
					fmt.Print(" _ ")
				}
			}

			fmt.Print("\n\n")
		}

		if(done){
			fmt.Println("You won!")
		} else {
			fmt.Println("You lost.")
			fmt.Println("The word was: " + word)
		}
	} else {
		fmt.Println("Sorry, no words like that.")
	}
}