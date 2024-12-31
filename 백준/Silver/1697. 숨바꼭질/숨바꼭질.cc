#include<iostream>
#include<queue>
using namespace std;

int N, K;
bool visited[100001] = {}; // 방문했는지 확인

void bfs(int n) {
	queue<pair<int,int>> q;
	q.push(make_pair(n,0));
	visited[n] = true;

	while (!q.empty()) {
		n = q.front().first;
		int count = q.front().second;
		q.pop();
		if (n == K) {
			cout << count << "\n";
			break;
		}

		if (n - 1 >= 0 && n - 1 <= 100000) {
			if (!visited[n - 1]) {
				q.push(make_pair(n - 1, count + 1));
				visited[n - 1] = true;
			}
		}

		if (n + 1 >= 0 && n + 1 <= 100000) {
			if (!visited[n + 1]) {
				q.push(make_pair(n + 1, count + 1));
				visited[n + 1] = true;
			}
		}

		if (n*2 >= 0 && n*2 <= 100000) {
			if (!visited[n*2]) {
				q.push(make_pair(n*2, count + 1));
				visited[n*2] = true;
			}
		}
	}
}


int main() {
	cin >> N >> K;
	bfs(N);
}