#include <string>
#include <iostream>
#include<vector>
#include<cmath>

using namespace std;

bool check_num(char c){
    if(c>=48 && c<=57) return true;
    return false;
}

int solution(string dartResult) {
    int answer = 0;
    vector<int> num;
    string n="";
    for(int i=0; i<dartResult.length(); i++){
        if(dartResult[i]=='S'){
            num.push_back(stoi(n));
            n="";
        }
        else if(dartResult[i]=='D'){
            num.push_back(pow(stoi(n),2));
            n="";
        }
        else if(dartResult[i]=='T'){
            num.push_back(pow(stoi(n),3));
            n="";
        }
        else if(dartResult[i]=='#'){
            num.back()*=-1;
        }
        else if(dartResult[i]=='*'){
            if(num.size()<2) num.back() *= 2;
            else{
                num.back() *=2;
                num[num.size()-2]*=2;
            }
        }
        else if(check_num(dartResult[i])){
            n += dartResult[i];
        }
    }
    
    for(int i=0; i<num.size(); i++) answer+=num[i];
    return answer;
}