#include <iostream>
#include <vector>
using namespace std;

int dp[100001], vis[100001];
int n, r, q;
vector<int> v[100001];

int go(int here) {
    vis[here] = 1;
    for (int i = 0; i < v[here].size(); i++) {
        int there = v[here][i];
        if (!vis[there]) {
            dp[here] += go(there);
        }
    }
    return dp[here];
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> r >> q;
    for (int i = 1; i <= n - 1; i++) {
        int x, y;
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }

    for (int i = 1; i <= n; i++) {
        dp[i] = 1;
    }
    go(r);

    while (q--) {
        int value;
        cin >> value;
        cout << dp[value] << '\n';
    }

    return 0;
}
