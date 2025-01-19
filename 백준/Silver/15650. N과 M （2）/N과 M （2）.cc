#include<iostream>
using namespace std;

int arr[9] = {};
int N, M;

void dfs(int k,int num) {
	if (k == M + 1) {
		for (int i = 1; i <= M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
	}
	else {
		for (int i = num; i <= N; i++) {
			arr[k] = i;
			dfs(k + 1,i+1);
		}
	}
}

int main() {
	cin >> N >> M;
	dfs(1,1);
}