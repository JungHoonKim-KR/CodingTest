import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<int[]>graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        
        final int MAX = 100_000;
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	PriorityQueue<int[]>queue = new PriorityQueue<>((o1, o2) -> {
    		return o1[1] - o2[1];
    	});
    	boolean visited[] = new boolean[MAX+1];
    	queue.add(new int[] {n,0});
    	
    	while(!queue.isEmpty()) {
    		int cur[] = queue.poll();
    		if(cur[0] == m) {
    			System.out.println(cur[1]);
    			return;
    		}
    		
    		if(!visited[cur[0]]) {
    			visited[cur[0]] = true;
    			
    			if(cur[0] * 2 <= MAX && !visited[cur[0] * 2]) {
    				queue.add(new int[] {cur[0]*2, cur[1]});
    			}
    			if(cur[0] +1 <= MAX && !visited[cur[0] +1]) {
    				queue.add(new int[] {cur[0]+1, cur[1] +1});
    			}
    			if(cur[0] -1 >= 0 && !visited[cur[0] -1]) {
    				queue.add(new int[] {cur[0]-1, cur[1] +1});
    			}
    		}
    		
    		
    	}
    	
    	
    	
           
    }
    
   

  
}