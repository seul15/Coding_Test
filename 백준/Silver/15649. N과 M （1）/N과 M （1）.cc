
#include<iostream>
using namespace std;

int arr[9] = {};
bool visited[9] = {};
int N, M;

void dfs(int k) {
	if (k == M+1) {
		for (int i = 1; i <= M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
	}
	else {
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[k] = i;
				dfs(k + 1);
				visited[i] = false;
			}
		}
	}
}

int main() {
	cin >> N >> M;
	dfs(1);
}