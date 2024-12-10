#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	int n;
	cin >> n;

	vector<pair<int, int>> conf;

	int start, end;
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		conf.push_back(make_pair(end,start));
	}

	sort(conf.begin(), conf.end());// pair 첫번재 인수(끝나는 시간) 기준으로 오름차순 정렬

	int now_end = conf[0].first; // 기준이 되는 회의 종료 시간
	int ans = 1;
	for (int i = 1; i < n; i++) {
		if (conf[i].second >= now_end) { // 회의 종료 시간 이후에 시작하는 회의 찾기
			ans++;
			now_end = conf[i].first; // 회의 종료 시간 갱신
		}
	}

	cout << ans << "\n";
}