#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    // 열 이름을 인덱스로 매핑
    unordered_map<string, int> col = {
        {"code", 0},
        {"date", 1},
        {"maximum", 2},
        {"remain", 3}
    };
    
    int ext_idx = col[ext];
    int sort_idx = col[sort_by];

    vector<vector<int>> filtered;

    // 조건에 맞는 데이터 필터링
    for (auto& row : data) {
        if (row[ext_idx] < val_ext) {
            filtered.push_back(row);
        }
    }

    sort(filtered.begin(), filtered.end(), [sort_idx](const vector<int>& a, const vector<int>& b) {
        return a[sort_idx] < b[sort_idx];
    });

    return filtered;
}
