#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;
int M, N;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int t[1001][1001] = {};
int visited[1001][1001] = {};
int ans = 0;
queue<pair<int, int>> q;


void bfs() {
	while (!q.empty()) {
		int x = q.front().second;
		int y = q.front().first;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && visited[ny][nx] == -1 && t[ny][nx] == 0) {
				q.push(make_pair(ny, nx));
				visited[ny][nx] = visited[y][x] + 1;
				ans = max(ans, visited[ny][nx]);
			}
		}
	}
}

int main() {
	cin >> M >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> t[i][j];
			visited[i][j] = -1; // -1로 초기화
			if (t[i][j] == 1) { 
				q.push(make_pair(i, j)); 
				visited[i][j]++;
			}
		}
	}

	bfs();

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (t[i][j] == 0 && visited[i][j] == -1) ans = -1;
		}
	}

	cout << ans << "\n";
}