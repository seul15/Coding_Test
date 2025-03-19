#include <string>
#include <vector>
#include <set>
#include<iostream>

using namespace std;

int solution(vector<int> elements) {
	set<int> s;

	for (int i = 0; i < elements.size(); i++) {
		int window = 0;
		for (int j = 0; j < i; j++) window += elements[j];
		for (int j = i; j < elements.size() + i; j++) {
			if (j != i) window -= elements[(j-i-1)%elements.size()];
			window += elements[j % elements.size()];
			s.insert(window);
		}
	}
    int answer = s.size();
    return answer;
}