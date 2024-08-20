#include <string>
#include <vector>
#include <iostream>
using namespace std;

int GCD(int a, int b) {
    while (b > 0) {
        int tmp = b;
        b = a % b;
        a = tmp;
    }
    
    return a;
}

int LCM(int a, int b) {
    return a * b / GCD(a, b);
}

int solution(vector<int> arr) {
    int lcm;
    
    for(int i = 1; i < arr.size(); ++i) {
        if (i == 1) {
            lcm = LCM(arr[0], arr[1]);
            
            continue;
        }
        
        lcm = LCM(lcm, arr[i]);
    }
    
    return lcm;
}
