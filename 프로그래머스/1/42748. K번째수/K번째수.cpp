#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    int begin;
    int end;
    int target;
    vector<int> answer;
    vector<int> slice_num;
    for(auto& command : commands)
    {
        slice_num = array;
        begin = command[0] - 1;
        end = command[1];
        target = begin + command[2]-1;
        nth_element(slice_num.begin()+begin, slice_num.begin()+target, slice_num.begin()+end);
        answer.push_back(slice_num[target]);
    }
    return answer;
}