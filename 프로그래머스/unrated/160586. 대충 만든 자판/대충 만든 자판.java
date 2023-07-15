import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alphabet = new int[26];        
        Arrays.fill(alphabet, 200);
        
        for(int i = 0; i < keymap.length; i++){
            String key = keymap[i];
            for(int j = 0; j < key.length(); j++){
                char c = key.charAt(j);
                alphabet[c - 'A'] = Math.min(alphabet[c - 'A'], j + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            String word = targets[i];
            int cnt = 0;
            for(int j = 0; j < word.length(); j++){
                char c = word.charAt(j);
                if(alphabet[c - 'A'] == 200) { // 목표 문자열 작성할 수 없는 경우
                    cnt = -1;
                    break;
                }
                cnt += alphabet[c - 'A'];
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}