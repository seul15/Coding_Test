#include <string>
#include <vector>
#include<sstream>
#include<algorithm>

using namespace std;

string solution(string s) {
    stringstream ss(s);
    int num;
    int max_element,min_element;
    bool isfirst=true;
    
    while(ss >> num){
        if(isfirst){
            max_element=min_element = num;
            isfirst = false;
        }
        else{
            max_element = max(num,max_element);
            min_element = min(num,min_element);
        }
    }
    
    string answer = to_string(min_element) + " "+to_string(max_element);
    return answer;
}