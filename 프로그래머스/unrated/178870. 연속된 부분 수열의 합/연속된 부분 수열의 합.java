import java.util.*;

class Solution {
    public static class Pair {
        int st, ed, l;

        public Pair(int st, int ed) { 
            this.st = st;
            this.ed = ed;
            this.l = ed - st + 1;
        }
    }   
    public int[] solution(int[] sequence, int k) {
        int st = 0;
        int ed = 0;
        int sum = sequence[0];
        int size = sequence.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            
            @Override
            public int compare(Pair o1, Pair o2){
                if(o1.l == o2.l) {
                    return o1.st - o2.st; // 길이가 같으면 시작 인덱스가 작은 것이 우선순위 높음
                }
                return o1.l - o2.l; // 길이가 짧은 것이 우선순위 높음
            }
        }); 
        
        while(st <= ed) {
            if(sum > k) {
                sum -= sequence[st];                
                st++;
                continue;    
            }
            if(sum == k) {
                pq.add(new Pair(st, ed));
            }            
            ed++;
            if(ed == size) break;
            sum += sequence[ed];
        }
        Pair p = pq.poll();
        int[] answer = {p.st, p.ed};
        return answer;
    }
}