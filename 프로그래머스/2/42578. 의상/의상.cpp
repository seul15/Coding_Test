#include <string>
#include<unordered_map>
#include <vector>

using namespace std;

int solution(vector<vector<string>> clothes) {
	int answer = 1;
	unordered_map<string, int> cloth;

	for (int i = 0; i < clothes.size(); i++) {
		auto temp = cloth.find(clothes[i][1]);
		if (temp != cloth.end()) {
			temp->second = temp->second + 1;
		}
        else {
			cloth[clothes[i][1]] = 1;
		}
	}

	for (const auto& pair:cloth) {
		answer *= (pair.second + 1);
	}
	answer--;
	return answer;
}