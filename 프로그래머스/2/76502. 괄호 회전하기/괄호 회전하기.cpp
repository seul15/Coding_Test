#include <string>
#include <vector>
#include<stack>

using namespace std;

int solution(string s) {
    int answer = 0;
    for (int i = 0; i < s.length(); i++) {
	    stack<int> test;
        for (int j = i; j < i + s.length(); j++) {
            if (!test.empty()) {
                if ((s[j % s.length()] == ']' && test.top() == '[') ||
                    (s[j % s.length()] == '}' && test.top() == '{') ||
                    (s[j % s.length()] == ')' && test.top() == '(')) test.pop();
                else test.push(s[j % s.length()]);
            }
            else test.push(s[j % s.length()]);
        }
	    if(test.empty()) answer++;
    }
    return answer;
}