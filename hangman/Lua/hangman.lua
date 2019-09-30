local allWords = {}
local letters = {}

function load_words()
    local file = assert(io.open("resources/words.in", "r"))

    for word in file:lines() do
        table.insert(get_words_array(string.len(word)), word)
    end

    file:close()
end

function get_words_array(wordLength)
    local wordsArray = allWords[wordLength]
    wordsArray = type(wordsArray) == "table" and wordsArray or {}
    allWords[wordLength] = wordsArray
    return allWords[wordLength]
end 

function print_guess()
    local output = ""
    for _, v in ipairs(letters) do
        if v[2] == true then
            output = output .. " " .. v[1]
        else
            output = output .. " _"
        end
    end
    print("The word:" .. output)
end

function guess(guessed)
    local hit = false
    for _, v in ipairs(letters) do
        if v[1] == guessed then
            v[2] = true
            hit = true
        end
    end
    return hit
end

function has_guessed_all_letters()
    for _, v in ipairs(letters) do
        
        if v[2] == false then 
             return false
        end
    end

    return true
end

function print_hangman(mistakes)
    print()

    if mistakes > 2 then print("    xxxxxxxxxxxxx")
    else print() end

    if mistakes > 3 then print("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 3 then print("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 4 then print("   xxx          x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 4 then print("  xxxxx         x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 4 then print("   xxx          x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 5 then print("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 7 then print("  x x x         x")
    elseif mistakes > 6 then print ("  x x           x")
    elseif mistakes > 5 then print ("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 7 then print(" x  x  x        x")
    elseif mistakes > 6 then print (" x  x           x")
    elseif mistakes > 5 then print ("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 5 then print("    x           x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 9 then print("   x x          x")
    elseif mistakes > 8 then print ("   x            x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 9 then print(" x     x        x")
    elseif mistakes > 8 then print (" x              x")
    elseif mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 1 then print ("                x")
    else print() end

    if mistakes > 1 then print ("                x")
    else print() end

    print ("xxxxxxxxxxxxxxxxxxxxxxxxxxxx")
    print()
end

function play()
    load_words()

    print("Number of letters in the word?")
    local key = tonumber(io.read())

    local words = get_words_array(key)

    if words[1] == nil then
        print("Sorry, no words like that.")
        return
    end

    -- load a random word
    math.randomseed(os.time())
    local word = words[math.random(#words)]

    -- put word into table
    for c in word:gmatch(".") do
        table.insert(letters, {c , false})
    end

    -- play the game
    local mistakes = 0
    local done = false
    while not(done) do

        print("Guess a letter:")
        local guessedLetter = io.read():lower()
        
        if guess(guessedLetter) then
            print("Hit")
        else
            mistakes = mistakes + 1
            print("Missed, mistake " .. mistakes .. " out of 10")

            print_hangman(mistakes)
        end

        print_guess()

        if has_guessed_all_letters() then
            print("You won!")
            return
        end

        if mistakes >= 10 then
            print("You lost.")
            print("The word was: " .. word)
            return
        end

    end

end

play()
