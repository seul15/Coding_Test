#include<iostream>
#include<algorithm>
using namespace std;

long long max_dp[2][3] = {};
long long min_dp[2][3] = {};

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int n1, n2, n3;
		cin >> n1 >> n2 >> n3;
		if (i == 0) {
			max_dp[0][0] = n1;
			max_dp[0][1] = n2;
			max_dp[0][2] = n3;
			min_dp[0][0] = n1;
			min_dp[0][1] = n2;
			min_dp[0][2] = n3;
		}
		else {
			max_dp[1][0] = n1 + max(max_dp[0][0], max_dp[0][1]);
			max_dp[1][1] = n2 + max({ max_dp[0][0],max_dp[0][1],max_dp[0][2] });
			max_dp[1][2] = n3 + max(max_dp[0][1], max_dp[0][2]);
			min_dp[1][0] = n1 + min(min_dp[0][0], min_dp[0][1]);
			min_dp[1][1] = n2 + min({ min_dp[0][0],min_dp[0][1],min_dp[0][2] });
			min_dp[1][2] = n3 + min(min_dp[0][1], min_dp[0][2]);

			for (int i = 0; i < 3; i++) {
				max_dp[0][i] = max_dp[1][i];
				min_dp[0][i] = min_dp[1][i];
			}
		}
	}

	cout << max({ max_dp[0][0],max_dp[0][1],max_dp[0][2] }) << " " << min({ min_dp[0][0],min_dp[0][1],min_dp[0][2] }) << "\n";
}