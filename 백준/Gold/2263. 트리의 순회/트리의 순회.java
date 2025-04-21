import java.util.*;
import java.io.*;
class Order{
    int n, inOrder[], postOrder[];
    StringBuilder sb = new StringBuilder();
    // key : value, value : index
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    Map<Integer, Integer> postOrderMap = new HashMap<>();
    Order(int n, int inOrder[], int[] postOrder){
        this.n = n;
        this.inOrder = inOrder;
        this.postOrder = postOrder;
    }

    void settingIndex(){
        for(int i =0; i<n;i++){
            inOrderMap.put(inOrder[i],i);
            postOrderMap.put(postOrder[i],i);
        }
    }

    void buildPreOrder(int inStart, int inEnd, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return;
        }
        // 왼쪽 오른쪽 나누기
        int rootValue = postOrder[postEnd];
        int rootIndex = inOrderMap.get(rootValue);

        sb.append(rootValue+" ");
        int leftSize = rootIndex - inStart;
        //left 중위, left 후위
        buildPreOrder(inStart, rootIndex-1,postStart, postStart+leftSize-1);
        //right 중위, right 후위
        buildPreOrder(rootIndex+1, inEnd, postStart+leftSize, postEnd -1);
    }


}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Order order = new Order(n, Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
                Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());

        order.settingIndex();
        order.buildPreOrder(0, n-1, 0, n-1);

        System.out.println(order.sb);
    }
}
