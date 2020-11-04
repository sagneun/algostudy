package week2;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int tmp : scoville){
            pQueue.add(tmp);
        }
        int tmp1;
        int tmp2;
        while(pQueue.peek() < K){
            if(pQueue.size() < 2 ){
                answer = -1;
                break;
            }
            tmp1 = pQueue.poll();
            tmp2 = pQueue.poll();
            pQueue.add(tmp1 + (tmp2 * 2));
            answer++;
        }
        return answer;
    }
}
