using System.Collections.Generic;
using System.IO;

namespace Hangman.Helpers
{
    public class Reader
    {
        public List<string> ReadText(string wordsPath)
        {
            string line = string.Empty;
            List<string> w = new List<string>();

            using (StreamReader reader = new StreamReader(wordsPath))
            {
                while ((line = reader.ReadLine()) != null)
                {
                    w.Add(line);
                }

                return w;
            }
        }
    }
}
