#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, int>> A;
long long dp[100][100001] = {};

int main() {
	int N, K;
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		pair<int, int> item;
		cin >> item.first >> item.second;
		A.push_back(item);
	}
	
	for (int i = 0; i <N; i++) {
		for (int j = 1; j <= K; j++) {
			if (i == 0) {
				if (j < A[i].first) continue;
				else dp[i][j] = A[i].second;
			}
			else {
				if (j - A[i].first < 0) dp[i][j] = dp[i - 1][j];
				else dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - A[i].first] + A[i].second);
			}
		}
	}
	cout << dp[N - 1][K] << "\n";
}