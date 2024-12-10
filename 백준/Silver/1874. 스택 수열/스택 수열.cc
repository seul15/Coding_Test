#include<iostream>
#include<stack>
#include<string>
#include<vector>
using namespace std;

int main() {
	stack<int> S;
	vector<string> ans;
	int n;
	cin >> n;

	int tmp;
	int now = 1; // stack에 들어갈 수
	bool p = true; // 불가능한 경우를 판단하기 위해 
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		while (now <= tmp) { // stack에 들어가야할 수 보다 클 경우 계속 push로 넣어줌
			S.push(now);
			now++;
			ans.push_back("+");
		}
		if (S.top() == tmp) {
			S.pop();
			ans.push_back("-");
		}
		else {
			p = false;
			break;
		}
	}
	if (p == false) cout << "NO" << "\n";
	else for (int i = 0; i < ans.size(); i++) cout << ans[i] << "\n";
}