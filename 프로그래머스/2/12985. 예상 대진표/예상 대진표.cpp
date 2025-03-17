#include <iostream>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0;

    for(;;){
        if(a==b) break;
        a = (a+1)/2;
        b = (b+1)/2;
        answer++;
    }

    return answer;
}