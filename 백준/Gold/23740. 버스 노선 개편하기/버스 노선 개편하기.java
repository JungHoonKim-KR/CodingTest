import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    long start, end, cost;

    Node(long start, long end, long cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, cost));
        }
        Collections.sort(list, (a, b) -> {
            if (a.start == b.start)
                return Math.toIntExact(a.end - b.end);
            return Math.toIntExact(a.start - b.start);
        });

        List<Node>result = setting(list);
        sb.append(result.size()).append("\n");
        for(Node node : result) {
            sb.append(node.start).append(" ").append(node.end).append(" ").append(node.cost).append("\n");
        }
        System.out.println(sb);

    }

    static List<Node> setting(List<Node> initialList) {
        List<Node> curList = initialList;
        boolean merged;

        do {
            merged = false;
            List<Node> nextList = new ArrayList<>();
            nextList.add(curList.get(0));

            for (int i = 1; i < curList.size(); i++) {
                Node curNode = curList.get(i);
                Node lastNode = nextList.get(nextList.size() - 1);

                if (curNode.start <= lastNode.end) {
                    lastNode.end = Math.max(curNode.end, lastNode.end);
                    lastNode.cost = Math.min(curNode.cost, lastNode.cost);

                    merged = true;

                } else {
                    nextList.add(curNode);
                }

            }
            curList = nextList;
        } while (merged);
        return curList;
    }

}