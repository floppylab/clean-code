using System;
using System.Text;

namespace Hangman
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(@"Hangman game
Number of letters in the word?");

            var numberOfLettersString = Console.ReadLine();

            var numberOfLetters = Convert.ToUInt32(numberOfLettersString);
            var word = RandomWordSelector.GetRandomWord(numberOfLetters);
            var revealedWord = new String('?', (int)numberOfLetters);
            var letterFound = string.Empty;
            var numberOfErrors = 0;
            var hangmanRenderer = new HangmanRenderer();

            while (numberOfErrors < 10)
            {
                Console.WriteLine("Guess a letter: ");
                var letter = Console.ReadKey();
                Console.WriteLine();

                if (word.Contains(letter.KeyChar) && !revealedWord.Contains(letter.KeyChar))
                {
                    for(int i = 0;i < word.Length;i++)
                    {
                        if (word[i].Equals(letter.KeyChar))
                        {
                            var sb = new StringBuilder(revealedWord);
                            sb[i] = letter.KeyChar;
                            revealedWord = sb.ToString();
                        }
                    }

                    if (word.Equals(revealedWord))
                    {
                        Console.WriteLine($"Congratulations, you found the word {word}");
                        Environment.Exit(0);
                    }
                }
                else
                {
                    Console.WriteLine($"Missed, mistake {++numberOfErrors} out of 10");
                }

                Console.WriteLine(revealedWord);
                hangmanRenderer.Render(numberOfErrors);
            }

            Console.WriteLine("Game over!");
            Console.WriteLine($"It was: {word}");
        }
    }
}
