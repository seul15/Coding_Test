#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

vector<int> g[20001];
int visited[20001] = {};
int V, E;

void v_clear() {
	for (int i = 0; i < 20001; i++) {
		g[i].clear();
	}
	fill(visited, visited + 20001, 0);
}

bool bfs() {
	queue<int> q;
	for (int i = 1; i <= V; i++) {
		if (visited[i] == 0) {
			visited[i] = 1;
			q.push(i);
			while (!q.empty()) {
				int now = q.front();
				q.pop();

				for (int j = 0; j < g[now].size(); j++) {
					if (visited[g[now][j]] == 0) {
						if (visited[now] == 1)visited[g[now][j]] = -1;
						else visited[g[now][j]] = 1;
						q.push(g[now][j]);
					}
					else {
						if (visited[now] == visited[g[now][j]]) return false;
						else continue;
					}
				}
			}
		}
	}
	return true;
}

int main() {
	int K;
	cin >> K;
	for (int k = 0; k < K; k++) {
		v_clear(); // 초기화
		cin >> V >> E;
		for (int i = 0; i < E; i++) {
			int u, v;
			cin >> u >> v;
			g[u].push_back(v);
			g[v].push_back(u);
		}

		bool ans = bfs();

		cout << (ans ? "YES" : "NO") << "\n";
	}
}