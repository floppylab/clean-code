const fsPromises = require("fs").promises;
const readlineSync = require("readline-sync");

async function main() {
  let words = await fsPromises
    .stat("resources/words.in")
    .then(() => {
      console.log("File exists!");
      return fsPromises.readFile("resources/words.in");
    })
    .then(content => {
      return content.toString().split("\n");
    })
    .catch(e => {
      console.log(e);
    });

  let wordsMap = await (async function(words) {
    let mapReturns = new Map();

    words.forEach(word => {
      const wordSize = word.length;
      if (!mapReturns.has(wordSize)) {
        mapReturns.set(wordSize, []);
      }

      let currentVal = mapReturns.get(wordSize);
      currentVal.push(word);
      mapReturns.set(wordSize, currentVal);
    });

    return mapReturns;
  })(words);

  let numLetters = parseInt(
    readlineSync.question("Number of letters in the word? ")
  );

  if (wordsMap.has(numLetters)) {
    let word = wordsMap.get(numLetters)[
      parseInt(Math.random() * wordsMap.get(numLetters).length)
    ];

    let v = new Array(word.length).fill(false);
    let e = 0;
    let done = true;

    while (e < 10) {
      done = await (async function() {
        let d = true;
        for (var i = 0; i < word.length; ++i) {
          if (!v[i]) {
            d = false;
          }
        }

        return d;
      })();

      if (done) {
        break;
      }

      let chr = readlineSync.question("Guess a letter: ");

      let hit = await (async function() {
        let hit = false;

        for (var i = 0; i < word.length; ++i) {
          if (word[i] == chr && !v[i]) {
            v[i] = true;
            hit = true;
          }
        }

        return hit;
      })();

      if (hit) {
        console.log("Hit!");
      } else {
        console.log(`Missed, mistake ${e + 1} out of 10`);
        ++e;

        console.log();
        if (e > 2) console.log("    xxxxxxxxxxxxx");
        else console.log();

        if (e > 3) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 3) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 4) console.log("   xxx          x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 4) console.log("  xxxxx         x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 4) console.log("   xxx          x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 5) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 7) console.log("  x x x         x");
        else if (e > 6) console.log("  x x           x");
        else if (e > 5) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 7) console.log(" x  x  x        x");
        else if (e > 6) console.log(" x  x           x");
        else if (e > 5) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 5) console.log("    x           x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 9) console.log("   x x          x");
        else if (e > 8) console.log("   x            x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 9) console.log(" x     x        x");
        else if (e > 8) console.log(" x              x");
        else if (e > 1) console.log("                x");
        else console.log();

        if (e > 1) console.log("                x");
        else console.log();

        if (e > 1) console.log("                x");
        else console.log();

        if (e > 0) console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        else console.log();
        console.log();
      }
      await (async function() {
        process.stdout.write("The word: ");

        for (var i = 0; i < word.length; ++i) {
          if (v[i]) {
            process.stdout.write(" " + word[i] + " ");
          } else {
            process.stdout.write(" _ ");
          }
        }
      })();

      console.log();
    }

    // printing final result
    if (done) {
      console.log("You won!");
    } else {
      console.log("You lost.");
      console.log("The word was: " + word);
    }
  } else {
    console.log("Sorry, no words like that.");
  }
}

main();
