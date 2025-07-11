#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    int answer = 0;

    if (a % 2 == 1 && b % 2 == 1) {
        answer = a * a + b * b;
    }
    else if ((a % 2 == 1 && b % 2 == 0) || (a % 2 == 0 && b % 2 == 1)) {
        answer = 2 * (a + b);
    }
    else {
        answer = abs(a - b); 
    }

    return answer;
}
