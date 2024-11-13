#include<iostream>
#include<string.h>
using namespace std;

int score[2][100000] = { 0, };
int dp[2][100000] = { 0, };

int main() {
	int T; // 테스트 케이스 개수
	cin >> T;
	for (int i = 0; i < T; i++) {
		int n; // 열의 길이
		cin >> n;
		memset(score, 0, sizeof(score)); // 스티커의 점수
		
		// 스티커 점수 기록
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < n; c++) {
				cin >> score[r][c];
			}
		}

		memset(dp, 0, sizeof(dp));
		for (int j = 0; j < n; j++) {
			if (j == 0) {
				dp[0][0] = score[0][0];
				dp[1][0] = score[1][0];
			}
			else if (j == 1) {
				dp[0][1] = dp[1][0] + score[0][1];
				dp[1][1] = dp[0][0] + score[1][1];
			}
			// 한칸 왼쪽에서 대각선으로 고르는 경우, 두칸 왼쪽에서 대각선으로 고르는 경우 중 최댓값 선택
			else { 
				dp[0][j] = max(dp[1][j - 2], dp[1][j - 1]) + score[0][j];
				dp[1][j] = max(dp[0][j - 2], dp[0][j - 1]) + score[1][j];
			}
		}

		// 위쪽과 아랫쪽 중 최댓값 선택
		cout << max(dp[0][n - 1] , dp[1][n - 1]) << "\n";
	}
	return 0;
}