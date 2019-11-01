#include <stdio.h>

int main(int argc, char ** argv) {

    char s,c,t,i=0;

    c = 1;
    s = 21;

    printf("there are 21 matchsticks on the table\n");
    printf("computer's first\n");

    while (s != 0) {
        if (c) {
            printf("computer's thinking\n");
            t = !((s - 1) % 4) ? 1 : (s - 1) % 4;

            printf("computer takes %d\n", t);
            // take or end
            if (c) { // if computer
                if (s - t <= 0) { //computer takes last
                    printf("game over\nthe winner is you\n");
                    s = 0;
                } else { //computer takes
                    s = s - t;
                }
            }
            else {
                if (s - t <= 0) { //you take last
                    s = 0;
                    printf("game over\n");
                    printf("the winner is computer\n");
                } else { // you take
                    s -= t;
                }
            }

            //your turn
            c = !c;

        } else {
            printf("it is your turn\n");
            int t;

            do {
                printf("you can take 1, 2 or 3!\n");
                printf("so how many sticks will you take?\n");
                scanf("%d", &t);
            } while (!(t == 1 || t == 2 || t == 3));

            // take or end
            if (c) { // if computer
                if (s - t <= 0) { //computer takes last
                    printf("game over\nthe winner is you\n");
                    s = 0;
                } else { //computer takes
                    s = s - t;
                }
            }
            else {
                if (s - t <= 0) { //you take last
                    s = 0;
                    printf("game over\n");
                    printf("the winner is computer\n");
                } else { // you take
                    s -= t;
                }
            }

            //computer turn
            c = !c;
        }

        //print sticks
        i = i & 0x0000;
        printf("there are %d matchstick(s) on the table\n", s);
        while (i++<s) { printf("|"); }
        printf("\n");
    }
    return 0;
}
