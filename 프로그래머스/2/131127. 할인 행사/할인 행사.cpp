#include <string>
#include <vector>
#include<map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    map<string,int> Want;
        
    for(int i=0; i<want.size(); i++){
        Want[want[i]] = number[i]; 
    }
    
    for(int i=0; i<=discount.size()-10; i++){
        map<string,int> temp;
        bool check=true;
        
        for(int j=0; j<10; j++){
            temp[discount[i+j]]++;
        }
        
        for(auto p: Want){
            if(Want[p.first] != temp[p.first]){
                check = false;
                break;
            }    
        }
        if(check) answer++;
    }
    return answer;
}