#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for(int i=1; i*i<=yellow; i++){
        if(yellow % i > 0) continue;
        else{
            int w = yellow / i;
            int h = i;
            if(2*w+2*h+4==brown){
                answer.push_back(w+2);
                answer.push_back(h+2);
                break;
            }
        }
    }
    return answer;
}