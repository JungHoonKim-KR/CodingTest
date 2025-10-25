import java.io.*;
import java.util.*;


public class Main {
	static ArrayList<ArrayList<Integer>>list = new ArrayList();
	static int n;
	static int[] people;
	static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        people = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
        	people[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<=n; i++) {
        	list.add(new ArrayList());
        	
        }
        
        for(int i = 1; i<=n; i++) {
        	 st = new StringTokenizer(br.readLine());
        	int t = Integer.parseInt(st.nextToken());
        	
        	while(t-->0) {
        		list.get(i).add(Integer.parseInt(st.nextToken()));
        	}
        }
        
        for(int i = 1; i<=n/2; i++) {
        	dfs(1, i, new Stack());
        }
        System.out.println(min==Integer.MAX_VALUE ? -1 : min);
        
    }
    
    static void dfs(int start,int k, Stack<Integer>Astack) {
    	
    	if(Astack.size() == k) {
    		Stack<Integer>Bstack = new Stack();
    		for(int i = 1; i<=n; i++) {
    			if(!Astack.contains(i))
    				Bstack.push(i);
    		}
    		
    		if(Astack.isEmpty() || Bstack.isEmpty())
    			return ;
    		
    		if(bfs(Astack) && bfs(Bstack))
    			min = Math.min(min,  cal(Astack, Bstack));
    		return;
    	}
    	for(int i = start ; i<=n; i++) {
    		Astack.push(i);
    		dfs(i+1, k, Astack);
    		Astack.pop();
    	}
    	
    	
    }
    static int cal(Stack<Integer>Astack, Stack<Integer>Bstack) {
    	// A 값
    	int Asum = 0;
    	for(int s : Astack)
    		Asum += people[s];
    	
    	// B 값
    	int Bsum = 0;
    	for(int s : Bstack)
    		Bsum += people[s];
    	
    	return Math.abs(Asum - Bsum);
    }
    // stack에 있던 번호들이 모두 연결되어 있는지 확인
    static boolean bfs(Stack<Integer>stack) {
    	int init = stack.peek();
    	boolean visit[]  = new boolean[n+1];
    	Queue<Integer>queue = new LinkedList();
    	queue.add(init);
    	visit[init] =true;
    	int count=1;
    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
    		for(int next : list.get(cur)) {
    			if(!visit[next] && stack.contains(next)) {
    				visit[next] = true;
    				count++;
    				queue.add(next);
    			}
    		}
    	}
    	return count == stack.size();
    	
    }

}