#include<iostream>
#include<vector>
using namespace std;

vector<int> g[101];
bool visited[101] = {};
int depth = 0;
int ans=1000;
int a, b;

void dfs(int n) {
	if (n == b) {
		ans = depth;
		return;
	}

	visited[n] = true;

	for (int i = 0; i < g[n].size(); i++) {
		if (!visited[g[n][i]]) {
			depth++;
			dfs(g[n][i]);
			depth--;
			visited[g[n][i]] = false;
		}
	}
}

int main() {
	int n, m;
	cin >> n >> a >> b >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		g[x].push_back(y);
		g[y].push_back(x);
	}

	dfs(a);

	if (ans == 1000) cout << "-1\n";
	else cout << ans << "\n";
}