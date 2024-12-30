#include <iostream>
using namespace std;

int main() {
	int N;
	cin >> N;

	int ans = 1;
	while (N > ans) {
		N -= ans;
		ans++;
	}

	if (ans % 2 == 1) cout << ans + 1 - N << '/' << N << "\n";
	else cout << N << '/' << ans + 1 - N << "\n";
}