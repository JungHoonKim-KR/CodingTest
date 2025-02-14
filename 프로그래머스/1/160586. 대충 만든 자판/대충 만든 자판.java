import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];

        // keymap에서 각 문자별 최소 입력 횟수를 저장
        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); i++) {
                char key = keys.charAt(i);
                map.put(key, Math.min(map.getOrDefault(key, Integer.MAX_VALUE), i + 1));
            }
        }

        // targets에 대해 최소 입력 횟수 계산
        for (int i = 0; i < targets.length; i++) {
            int count = 0;
            String target = targets[i];

            for (char c : target.toCharArray()) {
                if (map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = -1;
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
