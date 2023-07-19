import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] target = scores[0];
        int targetScore = target[0] + target[1]; // 완호의 점수 합
        // 근태 기준 내림차순 정렬 + 동료평가 기준 오름차순 정렬
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){ // 근태점수 같으면
                    return o1[1] - o2[1]; // 동료평가 오름차순
                } else{
                    return o2[0] - o1[0]; // 근태점수 내림차순
                }
            }
        });

        int answer = 1; // 완호의 석차
        int max = scores[0][1]; // 동료평가 점수의 최대값 추적
        for(int i = 0; i < scores.length; i++) {
            if(scores[i][1] < max) { // 인센티브 받지 못하는 경우
                if(scores[i][0] == target[0] && scores[i][1] == target[1]) { // 못받는 게 완호의 상황이라면..
                    return -1;
                }
                continue;
            }
            max = Math.max(max, scores[i][1]); // 최대값 업데이트
            if(scores[i][0] + scores[i][1] > targetScore) answer++;
        }
        return answer;
    }
}