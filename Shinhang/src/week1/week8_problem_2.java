package week1;

class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = num;
        while(true){
            if(number == 1 || answer == 500){
                break;
            }
            if((number & 1) == 1){
                number *= 3;
                number++;
            } else {
                number /= 2;
            }
            answer++;
        }
        return (answer != 500 ? answer : -1);
    }
}