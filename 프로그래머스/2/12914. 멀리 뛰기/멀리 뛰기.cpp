#include <string>
#include <vector>

using namespace std;

long long dp[2001]={0,};

long long solution(int n) {
    for(int i=1; i<=n; i++){
        if(i==1 || i==2) dp[i]=i;
        else dp[i] = (dp[i-1]+dp[i-2])%1234567;
    }
    long long answer = dp[n];
    return answer;
}