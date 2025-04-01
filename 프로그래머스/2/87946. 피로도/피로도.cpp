#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool visited[8]={};
int answer =0;

void dfs(int sleep, vector<vector<int>> &dungeons,int count){
    answer = max(answer,count);
    
    for(int i=0; i<dungeons.size(); i++){
        if(!visited[i] && sleep >= dungeons[i][0]){
            visited[i] = true;
            dfs(sleep-dungeons[i][1],dungeons,count+1);
            visited[i]=false;
        }
    }
    
}

int solution(int k, vector<vector<int>> dungeons) {
    dfs(k, dungeons, 0);
    
    return answer;
}