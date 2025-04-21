#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;
    vector<int> coords(N);
    for (int i = 0; i < N; i++) {
        cin >> coords[i];
    }

    vector<int> sorted = coords;
    sort(sorted.begin(), sorted.end());
    sorted.erase(unique(sorted.begin(), sorted.end()), sorted.end());

    map<int, int> compressed;
    for (int i = 0; i < sorted.size(); i++) {
        compressed[sorted[i]] = i;
    }

    for (int i = 0; i < N; i++) {
        cout << compressed[coords[i]] << " ";
    }

    return 0;
}
