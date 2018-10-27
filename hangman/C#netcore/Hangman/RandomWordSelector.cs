using System;
using System.Collections.Generic;
using System.Linq;

namespace Hangman
{
    class RandomWordSelector
    {
        public static string GetRandomWord(uint numberOfLetters)
        {
            string line;
            var candidateWords = new List<string>();
            using (var file = new System.IO.StreamReader(@"resources/words.in"))
            {
                while ((line = file.ReadLine()) != null)
                {
                    if (line.Length == numberOfLetters)
                    {
                        candidateWords.Add(line);
                    }
                }
            }
            if (!candidateWords.Any())
            {
                throw new ArgumentException($"There is no word with {numberOfLetters} letters");
            }

            var selectedWordIndex = new Random().Next(0, candidateWords.Count);
            return candidateWords[selectedWordIndex];
        }
    }
}