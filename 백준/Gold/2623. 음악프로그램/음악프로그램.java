import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	List<Integer>graph[] = new ArrayList[n+1];
    	int indegree[] = new int[n+1];
    	for(int i = 1; i<=n; i++) {
    		graph[i] = new ArrayList();
    	}
    	
    	while(m-->0) {
    		st = new StringTokenizer(br.readLine());
    		int k = Integer.parseInt(st.nextToken());
    		int a = Integer.parseInt(st.nextToken());
    		for(int i=1; i<k; i++) {
    			int b = Integer.parseInt(st.nextToken());
    			indegree[b]++;
    			graph[a].add(b);
    			a =b;
    		}
    	}
    	
    	Queue<Integer>q = new ArrayDeque();
    	for(int i =1; i<=n; i++) {
    		if(indegree[i] == 0)
    			q.add(i);
    	}
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		sb.append(cur+"\n");
    		for(int next : graph[cur]) {
    			if(--indegree[next] == 0)
    				q.add(next);
    		}
    	}
    	
    	for(int i : indegree) {
    		if(i !=0) {
    			System.out.println(0);
    			System.exit(0);
    		}
    	}
    	System.out.println(sb);
    	
    	
    
    }
}