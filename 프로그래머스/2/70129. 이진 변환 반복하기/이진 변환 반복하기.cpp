#include <string>
#include <vector>
using namespace std;

string trans(string &s,int &erase,int &trans){
    trans++;

    for(int i=0; i<s.length();){
        if(s[i]=='0'){
            s.erase(i,1);
            erase++;
        }
        else i++;
    }
    
    int len = s.length();
    string temp ="";
    while(len>0){
        temp = to_string(len%2)+temp;
        len /=2;
    }
    return temp;
}

vector<int> solution(string s) {
    vector<int> answer;
    int erase_0=0;
    int trans_num=0;
    
    while(s!="1"){
        s = trans(s,erase_0,trans_num);
    }
    
    answer.push_back(trans_num);
    answer.push_back(erase_0);
    
    return answer;
}