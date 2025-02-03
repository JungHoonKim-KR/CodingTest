class Solution {

    public int solution(int[] wallet, int[] bill) {
        int answer=0;
        int min_w = Math.min(wallet[0], wallet[1]);
        int max_w = Math.max(wallet[0], wallet[1]);
        int min_b = Math.min(bill[0], bill[1]);
        int max_b = Math.max(bill[0], bill[1]);
        
        while(min_b > min_w || max_b>max_w){
            if(max_b > max_w || min_b > min_w){
                max_b /=2;
                answer++;
            }
        
            if(min_b > max_b){
                int temp = max_b;
                max_b = min_b;
                min_b = temp;
            }
            
        }
        return answer;
    }
 
}