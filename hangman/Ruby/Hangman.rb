# HangMan in Ruby

class HangMan
    

        def initialize()
           
            @wordsList = Array.new
            @lettersUsed = Array.new
            @lettersDisplayArr = Array.new
            @randomWord = nil
            @userInput = nil
            @numOfGuesses = 0
            @foundWord = false
            
            File.open("resources/words.in").each do |line|
                @wordsList.push(line)
             end
             chooseRandomWord()
        end    


        #chooses a random word from the wordsList array
        def chooseRandomWord()              
            @randomWord = @wordsList[rand(0..@wordsList.size)]
            @randomWord.downcase
            
            #adding "_" to the letters array to display during the game
            randomWordSize = @randomWord.size - 1
            (1..randomWordSize).each do |i| 
                @lettersDisplayArr.push(" _ ")
                
            end
            beginGame()
        end

              
       
       #game loop to play hangman
        def beginGame()
            puts "Let's Play HangMan!"
            puts "The word is #{@randomWord.size - 1} characters long."
                 
                 
            while(@numOfGuesses < 10 && @foundWord == false)
                displayLettersFound()
                puts "Please enter in a character:"

                @userInput = $stdin.gets.chomp
                @userInput.downcase

                #verify the character hasn't already been used     
                if @lettersUsed.include?(@userInput) == true
                    puts "You've used #{@userInput} already!"
                    @numOfGuesses = @numOfGuesses + 1
                    drawHangMan()

                #the letter hasn't already been used and
                #is apart of the word
                elsif @randomWord.include?(@userInput) == true 
                    puts "You've gussed a letter!"
                    updateLettersFound()
                    drawHangMan()

                #the letter isn't apart of the word
                else
                    @numOfGuesses = @numOfGuesses + 1
                    @lettersUsed.push(@userInput)
                    drawHangMan()
                end

                    puts "You've made #{@numOfGuesses} out of 10 guesses"
                    winOrLose()
                    @userInput = nil
            
            end            
            
        end

        
        
        #displays the letters to the user
        def displayLettersFound()

            @lettersDisplayArr.each do |i| 
                print i
            end
            print "\n"
        end
        
        
        
        #updates the letters in the @lettersDisplayArr when
        #the users guesses a correct letter. Then calls the 
        #displayLettersFound method to show the updated array
        def updateLettersFound()
            indices = @randomWord.chars
                 .each_with_index
                 .select{|char, index| char == @userInput }
                 .map{|pair| pair.last}
           
            indices.each do |index|
                @lettersDisplayArr[index] = " #{@userInput} "
            end
            
            displayLettersFound()
            
        end
        
        
        #check winner and ask
        #the user, they'd like to play again
        def winOrLose()
            if ((@lettersDisplayArr.to_s.downcase.eql? @randomWord) or (@lettersDisplayArr.include?(" _ ") == false))
                @foundWord = true 
                   
            end
            
            if @foundWord == true
                puts "YAY! You guessed the word!"
                playAgain()
            end

            if ((@numOfGuesses > 9) && (@foundWord == false))
                 puts "Sorry, you didn't find the word."
                 puts "The word was #{@randomWord}"
                 playAgain()   
        
            end
        end 
         
        #asks the player if they would like to play again
        def playAgain()
            puts "Would you like to play again? Yes (Y) or No (N)"
                 playAgain = $stdin.gets.chomp
                    if playAgain.downcase == "y" || playAgain.downcase == "yes"
                        playHangmanAgain = HangMan.new
                    elsif playAgain.downcase != "n" && playAgain.downcase != "no" && playAgain.downcase != "y" && playAgain.downcase != "yes"
                        puts "That's not an option. Please enter Yes (Y) or No (N)"
                        playAgain()
                    else
                        puts "Goodbye !"
                        @numOfGuesses = 11
                        @foundWord = true
                    end
       
        end


        # drawing hangman to the console
        def drawHangMan()

            puts "\n"

            if(@numOfGuesses > 2)
                puts "    xxxxxxxxxxxxx"
            else
                puts "\n"
            end

            if(@numOfGuesses > 3)
                puts "    x           x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 3)
                puts "    x           x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 4)
                puts "   xxx          x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 4)
                puts "  xxxxx         x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 4)
                puts "   xxx          x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 5)
                puts "    x           x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 7)
                puts "  x x x         x"
            elsif(@numOfGuesses > 6)
                puts " x  x           x"
            elsif(@numOfGuesses > 5)
                puts "    x           x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 5)
                puts "    x           x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 9)
                puts "   x x          x"
            elsif(@numOfGuesses > 8)
                puts "   x            x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 9)
                puts "   x x          x"
            elsif(@numOfGuesses > 8)
                puts "   x            x"
            elsif(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 1)
                puts "                x"
            else
                puts "\n"
            end

            if(@numOfGuesses > 0)
                puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxx"
            else
                puts "\n"
            end

            puts "\n"

        end



end
hangMan = HangMan.new





