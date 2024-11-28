#include<iostream>
using namespace std;

int main() {
	int N;
	cin >> N;
	long long dp[100][10] = {};
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 10; j++) {
			if (i == 0){
				if (j == 0) dp[0][0] = 0;
				else dp[0][j] = 1;
			}
			else {
				if (j == 0) dp[i][j] = dp[i - 1][1] % 1000000000;
				else if (j == 9) dp[i][j] = dp[i - 1][8] % 1000000000;
				else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1] % 1000000000;
			}
		}
	}
	long long ans = 0;
	for (int i = 0; i < 10; i++) {
		ans += dp[N - 1][i];
		//if (i != 0 && i != 2 && i != 7 && i != 9) ans += dp[N - 1][i];
	}
	cout << ans % 1000000000 << "\n";
}