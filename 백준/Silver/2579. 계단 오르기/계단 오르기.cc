#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	long long stair[301];
	long long dp[301] = {};

	for (int i = 1; i <= n; i++) cin >> stair[i];

	for (int i = 1; i <= n; i++) {
		if (i == 1) dp[1] = stair[1];
		else if (i == 2)dp[2] = stair[2] + stair[1];
		else if (i == 3) dp[3] = stair[3] + max(stair[2], stair[1]);
		else dp[i] = stair[i] + max(dp[i-2],dp[i-3]+stair[i-1]);
	}

	cout << dp[n] << "\n";
}