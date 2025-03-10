#include <string>
#include <vector>
#include<algorithm>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    int start=0;
    int end = people.size()-1;
    sort(people.begin(),people.end());
    while(start<=end){
        // 마지막 한명 남은 경우
        if(start==end){
            answer++;
            break;
        }
        // 최소 + 최대 2명 태움
        if(people[start]+people[end]<=limit){
            start++; end--;
            answer++;
        }
        // 최대값 한명만 태움
        else{ 
            end--;
            answer++;
        }
    }
    
    return answer;
}