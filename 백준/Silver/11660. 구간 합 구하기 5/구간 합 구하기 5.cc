#include<iostream>
using namespace std;

long long dp[1024][1024] = {};

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int N, M;
	cin >> N >> M;

	int tmp;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> tmp;
			if (i == 0 && j == 0) dp[i][j] = tmp;
			else if (i == 0) dp[i][j] = dp[i][j - 1] + tmp;
			else if (j == 0) dp[i][j] = dp[i - 1][j] + tmp;
			else dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + tmp;
		}
	}

	int x1, y1, x2, y2;
	for (int i = 0; i < M; i++) {
		cin >> x1 >> y1 >> x2 >> y2;
		if (x1 == 1 && y1 == 1) cout<<dp[x2 - 1][y2 - 1]<<"\n";
		else if (x1 == 1) cout<<dp[x2 - 1][y2 - 1] - dp[x2 - 1][y1 - 2]<<"\n";
		else if (y1 == 1) cout<<dp[x2 - 1][y2 - 1] - dp[x1 - 2][y2 - 1]<<"\n";
		else cout << dp[x2 - 1][y2 - 1] - dp[x2-1][y1-2] - dp[x1 - 2][y2 - 1] + dp[x1-2][y1-2]<< "\n";
	}
}