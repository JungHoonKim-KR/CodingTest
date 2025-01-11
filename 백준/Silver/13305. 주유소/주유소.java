import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도로와 도시를 받는데, 마지막 도시는 의미 없음
        int n = Integer.parseInt(br.readLine()) - 1;
        int road[] = new int[n];
        int city[] = new int[n];
        int totalDistance = 0;
        HashMap<Integer, Integer> costMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int distance = Integer.parseInt(st.nextToken());
            road[i] = distance;
            totalDistance += distance;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            // 각 도시와 도로는 인덱스를 같게 하고, map에 key = 비용, value는 인덱스로 한다.
            int cost = Integer.parseInt(st.nextToken());
            city[i] = cost;
            if(!costMap.containsKey(cost))
                costMap.put(cost, i);
            else
                costMap.put(cost,costMap.get(cost) < i? costMap.get(cost) : i);
        }
        // 그 후 key값에 따라 오름차순 정렬한다.
        costMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)
                );

        int lastIndex=n;
        int result=0;
        int distance=0;
        for(Map.Entry<Integer, Integer>entry : costMap.entrySet()){
            // 최소 비용의 인덱스를 뽑고 해당 인덱스 i ~ n-1까지의 거리를 모두 count한다.
            // 나머지 map을 반복하여 i~n-1범위 였으면 무시, 0~i-1이면 count하고 반복한다.
            int index = entry.getValue();
            if(index < lastIndex)  {
                for(int i = index; i<lastIndex ; i++){
                    result += road[i] * city[index];
                    distance += road[i];
                }
                // count == 총 거리면 break
                if(distance == totalDistance)
                    break;
                lastIndex = index;
            }
        }
        System.out.println(result);

    }

}