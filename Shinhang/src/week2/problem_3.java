package week2;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        LinkedList<String> linkedList = new LinkedList<>();

        for(int tmp : numbers){
            linkedList.add(Integer.toString(tmp));
        }

        Collections.sort(linkedList, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2.concat(o1)).compareTo(o1.concat(o2));
            }
        });

        String tmpStr;
        while(linkedList.get(0).startsWith("0")){
            if(linkedList.get(0).equals("0")) {
                if (linkedList.size() > 1) {
                    linkedList.removeFirst();
                    continue;
                }
                else break;
            }
            tmpStr = Integer.toString(Integer.parseInt(linkedList.getFirst()));
            linkedList.removeFirst();
            linkedList.addFirst(tmpStr);
        }

        for(String str : linkedList){
            answer = answer.concat(str);
        }
        return answer;
    }
}