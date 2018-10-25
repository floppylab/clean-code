from random import randint

F = open("resources/words.in")

w = F.readlines()
d = {}

for i in range(len(w)):
    if len(w[i]) not in d:
        d[len(w[i])] = []

    d[len(w[i])].append(w[i])

print("Number of letters in the word:  ")
l = int(input())
print(str(l))

if l in d:
    word = d[l][randint(0, len(w[l]))]
    v = []
    for i in range(len(word)):
        v.append(False)

    e = 0
    done = True

    while e < 10:
        done = True

        for i in range(len(word)):
            if not v[i]:
                done = False

        if done:
            break

        print("Guess a letter:  ")

        char = input()[0]

        hit = False
        for i in range(len(word)):
            if word[i] == char and not v[i]:
                v[i] = True
                hit = True

        if hit:
            print("Hit!")

        else:
            print("Missed. Mistake " + str(e+1) + " out of 10")
            e += 1

            print()
            if e > 2:
                print("    xxxxxxxxxxxxx")
            elif e > 1:
                print("    x           x")
            else:
                print()

            if e > 3:
                print("    x           x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 4:
                print("   xxx          x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 4:
                print("  xxxxx         x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 4:
                print("   xxx          x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 5:
                print("    x           x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 7:
                print("  x x x         x")
            elif e > 6:
                print("  x x           x")

            if e > 7:
                print(" x  x  x        x")
            elif e > 6:
                print("  x  x          x")
            elif e > 5:
                print("    x           x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 5:
                print("    x           x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 9:
                print("   x x          x")
            elif e > 8:
                print("   x            x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 9:
                print(" x    x         x")
            elif e > 8:
                print(" x              x")
            elif e > 1:
                print("                x")
            else:
                print()

            if e > 1:
                print("                x")
            else:
                print()

            if e > 1:
                print("                x")
            else:
                print()

            if e > 0:
                print("xxxxxxxxxxxxxxxxxxxxxxxxxxx")
            else:
                print()

            print()

        print("The word:  ")
        hint = ""
        for i in range(len(word)):
            if v[i]:
                hint += " " + word[i] + " "
            else:
                hint += " _ "

        print(hint)
        print()

    if done:
        print("You won!")
    else:
        print("You lost.")
        print("The word was " + word)

else:
    print("Sorry, no words like that")
