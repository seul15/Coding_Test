#include<iostream>
#include<algorithm>
using namespace std;

long long dp[1000][1000] = {};
long long candy[1000][1000] = {};

int main() {
	int N, M;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) cin >> candy[i][j];
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (i == 0 && j == 0) dp[i][j] = candy[i][j];
			else if (i == 0) dp[i][j] = dp[i][j - 1] + candy[i][j];
			else if (j == 0) dp[i][j] = dp[i - 1][j] + candy[i][j];
			else dp[i][j] = max(dp[i][j - 1], max(dp[i - 1][j], dp[i - 1][j - 1])) + candy[i][j];
		}
	}
	cout << dp[N - 1][M - 1] << "\n";
}