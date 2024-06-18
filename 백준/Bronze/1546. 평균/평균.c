#include <stdio.h>

int main()
{
        int Count, b=0, arNums[1000]={0,};
        double result;

        scanf("%d", &Count);
        for(int i=0; i<Count; i++){
                scanf("%d", &arNums[i]);
                if(b < arNums[i]){
                        b=arNums[i];
                }
        }

        for(int i=0; i<Count; i++){
                result+=arNums[i];
        }
        result= result/Count/b*100;
        printf("%lf\n", result);
}