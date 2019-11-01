#include <stdio.h>

char c = 1;
int s = 21;

void takeOrEnd(int t) {
    if (s - t <= 0) {
        printf("game over\n");
        printf("the winner is %s\n",(c ? "you" : "computer"));
        s = 0;
    } else {
        s -= t;
    }
}

void printSticks() {
   int i = 0;
   printf("there are %d matchstick(s) on the table\n", s);
   while (i++<s) { printf("|"); }
   printf("\n");
}

int main(int argc, char ** argv) {

    int r,t;

    printf("there are 21 matchsticks on the table\n");
    printf("computer's first\n");

    while (s != 0) {
        if (c) {
            printf("computer's thinking\n");
            r = (s - 1) % 4;
            t = (r == 0) ? 1 : r;

            printf("computer takes %d\n", t);
            takeOrEnd(t);
            c = !c;

        } else {
            printf("it is your turn\n");
            int t;

            do {
                printf("you can take 1, 2 or 3!\n");
                printf("so how many sticks will you take?\n");
                scanf("%d", &t);
            } while (!(t == 1 || t == 2 || t == 3));

            takeOrEnd(t);
            c = !c;
        }

        printSticks();
    }
    return 0;
}
