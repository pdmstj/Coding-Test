#include <string>
#include <vector>


using namespace std;

bool solution(string s) {

    bool answer = true;

    if(s.size() != 4 && s.size() != 6) return false;  

    for(char c : s)

    {        

        if(!isdigit(c)) return false; // 각 문자가 숫자가 아닌 경우 false리턴

    }

    return answer;

}