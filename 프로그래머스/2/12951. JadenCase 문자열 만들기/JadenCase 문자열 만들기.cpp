#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    bool isblank = true; // 전에 공백 문자가 있는지 확인여부
    for(auto c:s){
        if(c == ' '){
            answer+=c;
            isblank=true;
        }
        else if(isblank){
            answer+=toupper(c);
            isblank=false;
        }
        else answer+=tolower(c);
    }
    
    return answer;
}