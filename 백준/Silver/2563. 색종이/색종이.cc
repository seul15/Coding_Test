#include<iostream>
using namespace std;

int arr[100][100] = {};
int main() {
	int n;
	int cnt = 0;
	cin >> n;
	while (n--) {
		int x, y;
		cin >> x >> y;
		for (int i = y; i < y + 10; i++) {
			for (int j = x; j < x + 10; j++) {
				if (!arr[i][j]) {
					cnt++;
					arr[i][j] = 1;
				}
			}
		}
	}

	cout << cnt << "\n";
}