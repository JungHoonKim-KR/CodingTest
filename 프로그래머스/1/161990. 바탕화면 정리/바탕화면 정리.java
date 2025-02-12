import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = wallpaper.length;
        int endX = -1;
        int startY = wallpaper[0].length();
        int endY = -1;
        
        for(int i =0; i<wallpaper.length; i++){
            String line = wallpaper[i];
            for(int j =0; j<wallpaper[i].length(); j++){
                if(line.charAt(j) == '#'){
                    startX = Math.min(startX, i);
                    endX = Math.max(endX, i+1);
                    startY = Math.min(startY, j);
                    endY = Math.max(endY, j+1);
                }
            }
        }
        
        int[] answer = {startX, startY, endX, endY};
        return answer;
    }
}