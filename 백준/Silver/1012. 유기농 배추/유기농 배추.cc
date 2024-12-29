#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;

int g[50][50] = {}; // 배추 위치 저장
bool visited[50][50] = {};
vector<pair<int, int>> direction = { make_pair(1,0),make_pair(-1,0),make_pair(0,1),make_pair(0,-1) };
int M, N, K;
int x, y;
int ans = 0;

void bfs() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (g[i][j] == 1 && visited[i][j] == false) {
				ans++;
				queue<pair<int, int>> q;
				q.push(make_pair(i, j));
				visited[i][j] = true;

				while (!q.empty()) {
					int now_x = q.front().second;
					int now_y = q.front().first;
					q.pop();

					for (int z = 0; z < 4; z++) {
						if (now_x + direction[z].second < 0 || now_x + direction[z].second >= M ||
							now_y + direction[z].first < 0 || now_y + direction[z].first >= N) continue;
						else if (g[now_y + direction[z].first][now_x + direction[z].second] == 1 &&
							visited[now_y + direction[z].first][now_x + direction[z].second] == false) {
							q.push(make_pair(now_y + direction[z].first, now_x + direction[z].second));
							visited[now_y + direction[z].first][now_x + direction[z].second] = true;
						}
					}
				}
			}
		}
	}
}

int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < 50; j++) {
			fill(g[j], g[j] + 50, 0);
			fill(visited[j], visited[j] + 50, false);
		}
		ans = 0;

		cin >> M >> N >> K;
		for (int j = 0; j < K; j++) {
			cin >> x >> y;
			g[y][x] = 1;
		}

		bfs();
		cout << ans << "\n";
	}
}