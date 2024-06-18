#include <stdio.h>

int main()
{
    int a[42] = { 0 };
    int result = 0;
    int n;
    for (int i = 1; i <= 10; i++) {
        scanf("%d", &n);
        a[n % 42] += 1;
    }

    for (int i = 0; i < 42; i++) {
        if (a[i] != 0)
            result++;
    }

    printf("%d\n", result);


    return 0;
}