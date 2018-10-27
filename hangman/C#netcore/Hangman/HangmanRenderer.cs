using System;
using System.Text.RegularExpressions;

namespace Hangman
{
    class HangmanRenderer
    {
        public void Render(int numberOfErrors)
        {
            if (numberOfErrors == 0)
            {
                return;
            }
            
            // Replace number to be drawn with x
            var hangman = Regex.Replace(HangmanCanva, $"[1-{(numberOfErrors == 10 ? "A" : numberOfErrors.ToString())}]", "x");
            // Replace number not to be drawn with space
            hangman = Regex.Replace(hangman, $"[{numberOfErrors+1}-A]", " ");
            Console.WriteLine(hangman);
        }

        string HangmanCanva = @"
    3333333333332
    4           2
    4           2
   555          2
  55555         2
   555          2
    6           2
  7 6 8         2
 7  6  8        2
    6           2
   9 A          2
 9     A        2
                2
                2
1111111111111111111111111111";
    }
}