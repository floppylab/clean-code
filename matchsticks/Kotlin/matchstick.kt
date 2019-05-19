package floppylab.matchstick

var c : Boolean = true
var s: Int = 21

fun main(args: Array<String>) {

    println("there are 21 matchsticks on the table")
    println("computer's first")

    while (s != 0) {
        if (c) {
            println("computer's thinking")
            var r = (s - 1) % 4
            var t = if (r == 0) 1 else r

            println("computer takes $t")
            takeOrEnd(t)
            c = !c

        } else {
            println("it is your turn")
            var t : Int

            do {
                println("you can take 1, 2 or 3!")
                println("so how many sticks will you take?")
                t = readLine()!!.toInt()
            } while (!(t == 1 || t == 2 || t == 3))

            takeOrEnd(t)
            c = !c
        }

        printSticks()
    }
}

fun takeOrEnd(t : Int) {
    if (s - t <= 0) {
        println("game over")
        println("the winner is " + (if (c) "you" else "computer"))
        s = 0
    } else {
        s -= t
    }
}

fun printSticks() {
    println("there are $s matchstick(s) on the table")
    println("|".repeat(s))
}