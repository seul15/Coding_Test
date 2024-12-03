#include<iostream>
using namespace std;

long long dp[1000001] = {};

int main() {
	int N;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		if (i == 1) dp[1] = 1;
		else if (i == 2) dp[2] = 2;
		else dp[i] = (dp[i - 1] + dp[i - 2])%15746;
	}
	cout << dp[N] << "\n";
}