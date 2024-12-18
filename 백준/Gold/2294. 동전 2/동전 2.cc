#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int dp[10001] = {};

int main() {
	int n, k;
	cin >> n >> k;

	vector<int> value;
	int temp = 0;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		value.push_back(temp);
	}

	sort(value.begin(), value.end()); // 오름차순 정렬

	fill(dp, dp + 10001, -1);

	for (int i = 1; i <= k; i++) {
		int coin = -1;
		for (int j = 0; j < n; j++) {
			if (i < value[j]) break; // 코인 가치가 더 클 경우
			else if (i - value[j] == 0) { // 코인 가치와 원하는 가치가 같을때 -> 1개만 사용
				coin = 1;
				break;
			}
			else if (dp[i - value[j]] == -1) continue; 
			else if (coin == -1) coin = 1 + dp[i - value[j]]; // i 일때 필요한 코인의 개수는 1(코인 가치) + (원하는 가치 - 코인 가치)의 최소 동전 개수
			else coin = min(coin, 1 + dp[i - value[j]]);
		}
		dp[i] = coin;
	}

	cout << dp[k] << "\n";
}