#include<iostream>
#include<algorithm>
using namespace std;

char board[21][21] = {};
bool visited[26] = {};
int dx[4] = { 0,0,-1,1 };
int dy[4] = { -1,1,0,0 };
int R, C;
int ans = 0;

void dfs(int y, int x, int depth) {
	ans = max(ans, depth);
	
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
			if (visited[board[ny][nx] - 'A'] == false) {
				visited[board[ny][nx] - 'A'] = true;
				dfs(ny, nx, depth+1);
				visited[board[ny][nx] - 'A'] = false;
			}
		}
	}
}

int main() {
	cin >> R >> C;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++) cin >> board[i][j];
	}

	visited[board[0][0] - 'A'] = true;
	dfs(0, 0, 1);

	cout << ans << "\n";
}