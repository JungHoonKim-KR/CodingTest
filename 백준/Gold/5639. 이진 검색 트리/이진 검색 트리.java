import java.util.*;
import java.io.*;
class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}


public class Main {
    static Map<Integer, int[]> tree = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            list.add(Integer.parseInt(input));
        }
        Stack<Node>stack = new Stack<>();
        Node root = new Node(list.get(0));
        stack.push(root);

        for(int i =1; i<list.size(); i++){
            Node cur = new Node(list.get(i));

            if(stack.peek().val > cur.val){
                stack.peek().left = cur;
            }
            else{
                Node parent = null;
                // isEmpty()가 true면 루트까지 올라왔다는 것.
                while(!stack.isEmpty() && stack.peek().val < cur.val){
                    parent = stack.pop();
                }
                parent.right = cur;
            }
            stack.push(cur);
        }
        postOrder(root);

        System.out.println(sb);

    }



    static void postOrder(Node cur) {
        if (cur.left != null)
            postOrder(cur.left);
        if (cur.right != null)
            postOrder(cur.right);
        sb.append(cur.val + " ");
    }
}
