#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {

    string answer = "";

    string week[7] = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

    int day = 5;

    for(int i = 1; i < a; i++)

    {

        if(i == 2)

        {
            day += 29;
        }
        else if(i < 8 && i % 2 == 1)
        {
            day += 31;
        }
        else if(i < 7 && i % 2 == 0)
        {
            day += 30;
        }
        else if(i > 8 && i % 2 == 1)
        {
            day += 30;
        }

        else if(i > 7 && i % 2 == 0)

        {
            day += 31;
        }
    }

    day += b - 1;
    day %= 7;

    answer = week[day];

    return answer;

}
