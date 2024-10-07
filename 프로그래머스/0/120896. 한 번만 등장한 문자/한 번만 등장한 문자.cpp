#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

string solution(string s) {
    map<char, int> charCount;
 
    for (char c : s) {
        charCount[c]++;
    }
    
    string answer = "";

    for (const auto& pair : charCount) {
        if (pair.second == 1) {
            answer += pair.first;
        }
    }

    sort(answer.begin(), answer.end());
    
    return answer;
}
