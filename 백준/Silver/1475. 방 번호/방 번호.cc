#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	int a[10] = {};

	while (true) {
		a[n % 10]++;
		if (n / 10 == 0)break;
		n /= 10;
	}

	int num = 0;
	for (int i = 0; i < 10; i++) {
		if (i != 9 && i != 6) num = max(num, a[i]);
	}

	cout << max(num, (a[6] + a[9] + 1) / 2)<<"\n";
}