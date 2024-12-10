#include<iostream>
using namespace std;

int dp[1001][10];

int main() {
	int N;
	cin >> N;
	
	int ans = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < 10; j++) {
			if (i == 1 || j == 0) dp[i][j] = 1;
			else dp[i][j] = (dp[i][j-1] + dp[i - 1][j]) % 10007;

			if (i == N) ans += dp[i][j];
		}
	}

	cout << ans % 10007 << "\n";
}