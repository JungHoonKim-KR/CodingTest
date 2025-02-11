import java.util.*;
class Solution {
    static String p[];
    static int maxX;
    static int maxY;
    public int[] solution(String[] park, String[] routes) {
        p = park;
        maxX = park.length-1;
        maxY = park[0].length()-1;
        int positionX = 0, positionY=0;
        for(int i = 0; i<park.length; i++){
            boolean found = false;
            String s = park[i];
            for(int j =0; j<s.length(); j++){
                if(s.charAt(j) == 'S'){
                    positionX = i;
                    positionY = j;
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        
        for(String s : routes){
           String command[] = s.split(" ");
            if(command[0].equals("N")){
                if(move(positionX, positionY, positionX - Integer.parseInt(command[1]), positionY))
                    positionX -= Integer.parseInt(command[1]);
            }
                else if(command[0].equals("S")){
                    if(move(positionX, positionY, positionX + Integer.parseInt(command[1]), positionY))
                    positionX += Integer.parseInt(command[1]);
                }
                  else if(command[0].equals("W")){
                    if(move(positionX, positionY, positionX, positionY - Integer.parseInt(command[1])))
                    positionY -= Integer.parseInt(command[1]);
                }
                  else if(command[0].equals("E")){
                    if(move(positionX, positionY, positionX, positionY+ Integer.parseInt(command[1])))
                    positionY += Integer.parseInt(command[1]);
                }
            }
        
        
        int[] answer = {positionX, positionY};
        return answer;
    }

    
    static boolean move(int fromX, int fromY, int moveX, int moveY){
        if(moveX < 0 || moveX >maxX || moveY <0 || moveY > maxY)
            return false;
        if(fromX != moveX){
            for (int i = Math.min(fromX, moveX); i <= Math.max(fromX, moveX); i++) {
                if (p[i].charAt(fromY) == 'X') return false;
}

        }
        else if(fromY != moveY){
          for (int i = Math.min(fromY, moveY); i <= Math.max(fromY, moveY); i++) {
                 if (p[fromX].charAt(i) == 'X') return false;
}

        }
        return true;
        
    }
}