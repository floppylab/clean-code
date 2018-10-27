import java.io.File
import java.io.InputStream
import java.util.concurrent.ThreadLocalRandom
import java.util.Scanner

fun main(args: Array<String>) {
    val w = mutableListOf<String>()
    val d = hashMapOf<Int, MutableList<String>>()
    val inputStream: InputStream = File("resources/words.in").inputStream()

    try {
        inputStream.bufferedReader().useLines { lines -> lines.forEach { w.add(it.trim())} }

        for(e in w) {
            if(!d.containsKey(e.length)) {
                d.put(e.length, mutableListOf())
            }
            d.get(e.length)!!.add(e)
        }

        print("Number of letters in the word? ")

        val l = readLine()!!.toInt()
        
        if(d.containsKey(l)) {
            val word = d.get(l)!!.get(ThreadLocalRandom.current().nextInt(0, d.get(l)!!.size))

            val v = BooleanArray(l)
            var e = 0
            var done = true

            while(e < 10) {
                done = true
                for (bool_val in v) {
                    if (!bool_val) {
                        done = false
                    }
                }
                if (done) {
                    break
                }

                print("Guess a letter: ")

                val chr = Scanner(System.`in`).nextLine().get(0)

                var hit = false

                for(i in 0..(word.length-1)) {
                    if(word.get(i) == chr && !v[i]) {
                        v[i] = true
                        hit = true
                    }
                }

                if (hit) {
                    println("Hit!")
                } else {
                    println("Missed, mistake #${e+1} out of 10")
                    
                    ++e

                    // drawing hangman
                    println()
                    if(e > 2) println("    xxxxxxxxxxxxx")
                    else println()

                    if(e > 3) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e > 3) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>4) println("   xxx          x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>4) println("  xxxxx         x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>4) println("   xxx          x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>5) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>7) println("  x x x         x")
                    else if(e>6) println("  x x           x")
                    else if(e>5) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>7) println(" x  x  x        x")
                    else if(e>6) println(" x  x           x")
                    else if(e>5) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>5) println("    x           x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>9) println("   x x          x")
                    else if(e>8) println("   x            x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>9) println(" x     x        x")
                    else if(e>8) println(" x              x")
                    else if (e > 1) println("                x")
                    else println()

                    if(e>1) println("                x")
                    else println()

                    if(e>1) println("                x")
                    else println()

                    if(e>0) println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx")
                    else println()
                    println()

                }
                print("The word: ")

                for(i in 0..(word.length-1)) {
                    if (v[i]) {
                        print(" " + word.get(i)+ " ")
                    } else {
                        print(" _ ")
                    }
                }

                println("\n")
            }

            // printing final result
            if (done) {
                println("You won!")
            } else {
                println("You lost.")
                println("The word was: ${word}\n")
            }

        } else {
            println("Sorry, no words like that.")
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}