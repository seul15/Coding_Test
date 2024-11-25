#include<iostream>
using namespace std;

int main() {
	int n,t;
	cin >> t;
	long long dp[100] = {};
	for (int i = 0; i < t; i++) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			if (dp[i] != 0) continue;
			else if (i < 3) dp[i] = 1;
			else dp[i] = dp[i - 2] + dp[i - 3];
		}
		cout << dp[n - 1] << "\n";
	}
}