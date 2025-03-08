#include <iostream>
#include<string>
#include<stack>
using namespace std;

int solution(string s)
{
    stack<char> S;

    for(auto c:s)
    {      
        if(S.size()>0 && S.top() == c) S.pop();
        else S.push(c);
    }
    if(S.empty()) return 1;
    else return 0;
}