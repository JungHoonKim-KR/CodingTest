class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = convertToSecond(video_len);
        int posLen = convertToSecond(pos);
        int opStart = convertToSecond(op_start);
        int opEnd = convertToSecond(op_end);
        
        for(String c : commands){
          if(posLen >= opStart && posLen <= opEnd)
            posLen = opEnd;
            
            if(c.equals("prev")){
                if(posLen < 10)
                    posLen = 0;
                else posLen-=10;
            }
            else if(c.equals("next")){
                if(posLen > videoLen-10)
                    posLen = videoLen;
                else posLen+=10;
            }
         
          
        }
         if(posLen >= opStart && posLen <= opEnd)
            posLen = opEnd;        
        
        String answer = String.format("%02d:%02d",  posLen/60, posLen%60);
        return answer;
    }
    
    public int convertToSecond(String s){
        String arr[] = s.split(":");
        int mm = Integer.parseInt(arr[0]);
        int ss = Integer.parseInt(arr[1]);
        return mm*60 + ss;

    }


    }
