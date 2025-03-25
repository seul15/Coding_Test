#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int* solution(int n, long long left, long long right) {
    // return 값은 malloc 등 동적 할당을 사용해주세요. 할당 길이는 상황에 맞게 변경해주세요.
    int* answer = (int*)malloc((right - left + 1) * sizeof(int));
    for(long long i=left; i<=right; i++){
        if(i%n<=i/n) answer[i-left]=i/n+1;
        else answer[i-left]=i%n+1;
    }
    
    return answer;
}