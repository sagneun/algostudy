package week1;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] person1 = {1,2,3,4,5};
        int[] person2 = {2,1,2,3,2,4,2,5};
        int[] person3 = {3,3,1,1,2,2,4,4,5,5};
        int p1Cnt = 0;
        int p2Cnt = 0;
        int p3Cnt = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == person1[i % person1.length]){
                p1Cnt++;
            }
            if(answers[i] == person2[i % person2.length]){
                p2Cnt++;
            }
            if(answers[i] == person3[i % person3.length]){
                p3Cnt++;
            }
        }
        Map<Integer, Integer> myMap = new TreeMap<>();

        myMap.put(1,p1Cnt);
        myMap.put(2,p2Cnt);
        myMap.put(3,p3Cnt);

        int maxVal = Integer.MIN_VALUE;

        int cnt = 0;

        for(Integer key : myMap.keySet()){
            if(myMap.get(key) > maxVal) {
                maxVal = myMap.get(key);
            }
        }

        for(Integer key : myMap.keySet()){
            if(myMap.get(key) == maxVal) {
                cnt++;
            }
        }

        answer = new int[cnt];
        int idx = 0;

        for(Integer key : myMap.keySet()){
            if(myMap.get(key) == maxVal) {
                answer[idx] = key;
                idx++;
            }
        }
        return answer;
    }
}