#include<iostream>
using namespace std; 

long long dp[1001][1001];

long long pa(int n, int k) {
	if (dp[n][k] != -1) return dp[n][k] % 10007;

	if (n - k == 1 || k == 1) return dp[n][k] = n;
	else if (k == 0 || n == k) return dp[n][k] = 1;

	return dp[n][k] = (pa(n - 1, k - 1) + pa(n - 1, k)) % 10007;
}

int main() {
	for (int i = 0; i < 1001; i++) {
		fill(dp[i], dp[i] + 1001, -1);
	}
	int N, K;
	cin >> N >> K;

	cout << pa(N, K) << "\n";
	return 0;
}