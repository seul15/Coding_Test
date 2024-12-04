#include<iostream>
#include<string>
using namespace std;

int main() {
	string word;
	getline(cin, word);
	int ans = 1;

	for (int i = 0; i < word.length(); i++) {
		if (word.length() == 1 && (char)word[i] == 32) ans = 0;
		else if (i == 0 && (char)word[i] == 32) continue;
		else if (i == word.length() - 1 && (char)word[i] == 32) continue;
		else if ((char)word[i] == 32) ans++;
	}

	cout << ans << "\n";
}