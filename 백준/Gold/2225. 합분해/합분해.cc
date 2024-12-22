#include<iostream>
#include<algorithm>
using namespace std;

long long dp[201][201] = {};

long long f(int n, int k) {
	if (k == 1) return dp[n][k] = 1;
	if (dp[n][k] != 0) return dp[n][k];
	else {
		for (int i = 0; i <= n; i++) {
			dp[n][k] += f(n - i, k - 1);
			dp[n][k] %= 1000000000;
		}
		return dp[n][k];
	}
}

int main() {
	int n, k;
	cin >> n >> k;
	cout << f(n, k) << "\n";
}