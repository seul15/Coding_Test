#include <string>
#include <vector>
#include <list>
#include <cctype>
#include <algorithm>

using namespace std;

int solution(int cacheSize, vector<string> cities) {
    if(cacheSize == 0) return cities.size() * 5;
    
    int answer = 0;
    list<string> cache;
    
    for(int i=0; i<cities.size(); i++){
        // 소문자 변환
        for(auto &s: cities[i]) s = tolower(s);
        
        // 캐시데이터 
        auto city = find(cache.begin(),cache.end(),cities[i]);
       if(city != cache.end()){
           cache.erase(city);
           cache.push_back(cities[i]);
           answer++;
       } 
        else{
            if(cache.size() == cacheSize) cache.pop_front();
            cache.push_back(cities[i]);
            answer+=5;
        }
    }
    return answer;
}