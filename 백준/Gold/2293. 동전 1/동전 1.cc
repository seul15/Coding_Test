#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

long long dp[10001] = {};

int main() {
	int n, k;
	cin >> n >> k;

	vector<int>value;
	int tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		value.push_back(tmp);
	}

	sort(value.begin(), value.end(), less<int>());

	for (int i = 0; i < n; i++) {
		for (int j = value[i]; j <= k; j++) {
			if (j == value[i]) dp[j]++;
			else dp[j] += dp[j - value[i]];
		}
	}

	cout << dp[k] << "\n";
}