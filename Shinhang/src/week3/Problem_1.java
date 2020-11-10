package week3;

import java.util.*;

public class Problem_1 {
    Comparator<Map.Entry<Integer, Integer>> compIdx = new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            if(o1.getValue() == o2.getValue()){
                return o2.getKey() - o1.getKey();
            } else {
                return o1.getValue() - o2.getValue();
            }
        }
    };

    Comparator<Map.Entry<String, HashMap<Integer, Integer>>> compMap = new Comparator<Map.Entry<String, HashMap<Integer, Integer>>>() {
        @Override
        public int compare(Map.Entry<String, HashMap<Integer, Integer>> o1, Map.Entry<String, HashMap<Integer, Integer>> o2) {
            return (SumOfValues(o1.getValue()) - SumOfValues(o2.getValue()));
        }
    };

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        LinkedList<Integer> linkedList = new LinkedList<>();


        HashMap<String, HashMap<Integer, Integer>> hashMapTmp = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            if(hashMapTmp.get(genres[i]) == null){
                hashMapTmp.put(genres[i], new HashMap<Integer, Integer>());
                hashMapTmp.get(genres[i]).put(i, plays[i]);
            } else {
                hashMapTmp.get(genres[i]).put(i, plays[i]);
            }
        }


        HashMap<String, HashMap<Integer, Integer>> hashMap1 = new HashMap<>();

        for(String str : hashMapTmp.keySet()){
            hashMap1.put(str, sortByValueIdx(hashMapTmp.get(str)));
        }
        HashMap<String, HashMap<Integer, Integer>> hashMapRtn = sortByValueSum(hashMap1);
        int tmp2;
        for(String str : hashMapRtn.keySet()){
            tmp2 = 0;
            for(Map.Entry<Integer, Integer> entry : hashMapRtn.get(str).entrySet()){
                if(tmp2 > 1) break;
                linkedList.push(entry.getKey());
                tmp2++;
            }
        }

        answer = new int[linkedList.size()];
        int tmp = 0;
        for(int val : linkedList){
            answer[tmp++] = val;
        }

        return answer;
    }

    public LinkedHashMap<String, HashMap<Integer, Integer>> sortByValueSum(HashMap<String, HashMap<Integer, Integer>> hashMap){
        LinkedHashMap<String, HashMap<Integer, Integer>> rtnHashMap = new LinkedHashMap<>();
        List<Map.Entry<String, HashMap<Integer, Integer>>> entryList = new LinkedList<>(hashMap.entrySet());
        Collections.sort(entryList, compMap);
        for(HashMap.Entry<String, HashMap<Integer, Integer>> entry : entryList){
            rtnHashMap.put(entry.getKey(), entry.getValue());
        }
        return rtnHashMap;
    }

    public LinkedHashMap<Integer, Integer> sortByValueIdx(HashMap<Integer, Integer> hashMap){
        LinkedHashMap<Integer, Integer> rtnHashMap = new LinkedHashMap<>();
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hashMap.entrySet());
        Collections.sort(entryList, compIdx);
        for(HashMap.Entry<Integer, Integer> entry : entryList){
            rtnHashMap.put(entry.getKey(), entry.getValue());
        }
        return rtnHashMap;
    }

    public int SumOfValues(HashMap<Integer, Integer> hashMap){
        int tmp = 0;
        for(int key : hashMap.keySet()){
            tmp += hashMap.get(key);
        }
        return tmp;
    }

}
