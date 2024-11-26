#include<iostream>
using namespace std;

int main() {
	long long dp[1001] = {};
	int n;
	cin >> n;
	for (int i 
		= 1; i <= n; i++) {
		if (dp[i] == 0) {
			if (i == 1) dp[i] = 1 % 10007;
			else if (i == 2) dp[i] = 2 + dp[i - 1] % 10007;
			else dp[i] = (dp[i - 1] + 2* dp[i - 2]) % 10007;
		}
		else continue;
	}
	cout << dp[n] << "\n";
}