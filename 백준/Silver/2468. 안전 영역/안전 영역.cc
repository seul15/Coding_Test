#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int area[101][101] = {};
bool visited[101][101] = {};
int dx[4] = {0,0,-1,1};
int dy[4] = { -1,1,0,0 };
int h = 0; // 물에 잠기는 높이
int safe = 0; // 안전 영역의 개수
int ans = 0; // 안전한 영역의 최대개수
int N;

void bfs() {
	queue<pair<int, int>> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (area[i][j] > h && visited[i][j] == false) {
				safe++;
				q.push({ i,j });
				visited[i][j] = true;
				while (!q.empty()) {
					int x = q.front().second;
					int y = q.front().first;
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							if (area[ny][nx] > h && visited[ny][nx] == false) {
								q.push({ ny,nx });
								visited[ny][nx] = true;
							}
						}
					}
				}
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> area[i][j];
			h = max(h, area[i][j]); // 최대 높이 구함
		}
	}
	
	while (h >= 0) {
		for (int i = 0; i < N; i++) {
			fill(visited[i], visited[i] + 101, false);
		}

		bfs();
		ans = max(ans, safe);
		
		safe = 0;
		h--;
	}

	cout << ans << "\n";
}