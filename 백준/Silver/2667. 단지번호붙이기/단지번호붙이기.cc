#include<iostream>
#include<queue>
#include<vector>
#include<algorithm>
using namespace std;

int N;
vector<int> building;
int cnt = 0;
int b[25][25] = {};
bool visited[25][25] = {};

void bfs() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (b[i][j] == 1 && visited[i][j] == false) {
				cnt=0;
				queue<pair<int,int>> q;
				q.push(make_pair(i, j));
				visited[i][j] = true;
				while (!q.empty()) {
					int now_x = q.front().second;
					int now_y = q.front().first;
					q.pop();
					cnt++;
					if (now_y-1 >= 0 && now_y-1 < N &&
						b[now_y - 1][now_x] == 1 && visited[now_y - 1][now_x] == false) {
						q.push(make_pair(now_y - 1, now_x));
						visited[now_y - 1][now_x] = true;
					}
					if (now_y + 1 >= 0 && now_y+1 < N &&
						b[now_y + 1][now_x] == 1 && visited[now_y + 1][now_x] == false) {
						q.push(make_pair(now_y + 1, now_x));
						visited[now_y + 1][now_x] = true;
					}
					if (now_x - 1 >= 0 && now_x-1 < N &&
						b[now_y][now_x-1] == 1 && visited[now_y][now_x-1] == false) {
						q.push(make_pair(now_y, now_x-1));
						visited[now_y][now_x-1] = true;
					}
					if (now_x + 1 >= 0 && now_x+1 < N &&
						b[now_y][now_x+1] == 1 && visited[now_y][now_x+1] == false) {
						q.push(make_pair(now_y, now_x+1));
						visited[now_y][now_x+1] = true;
					}
				}
			}
			if (cnt != 0) {
				building.push_back(cnt);
				cnt = 0;
			}
		}
	}
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			scanf("%1d", &b[i][j]);
		}
	}

	bfs();

	sort(building.begin(), building.end());
	cout << building.size() << "\n";
	for (int i = 0; i < building.size(); i++) {
		cout << building[i] << "\n";
	}
}