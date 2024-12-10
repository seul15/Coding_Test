#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	long long N;
	cin >> N;

	vector<long long> weight;
	int tmp;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		weight.push_back(tmp);
	}

	sort(weight.begin(), weight.end());

	long long ans = weight[N - 1];
	for (int i = 0; i < N-1; i++)  ans = max(ans, weight[i] * (N - i));
	cout << ans << "\n";
}