#include <string>
#include <vector>

using namespace std;
long long f[100001] ={0,};
int solution(int n) {
    int answer = 0;
    f[0]=0;
    f[1]=1;
    for(int i=2; i<=n; i++){
        f[i] = (f[i-1]+f[i-2])%1234567;
    }
    answer = f[n]%1234567;
    return answer;
}