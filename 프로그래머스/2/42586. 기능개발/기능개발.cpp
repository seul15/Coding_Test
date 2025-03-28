#include <string>
#include <vector>
#include<map>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    map<int,int> percent;
    for(int i= 0; i<progresses.size(); i++){
        percent.insert({i,progresses[i]});
    }
    while(!percent.empty()){
        int complete=0;
        for(auto& progress:percent){
            cout<<progress.second<<"\n";
            progress.second = progress.second+speeds[progress.first]; 
            cout<<progress.second<<"\n";
        }
        
        for(auto& progress:percent){
            if(progress.second>=100){
                percent.erase(progress.first);
                complete++;
            }
            else break;
        }
        if(complete!=0) answer.push_back(complete);
    }
    return answer;
}