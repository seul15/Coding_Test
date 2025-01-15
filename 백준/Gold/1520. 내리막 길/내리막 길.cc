#include<iostream>
#include<algorithm>
using namespace std;

int h[500][500] = {};
int dp[500][500] = {};
int M, N;
int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };

int dfs(int x,int y) {
	if (x == 0 && y == 0) return 1;
	if (dp[x][y] != -1) return dp[x][y];

	dp[x][y] = 0; // 지나감
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];
		if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
			if (h[x][y] < h[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
	}
	return dp[x][y];
}

int main() {
	for (int i = 0; i < 500; i++) {
		fill(dp[i], dp[i] + 500, -1);
	}

	cin >> M >> N;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			cin >> h[i][j];
		}
	}

	int ans = dfs(M-1, N-1);

	cout << ans << "\n";
}