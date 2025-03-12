#include <string>
#include <vector>
#include<bitset>

using namespace std;

int solution(int n) {
    int answer = 0;
    int one = bitset<20>(n).count();
    for(int i=n+1; i<=1000000; i++){
        if(one == bitset<20>(i).count()){
            answer = i;
            break;
        }
    }
    
    return answer;
}