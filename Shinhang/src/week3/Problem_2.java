package week3;

import java.util.*;

class Problem_2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] isChecked = new boolean[n];
        Arrays.fill(isChecked, false);

        LinkedList<HashSet<Integer>> setList = new LinkedList<>();
        int tmpFlag = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(computers[i][j] == 1){
                    tmpFlag = -1;
                    for(int k = 0; k < setList.size(); k++){
                        if (setList.get(k).contains(i)) {
                            if(tmpFlag > -1){
                                setList.get(k).addAll(setList.get(tmpFlag));
                                setList.get(tmpFlag).clear();
                            }
                            setList.get(k).add(j);
                            tmpFlag = k;
                            isChecked[j] = true;
                        }
                        else if (setList.get(k).contains(j)) {
                            if(tmpFlag > -1){
                                setList.get(k).addAll(setList.get(tmpFlag));
                                setList.get(tmpFlag).clear();
                            }
                            setList.get(k).add(i);
                            tmpFlag = k;
                            isChecked[i] = true;
                        }
                    }
                    if(tmpFlag == -1){
                        setList.addLast(new HashSet<Integer>());
                        setList.getLast().add(i);
                        setList.getLast().add(j);
                        isChecked[i] = true;
                        isChecked[j] = true;
                    }
                }
            }
        }
        int tmp = 0;
        for(boolean bool : isChecked){
            if(bool == false){
                tmp++;
            }
        }
        for(HashSet<Integer> set : setList){
            if(set.isEmpty()){
                tmp--;
            }
        }
        answer = setList.size();
        return answer + tmp;
    }
}