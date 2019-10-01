var c = true
var s = 21

function main(args) {

    console.log("there are 21 matchsticks on the table");
    console.log("computer's first");

    while (s != 0) {
        if (c) {
            console.log("computer's thinking")
            var r = (s - 1) % 4
            var t = (r == 0) ? 1 : r

            console.log("computer takes $t")
            takeOrEnd(t)
            c = !c

        } else {
            console.log("it is your turn")
            var t

            do {
                console.log("you can take 1, 2 or 3!")
                t = prompt("so how many sticks will you take?")
            } while (!(t == 1 || t == 2 || t == 3))

            takeOrEnd(t)
            c = !c
        }

        printSticks()
    }
}

function takeOrEnd(t) {
    if (s - t <= 0) {
        console.log("game over")
        console.log("the winner is " + ( (c) ? "you" : "computer"))
        s = 0
    } else {
        s -= t
    }
}

function printSticks() {
    console.log(`there are ${s} matchstick(s) on the table`)
    console.log("|".repeat(s))
}