#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int a[51][51] = {};
bool visited[51][51] = {};
int w, h;
int ans = 0;
int dx[8] = { 0,0,-1,1,1,1,-1,-1 };
int dy[8] = {1,-1,0,0,1,-1,-1,1};

void bfs() {
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			if (a[i][j] == 1 && visited[i][j] == false) {
				ans++;
				queue<pair<int, int>> q;
				q.push(make_pair(i, j));
				visited[i][j] = true;
				while (!q.empty()) {
					int x = q.front().second;
					int y = q.front().first;
					q.pop();
					for (int k = 0; k < 8; k++) {
						int now_x = x + dx[k];
						int now_y = y + dy[k];

						if (now_x >= 0 && now_x < w && now_y >= 0 && now_y < h) {
							if (a[now_y][now_x] == 1 && visited[now_y][now_x] == false) {
								q.push(make_pair(now_y, now_x));
								visited[now_y][now_x] = true;
							}
						}
					}
				}
			}
		}
	}
}

int main() {
	while(1) {
		for (int j = 0; j < 51; j++) {
			fill(a[j], a[j] + 51, 0);
			fill(visited[j], visited[j] + 51, false);
		}
		ans = 0;
		cin >> w >> h;
		if (w == 0 && h == 0) break;
		for (int j = 0; j < h; j++) {
			for (int k = 0; k < w; k++) cin >> a[j][k];
		}
		bfs();

		cout << ans << "\n";
	}
}