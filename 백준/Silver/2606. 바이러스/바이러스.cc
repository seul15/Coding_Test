#include<iostream>
#include<queue>
using namespace std;

int ans = 0;
int N,M;
int g[101][101] = {}; // 경로 저장
bool visited[101] = {}; // 방문했는지 확인

void bfs(int n) {
	queue<int> q;
	q.push(n);
	visited[n] = true;

	while (!q.empty()) {
		n = q.front();
		q.pop();
	
		for (int i = 1; i <= N; i++) {
			if (g[n][i] == 1 && visited[i] == 0) {
				q.push(i);
				visited[i] = true;
				ans++;
			}
		}
	}

}


int main() {
	cin >> N >> M;

	for (int i = 0; i < M; i++) {
		int x, y;
		cin >> x >> y;
		g[x][y] = 1;
		g[y][x] = 1;
	}

	bfs(1);
	cout << ans << "\n";
}