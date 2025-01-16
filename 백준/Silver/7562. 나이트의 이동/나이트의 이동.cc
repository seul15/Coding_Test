#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

int arr[301][301] = {};
bool visited[301][301] = {};
int dx[8] = {1,2,2,1,-1,-2,-2,-1};
int dy[8] = {2,1,-1,-2,-2,-1,1,2};
int I, sx, sy, ex, ey;

void bfs(int x,int y) {
	queue<pair<int, int>> q;
	q.push({ x,y });
	visited[x][y] = true;
	while (!q.empty()) {
		int a = q.front().first;
		int b = q.front().second;
		q.pop();

		for (int i = 0; i < 8; i++) {
			int na = a + dx[i];
			int nb = b + dy[i];
			if (na >= 0 && na < I && nb >= 0 && nb < I
				&& !visited[na][nb]) {
				q.push({ na,nb });
				visited[na][nb] = true;
				arr[na][nb] = arr[a][b] + 1;
				if (na == ex && nb == ey) {
					q = queue<pair<int,int>>();
					break;
				}
			}
		}
	}
}

int main() {
	int T;
	cin >> T;
	for (int i = 0; i < T; i++) {
		for (int j = 0; j < 301; j++) {
			fill(visited[j], visited[j] + 301, false);
			fill(arr[j], arr[j] + 301, 0);
		}
		cin >> I >> sx >> sy >> ex >> ey;

		bfs(sx, sy);

		cout << arr[ex][ey] << "\n";
	}
}