#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    vector<int>num;
    sort(tangerine.begin(),tangerine.end());
    
    int start =-1;
    for(int i=0; i<tangerine.size(); i++){
        if(tangerine[i] != tangerine[i+1] || 
           i==tangerine.size()-1){
            num.push_back(i-start);
            start = i;
        }
    }
    sort(num.begin(),num.end(),greater<int>());
    
    int temp=0;
    for(int i=0; i<num.size(); i++){
        answer++;
        if(temp+num[i]>=k) break;
        else temp+=num[i];
    }
    
    return answer;
}