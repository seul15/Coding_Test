#include<iostream>
#include<string>
using namespace std;


int main() {
	string subject, score;
	double num;
	double score_count = 0;
	double subject_count = 0;
	for (int i = 0; i < 20; i++) {
		cin >> subject >> num >> score;
		if (score == "P") continue;
		else {
			if (score == "A+") { score_count += num * 4.5; }
			else if (score == "A0") { score_count += num * 4.0; }
			else if (score == "B+") { score_count += num * 3.5; }
			else if (score == "B0") { score_count += num * 3.0; }
			else if (score == "C+") { score_count += num * 2.5; }
			else if (score == "C0") { score_count += num * 2.0; }
			else if (score == "D+") { score_count += num * 1.5; }
			else if (score == "D0") { score_count += num * 1.0; }
			else if (score == "F") {}
			subject_count += num;
		}
	}
	cout << score_count / subject_count << "\n";
}