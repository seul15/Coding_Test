#include<iostream>
#include<queue>
using namespace std;

int point[1001][1001] = {};
bool visited[1001] = {};
int N,M;
int ans = 0;
queue<int> q;

void bfs(int n) {
	q.push(n);
	visited[n] = true;
	ans++;

	while (!q.empty()) {
		int now = q.front();
		q.pop();
		for (int i = 1; i <= N; i++) {
			if (point[now][i] == 1 && !visited[i]) {
				q.push(i);
				visited[i] = true;
			}
		}
	}
}

int main() {
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int u, v;
		cin >> u >> v;
		point[u][v] = 1;
		point[v][u] = 1;
	}

	for (int i = 1; i <= N; i++) {
		if (!visited[i]) bfs(i);
	}

	cout << ans << "\n";
}