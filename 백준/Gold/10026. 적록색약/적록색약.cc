#include<iostream>
#include<queue>
using namespace std;

char screen[101][101] = {};
bool visited[101][101] = {};
bool visited2[101][101] = {}; // 적록색약의 경우
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
int N;
int ans = 0;
int ans2 = 0; // 적록색약의 경우

void bfs() {
	queue<pair<int, int>> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j] == false) {
				ans++;
				q.push({ i,j });
				while (!q.empty()) {
					int x = q.front().second;
					int y = q.front().first;
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx >= 0 && nx < N && ny >= 0 && ny < N 
							&& visited[ny][nx] == false && screen[y][x] == screen[ny][nx]) {
							q.push({ ny,nx });
							visited[ny][nx] = true;
						}
					}
				}
			}
		}
	}
}

void bfs2() {
	queue<pair<int, int>> q;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited2[i][j] == false) {
				ans2++;
				q.push({ i,j });
				while (!q.empty()) {
					int x = q.front().second;
					int y = q.front().first;
					q.pop();
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (screen[i][j] == 'R' || screen[i][j] == 'G') {
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited2[ny][nx] == false 
								&& (screen[ny][nx]=='R' || screen[ny][nx]=='G')) {
								q.push({ ny,nx });
								visited2[ny][nx] = true;
							}		
						}
						else if(nx >= 0 && nx < N&& ny >= 0 && ny < N
							&& visited2[ny][nx] == false && screen[y][x] == screen[ny][nx]) {
							q.push({ ny,nx });
							visited2[ny][nx] = true;
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
			cin >> screen[i][j];
		}
	}

	bfs();
	bfs2();

	cout << ans << " " << ans2 << "\n";
}