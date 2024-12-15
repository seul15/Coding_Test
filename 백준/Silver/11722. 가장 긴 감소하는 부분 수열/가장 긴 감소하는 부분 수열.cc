#include<iostream>
#include<algorithm>
using namespace std;

int dp[1001];
int A[1000];

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];

	fill(dp, dp + 1001, 1);

	int ans = 1;
	for (int i = N; i > 0; i--) {
		for (int j = N; j > i; j--) {
			if (A[j - 1] < A[i - 1] && dp[i] < dp[j] + 1) {
				dp[i] = dp[j] + 1;
				ans = max(ans, dp[i]);
			}
		}
	}

	cout << ans << "\n";
}