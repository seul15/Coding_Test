#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;

bool area[101][101] = {};
bool visited[101][101] = {};
int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };
int M, N, K;
int ans = 0;
vector<int> s;

void bfs() {
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!area[i][j]&&!visited[i][j]) {
				int di = 1;
				ans++;
				queue<pair<int, int>> q;
				q.push({ i,j });
				visited[i][j] = true;
				while (!q.empty()) {
					int x = q.front().second;
					int y = q.front().first;
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							if (!area[ny][nx] && !visited[ny][nx]) {
								q.push({ ny,nx });
								visited[ny][nx] = true;
								di++;
							}
						}
					}
				}
				s.push_back(di);
			}
		}
	}
}

int main() {
	cin >> M >> N >> K;
	for (int i = 0; i < K; i++) {
		int y1, x1, y2, x2;
		cin >> x1 >> y1 >> x2 >> y2;

		for (int j = y1; j < y2; j++) {
			for (int k = x1; k < x2; k++) {
				area[j][k] = true;
			}
		}	
	}

	bfs();

	sort(s.begin(), s.end());

	cout << ans << "\n";
	for (int i = 0; i < s.size(); i++) {
		cout << s[i] << " ";
	}
}