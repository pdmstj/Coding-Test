#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    
    unordered_map<char, int> alphabet;
    
    for(int i = 0; i < s.size(); i++)
    {
        char cur = s[i];
        
        if(alphabet.find(cur) == alphabet.end())
        {
            // 처음 나오는 경우
            answer.push_back(-1);
            alphabet.insert(pair<char, int>(cur, i));
        }
        else
        {
            // 이전에 나왔던 경우
            answer.push_back(i - alphabet[cur]);
            alphabet[cur] = i;            
        }
    }
    
    return answer;
}