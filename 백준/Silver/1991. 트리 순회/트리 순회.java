import java.util.*;
import java.io.*;
class Tree{
    Map<String, List<String>>tree = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    void insert(String parent, String child1, String child2){
        tree.put(parent, Arrays.asList(child1, child2));
    }

    void preOrder(String n){
        if(n.equals(".")){
            return;
        }
        sb.append(n);
        preOrder(tree.get(n).get(0));
        preOrder(tree.get(n).get(1));
    }
    void inOrder(String n){
        if(n.equals(".")){
            return;
        }
        inOrder(tree.get(n).get(0));
        sb.append(n);
        inOrder(tree.get(n).get(1));
    }
    void postorder (String n){
        if(n.equals(".")){
            return;
        }
        postorder (tree.get(n).get(0));
        postorder (tree.get(n).get(1));
        sb.append(n);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.insert(st.nextToken(), st.nextToken(), st.nextToken());
        }

        tree.preOrder("A");
        result.append(tree.sb+"\n");
        tree.sb.setLength(0);
        tree.inOrder("A");
        result.append(tree.sb+"\n");
        tree.sb.setLength(0);
        tree.postorder("A");
        result.append(tree.sb+"\n");

        System.out.println(result);
    }


}
