#include<iostream>
#include<algorithm>
using namespace std;

bool selfn[10001] = {};

int main() {
	fill(selfn, selfn + 10001, false);

	for (int i = 1; i <= 10000; i++) {
		int temp1 = i;
		int temp2 = i;

		while (temp2 != 0) {
			temp1 = temp1 + (temp2 % 10);
			temp2 = temp2 / 10;
		}

		if (temp1 < 10001) selfn[temp1] = true;
	}

	for (int i = 1; i <= 10000; i++) {
		if (selfn[i] == false) cout << i << "\n";
	}
}