#include <iostream>
using namespace std;

bool c = true;
int s = 21;

void takeOrEnd(int t) {
    if (s - t <= 0) {
        cout << "game over" << endl;
        cout <<  "the winner is " +  (string) (c ? "you" : "computer") << endl;
        s = 0;
    } else {
        s -= t;
    }
}

void printSticks() {
  cout << "there are " + to_string(s) +  " matchstick(s) on the table" << endl;
   cout << string(s, '|') <<endl;
}

int  main() {

    cout << "there are 21 matchsticks on the table" << endl;
    cout << "computer's first"<< endl;

    while (s != 0) {
        if (c) {
            cout << "computer's thinking" << endl;
            int r = (s - 1) % 4;
            int t = (r == 0) ? 1 : r;

            cout << "computer takes $t" << endl;
            takeOrEnd(t);
            c = !c;

        } else {
            cout << "it is your turn" << endl;
            int t;

            do {
                cout << "you can take 1, 2 or 3!" << endl;
                cout <<  "so how many sticks will you take?" << endl;
                cin >> t;
            } while (!(t == 1 || t == 2 || t == 3));

            takeOrEnd(t);
            c = !c;
        }

        printSticks();
    }
    return 0;
}
