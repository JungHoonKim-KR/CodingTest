import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
         Map<String, Integer> map = new HashMap<>();
        for(int i =0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        for(int k=0; k<photo.length;k++){
            int score=0;
            String[] pt = photo[k];
            for(int i =0; i<pt.length; i++){
                if(map.containsKey(pt[i])){
                    score+= map.get(pt[i]);
                }
            }
            answer[k] = score;
        }
        
        return answer;
    }
}