import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer>map = new HashMap<>();
        for(int i =0; i<players.length;i++){
            map.put(players[i], i);
        }
        
        for(String name : callings){
            Integer index = map.get(name);
            index--;
            String changeP = players[index];
            map.put(name, index);
            
            Integer changeI = map.get(changeP)+1;
            map.put(changeP, changeI);
            
            players[index] = name;
            players[changeI] = changeP;
        }
        
        
        String[] answer = players;
        
        
        return answer;
    }
}