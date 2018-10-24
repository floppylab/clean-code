import sys
from random import randint
import keyboard

def zeroth():
    print()
    print()
    print()
    print()
    print()
    print()
    print()
    print()

def first():
    print()
    print()
    print()
    print()
    print()
    print()
    print()
    print("                    ________________")


def second():
    print()
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                    ________________")


def third():
    print("                            ___________")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                   ________________")


def fourth():
    print("                            ___________")
    print("                           |           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                   ________________")


def fifth():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                           |")
    print("                   ________________")


def sixth():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |           |")
    print("                           |           |")
    print("                           |")
    print("                           |")
    print("                   ________________")


def seventh():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |           |")
    print("                           |           |")
    print("                           |          /")
    print("                           |")
    print("                   ________________")


def eighth():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |           |")
    print("                           |           |")
    print("                           |          / \\")
    print("                           |")
    print("                   ________________")


def ninth():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |          \\|")
    print("                           |           |")
    print("                           |          / \\")
    print("                           |")
    print("                   ________________")


def tenth():
    print("                            ___________")
    print("                           |           |")
    print("                           |           O")
    print("                           |          \\|/")
    print("                           |           |")
    print("                           |          / \\")
    print("                           |")
    print("                   ________________")


F = open("resources/words.in")

words = F.readlines()
stages = {0: zeroth,
          1: first,
          2: second,
          3: third,
          4: fourth,
          5: fifth,
          6: sixth,
          7: seventh,
          8: eighth,
          9: ninth,
          10: tenth}


for i in range(len(words)):
    length = len(words[i])
    words[i] = words[i][0: length - 1]

wantPlay = True

while wantPlay:
    word = words[randint(0, len(words))].upper().strip()
    lettersFound = 0
    stage = 0
    found = {}
    guessed = []
    wrong = []

    for i in range(len(word)):
        found[word[i]] = False

    while lettersFound < len(word) and stage < 10:
        hint = ""
        for i in range(len(word)):
            if word[i] == ' ':
                hint += "   "
            else:
                if found[word[i]]:
                    hint += word[i] + ' '
                else:
                    hint += "_ "

        print(hint)

        print()
        toPrint = ""
        for letter in wrong:
            toPrint += letter + ' '
        print("Wrong letters:  " + toPrint)
        print()

        stages[stage]()

        isValid = False

        while not isValid:
            print("Your guess:  ")

            guess = input().upper()
            if len(guess) == 1:
                if ord(guess) >= 65 or ord(guess) <= 90:
                    if guess not in guessed:
                        isValid = True
                        if guess[0] in word:
                            found[guess[0]] = True
                            for letter in word:
                                if letter == guess[0]:
                                    lettersFound += 1
                        else:
                            wrong.append(guess)
                            stage += 1

                        guessed.append(guess)
                    else:
                        print("You've already guessed that letter")
                else:
                    print("Please enter a valid letter")
            else:
                print("Please only enter one letter")

        print(str(len(word)) + " " + str(lettersFound))

    hint = ""
    for i in range(len(word)):
        if word[i] == ' ':
            hint += "   "
        else:
            hint += word[i] + ' '

    print(hint)

    print()
    toPrint = ""
    for letter in wrong:
        toPrint += letter + ' '
    print("Wrong letters:  " + toPrint)
    print()

    stages[stage]()

    if stage == 10:
        print("You lose. Want to try again? <Y/N>")
        isValid = False
        while not isValid:
            ans = input().upper()
            if ans == "N":
                wantPlay = False
                isValid = True
            elif ans == "Y":
                wantPlay = True
                isValid = True
            else:
                print("Please enter Y/y or N/n")
    else:
        print("You win! Want to play again? <Y/N>")
        isValid = False
        while not isValid:
            ans = input().upper()
            if ans == "N":
                wantPlay = False
                isValid = True
            elif ans == "Y":
                wantPlay = True
                isValid = True
            else:
                print("Please enter Y/y or N/n")









