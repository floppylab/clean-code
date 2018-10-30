#include <fstream>
#include <iostream>
#include <map>
#include <random>
#include <sstream>
#include <string>
#include <vector>
#include <stdio.h>

int main(int argc, char** argv)
{
    std::vector<std::string> w;
    std::map<int, std::vector<std::string>> d;
    std::string line;

  
        std::fstream reader("./resources/words.in");

        // reading text file line by line
        while(std::getline(reader, line))
        {
            w.push_back(line);
        }

        // sorting words by length
        for (size_t i = 0; i < w.size(); i++)
        {
            if (d.find(w[i].size()) == d.end())
            {
                d[w[i].size()] = std::vector<std::string>();
            }
            d[w[i].size()].push_back(w[i]);
        }

        printf("Number of letters in the word? \n";
        int l;
        printf("%d\n", l);

        if (d.find(l) != d.end())
        {
            // Note: On windows when using mingw, this will always return the same pattern.
            // https://stackoverflow.com/questions/18880654/why-do-i-get-the-same-sequence-for-every-run-with-stdrandom-device-with-mingw
            // Use MSVC, Clang, or GCC on Linux to get around this.
            std::random_device rd;
            std::mt19937_64 gen(rd());

            std::uniform_int_distribution<int> rng(0, d[l].size());

            std::string word = d[l][rng(gen)];

            std::vector<bool> v(word.size());
            int e = 0;
            bool done = true;

            while (e < 10)
            {
                done = true;
                for (size_t i = 0; i < word.size(); ++i)
                {
                    if(!v[i])
                    {
                        done = false;
                    }
                }
                if (done)
                {
                    break;
                }

                printf("Guess a letter: "); 
                char chr;
                scanf("%c",char);

                // TODO check if previously entered.
                bool hit = false;
                for (size_t i = 0; i < word.size(); ++i)
                {
                    if (word[i] == chr && !v[i])
                    {
                        v[i] = true;
                        hit = true;
                    }
                }

                if (hit)
                {
                    printf("Hit! \n"); 
                }
                else
                {
                    printf("Missed, mistake ");
                    printf("%d+1",e); 
                    printf(" out of 10 \n"); 
                    ++e;

                    // drawing hangman
                    printf("\n"); 
                    if (e>2) printf("    xxxxxxxxxxxxx \n");  
                    else printf("\n"); 

                    if (e>3) printf("    x           x \n");  
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>3) printf("    x           x \n");
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>4) printf("   xxx          x \n"); 
                    else if (e > 1) printf("                x \n"); 
                    else printf("\n");

                    if(e>4) printf("  xxxxx         x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>4) printf("   xxx          x \n"); 
                    else if (e > 1) printf("                x \n"); 
                    else printf("\n");

                    if(e>5) printf("    x           x \n");
                    else if (e > 1) printf("                x \n"); 
                    else printf("\n");

                    if(e>7) printf("  x x x         x \n"); 
                    else if(e>6) printf("  x x           x \n");  
                    else if(e>5) printf("    x           x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>7) printf(" x  x  x        x \n");  
                    else if(e>6) printf(" x  x           x \n"); 
                    else if(e>5) printf("    x           x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>5) printf("    x           x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>9) printf("   x x          x \n");
                    else if(e>8) printf("   x            x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>9) printf(" x     x        x \n"); 
                    else if(e>8) printf(" x              x \n"); 
                    else if (e > 1) printf("                x \n");  
                    else printf("\n");

                    if(e>1) printf("                x \n");
                    else printf("\n");

                    if(e>1) printf("                x \n");  
                    else printf("\n");

                    if(e>0) printf"xxxxxxxxxxxxxxxxxxxxxxxxxxxx \n"); 
                    else printf("\n");
                    printf("\n");
                }

                printf("The word: "); 
                for (size_t i = 0; i < word.size(); ++i)
                {
                    if (v[i])
                    {
                        printf(" "); 
                        printf("%c",word[i]);
                        printf(" ");  
                    }
                    else
                    {
                        printf(" _ ");  
                    }
                }

                printf("\n\n");
            }

            // printing final result
            if (done)
            {
                printf("You won! \n"); 
            }
            else
            {
                printf("You lost. \n");  
                printf("The word was:  \n");
                printf("%c", word);  
                printf("\n");
            }
        }
        else
        {
            printf("Sorry, no words like that.\n"); 
        }
   
} 