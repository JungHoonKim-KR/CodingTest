class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int weight = board[0]/2;
        int height = board[1]/2;
        
        for(String key : keyinput){
            if(key.equals("left") && answer[0]> -weight){
                answer[0]--;
            }           
            else if(key.equals("right") && answer[0]<weight){
                answer[0]++;
            }
            else if(key.equals("up") &&  answer[1]<height){
                answer[1]++;
            }
            else if(key.equals("down") && answer[1]> -height){
                answer[1]--;
            }
        }
        return answer;
    }
}