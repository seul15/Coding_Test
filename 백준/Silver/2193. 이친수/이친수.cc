#include<iostream>
using namespace std;

int main() {
	int N;
	cin >> N;
	long long dp[91] = {};
	for (int i = 1; i <= N; i++) {
		if (i == 1 || i == 2) dp[i] = 1;
		else dp[i] = dp[i - 1] + dp[i - 2];
	}
	cout << dp[N] << "\n";
}