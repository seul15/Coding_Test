#include<iostream>
using namespace std;

int main() {
	int coin;
	cin >> coin;

	int ans = 0;
	while (coin > 0) {
		if (coin % 5 != 0) {
			ans++;
			coin -= 2;
		} // 2원 동전 추가
		else {
			ans += (coin / 5);
			coin = 0;
		}
	}

	if (coin < 0) cout << "-1" << "\n";
	else cout << ans << "\n";
}