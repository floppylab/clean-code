using System;
using System.Collections.Generic;

namespace Hangman.Helpers
{
    public class SortFunctions
    {
        public Dictionary<int, List<string>> SortWordsByLength(List<string> w)
        {
            Dictionary<int, List<string>> d = new Dictionary<int, List<string>>();

            for (int i = 0; i < w.Count; i++)
            {
                if (!d.ContainsKey(w[i].Length))
                {
                    d.Add(w[i].Length, new List<string>());
                }
                d[w[i].Length].Add(w[i]);
            }

            return d;
        }
    }
}
