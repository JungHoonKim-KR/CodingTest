import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        if(n ==1){
            System.out.println(1);
            System.exit(0);
        }
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 증가하는 배열을 만들 것이다.
        // 이 떄 증가폭이 가능한 좁도록 수를 교체할 것이다.
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i =1; i<n; i++){
            // 만약 수가 크다 : 그냥 추가
            int index = list.size()-1;
            if(list.get(index) < arr[i]){
                list.add(arr[i]);
            }
            // 같으면 무시, 적으면 검색 시작
            else if(list.get(index)> arr[i]){
                int minIndex = 0;
                int maxIndex = index;
                while(minIndex < maxIndex){
                    int mid = (minIndex +maxIndex)/2;
                    // 만약 추가할 값 보다 현재 값이 작다? 그럼 인덱스를 뒤로 움직여야함
                    if(list.get(mid) < arr[i]){
                        minIndex = mid+1;
                    }
                    else maxIndex = mid;
                }
                // 끝나면 적절한 위치에 해당 값을 대체
                list.set(minIndex, arr[i]);
            }
        }

        System.out.println(list.size());

    }
}