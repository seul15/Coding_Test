#include<iostream>
using namespace std;

int memory[1000001] = {};

int main() {
	int x;
	cin >> x;

	for (int i = 1; i <= x; i++) {
		if (i * 3 <= x && memory[i * 3] == 0) memory[i * 3] = memory[i] + 1;
		else if (i * 3 <= x && memory[i * 3] != 0) memory[i * 3] = min(memory[i * 3], memory[i] + 1);

		if (i * 2 <= x && memory[i * 2] == 0) memory[i * 2] = memory[i] + 1;
		else if (i * 2 <= x && memory[i * 2] != 0) memory[i * 2] = min(memory[i * 2], memory[i] + 1);

		if (i + 1 <= x && memory[i + 1] == 0) memory[i+1] = memory[i] + 1;
		else if (i +1 <= x && memory[i+1] != 0) memory[i+1] = min(memory[i+1], memory[i] + 1);
	}

	cout << memory[x];
	return 0;
}