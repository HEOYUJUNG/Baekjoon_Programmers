import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int L = sequence.length;
        
        // 펄스 수열을 곱한 결과
        int[] pulseArr1 = new int[L];
        int[] pulseArr2 = new int[L];
        int pulse = 1;
        for(int i = 0; i < L; i++) {
            pulseArr1[i] = sequence[i] * pulse;
            pulse *= (-1);
            pulseArr2[i] = sequence[i] * pulse;
        }
        
        // dp[i] : i번째 수를 포함하면서 가장 큰 연속 펄스 부분 수열의 합
        // 1) i-1번째 수를 포함하거나
        // 2) i-1번째 수를 포함하지 않거나 (i번째 수부터 새롭게 시작)
        long[] dp1 = new long[L];
        long[] dp2 = new long[L];
        dp1[0] = pulseArr1[0];
        dp2[0] = pulseArr2[0];
        long max = Math.max(dp1[0], dp2[0]);
        for(int i = 1; i < L; i++) {
            dp1[i] = Math.max(dp1[i-1] + pulseArr1[i], pulseArr1[i]);
            dp2[i] = Math.max(dp2[i-1] + pulseArr2[i], pulseArr2[i]);
            max = Math.max(max, dp1[i]);
            max = Math.max(max, dp2[i]);
        }

        return max;
    }
}