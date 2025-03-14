#include <string>
#include <vector>
#include<algorithm>

using namespace std;

int GCD(int a,int b){
    while(1){
        int div = a%b;
        if(div == 0) return b;
        else a=b; b= div;
    }
}

int solution(vector<int> arr) {
    int answer = 0;
    sort(arr.begin(),arr.end(),greater<int>());
    
    if(arr.size()==1) return arr[0];
    else{
        for(int i=1; i<arr.size(); i++){
            if(i==1) answer= arr[i-1] * arr[i] / GCD(arr[i-1],arr[i]);
            else answer = answer*arr[i] / GCD(answer,arr[i]);
        }
    }
    return answer;
}