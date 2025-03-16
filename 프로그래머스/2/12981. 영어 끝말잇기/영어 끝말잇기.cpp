#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool compare(string a, string b){
    if(a==b) return true;
    else return false;
}

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    
    for(int i=1; i<words.size(); i++){
        for(int j=0; j<i; j++){
            if(compare(words[j],words[i])){
                answer.push_back(i%n+1);
                answer.push_back(i/n+1);
                return answer;
            } 
        }
        if(words[i-1].back() != words[i].front()){
            answer.push_back(i%n+1);
            answer.push_back(i/n+1);
            return answer;
        }
    }
    
    answer.push_back(0);
    answer.push_back(0);
    return answer;
}