#include <fstream>
#include <iostream>
#include <map>
#include <random>
#include <sstream>
#include <string>
#include <vector>

int main(int argc, char** argv)
{
    std::vector<std::string> w;
    std::map<int, std::vector<std::string>> d;
    std::string line;

    try
    {
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

        std::cout << "Number of letters in the word? ";
        int l;
        std::cin >> l;

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

                std::cout << "Guess a letter: ";
                char chr;
                std::cin >> chr;

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
                    std::cout << "Hit!" << std::endl;
                }
                else
                {
                    std::cout << "Missed, mistake " << e + 1 << " out of " << 10 << std::endl;
                    ++e;

                    // drawing hangman
                    std::cout << std::endl;
                    if (e>2) std::cout << "    xxxxxxxxxxxxx" << std::endl;
                    else std::cout << std::endl;

                    if (e>3) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>3) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>4) std::cout << "   xxx          x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>4) std::cout << "  xxxxx         x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>4) std::cout << "   xxx          x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>5) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>7) std::cout << "  x x x         x" << std::endl;
                    else if(e>6) std::cout << "  x x           x" << std::endl;
                    else if(e>5) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>7) std::cout << " x  x  x        x" << std::endl;
                    else if(e>6) std::cout << " x  x           x" << std::endl;
                    else if(e>5) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>5) std::cout << "    x           x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>9) std::cout << "   x x          x" << std::endl;
                    else if(e>8) std::cout << "   x            x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>9) std::cout << " x     x        x" << std::endl;
                    else if(e>8) std::cout << " x              x" << std::endl;
                    else if (e > 1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>1) std::cout << "                x" << std::endl;
                    else std::cout << std::endl;

                    if(e>0) std::cout << "xxxxxxxxxxxxxxxxxxxxxxxxxxxx" << std::endl;
                    else std::cout << std::endl;
                    std::cout << std::endl;
                }

                std::cout << "The word: ";
                for (size_t i = 0; i < word.size(); ++i)
                {
                    if (v[i])
                    {
                        std::cout << " " << word[i] << " ";
                    }
                    else
                    {
                        std::cout << " _ ";
                    }
                }

                std::cout << std::endl << std::endl;
            }

            // printing final result
            if (done)
            {
                std::cout << "You won !!!! " << std::endl;
            }
            else
            {
                std::cout << "You lost." << std::endl;
                std::cout << "The word was: " << word << std::endl;
            }
        }
        else
        {
            std::cout << "Sorry, no words like that." << std::endl;
        }
    }
    catch(const std::exception &e )
    {
        // TODO nice exception catching.
        std::cout << e.what() << std::endl;
    }
} 
