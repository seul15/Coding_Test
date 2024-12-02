#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, int>> sch;
long long dp[15] = {};

int main() {
	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		pair<int, int> t;
		cin >> t.first >> t.second;
		sch.push_back(t);
	}
	long long tmp = 0; // i번째 이전에 최대 가치를 담는 변수
	for (int i = 0; i < N; i++) {
		// 상담 기간이 퇴사 후까지 이어지는 경우
		if (i + sch[i].first - 1 >= N) {
			tmp = max(tmp, dp[i]);
			continue;
		}
		else if (i == 0) dp[i + sch[i].first - 1] = sch[i].second;
		// 기존의 값과 현재 이전 최대 가치 + 오늘 일하는 가치 중 최대값을 넣음 
		else dp[i + sch[i].first - 1] = max(dp[i + sch[i].first - 1], tmp + sch[i].second);

		tmp = max(tmp, dp[i]);
	}

	long long ans = 0;
	for (int i = 0; i < N; i++) {
		ans = max(ans, dp[i]);
	}

	cout << ans << "\n";
}