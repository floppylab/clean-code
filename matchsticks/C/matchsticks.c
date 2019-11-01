#include <stdio.h>
#include <stdlib.h>

int main(int argc, char ** argv) {

    //p - contains remaining sticks count, computer/player turn and user input (sticks taken)
    char * p = (char *) malloc(4*sizeof(char));
    char * s = (char *) malloc(256*sizeof(char)); //user input characters

    *p = 0x15;
    *(p+1) = 1;

    printf("there are %d matchsticks on the table\ncomputer's first\n", *p);

    while (*p != 0) {
        if (p[1]) {
            printf("computer's thinking\n");
            p[2] = !((*p - 1) % 4) ? 1 : (*p - 1) % 4;

            printf("computer takes %d\n", p[2]);
            // take or end
            if (p[1]) { // if computer
                if (p[0] - p[2] <= 0) { //computer takes last
                    printf("game over\nthe winner is you\n");
                    p[0] = 0;
                } else { //computer takes
                    p[0] = p[0] - p[2];
                }
            }
            else {
                if (p[0] - p[2] <= 0) { //you take last
                    p[0] = 0;
                    printf("game over\n");
                    printf("the winner is computer\n");
                } else { // you take
                    p[0] -= p[2];
                }
            }

            //your turn
            p[1] = !p[1];

        } else {
            printf("it is your turn\n");

            do {
                printf("you can take 1, 2 or 3!\nso how many sticks will you take?\n");
                //handle invalid input
                scanf("%s", s);
                if (s[1] != '\0'){ p[2] = 0; }
                else { p[2] = s[0] - '0'; }
            } while (!(p[2] == 1 || p[2] == 2 || p[2] == 3));

            // take or end
            if (p[1]) { // if computer
                if (p[0] - p[2] <= 0) { //computer takes last
                    printf("game over\nthe winner is you\n");
                    p[0] = 0;
                } else { //computer takes
                    p[0] = p[0] - p[2];
                }
            }
            else {
                if (p[0] - p[2] <= 0) { //you take last
                    p[0] = 0;
                    printf("game over\n");
                    printf("the winner is computer\n");
                } else { // you take
                    p[0] -= p[2];
                }
            }

            //computer turn
            p[1] = !p[1];
        }

        //print sticks
        p[3] = *(p+3) & 0x00;
        printf("there are %d matchstick(s) on the table\n", *p);
        while ((*(p+3))++ < *p) { printf("|"); }
        printf("\n");
    }
    free(p);
    free(s);
    return 0;
}
