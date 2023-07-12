import java.util.*;

class Solution {    
    static int R, C;
    // 상하좌우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0 , 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        R = park.length; // 행 크기
        C = park[0].length(); // 열 크기
        // 시작점 찾기
        int r = 0;
        int c = 0;
        here : for(int i = 0; i < R; i++) {
            String p = park[i];
            for(int j = 0; j < C; j++) {
                if(p.charAt(j) == 'S') {
                    r = i;
                    c = j;
                    break here;
                }
            }
        }
        for(int i = 0; i < routes.length; i++){
            String move = routes[i];
            char dir = move.charAt(0);
            int dist = move.charAt(2) - '0';
            int d = 0;
            if(dir == 'N' && check(park, r, c, 0, dist)) {
                d = 0;
                r += dr[d] * dist;
                c += dc[d] * dist;
            } else if(dir == 'S' && check(park, r, c, 1, dist)) {
                d = 1;
                r += dr[d] * dist;
                c += dc[d] * dist;  
            } else if(dir == 'W' && check(park, r, c, 2, dist)) {
                d = 2;
                r += dr[d] * dist;
                c += dc[d] * dist;
            } else if(dir == 'E' && check(park, r, c, 3, dist)) {
                d = 3;
                r += dr[d] * dist;
                c += dc[d] * dist;
            }
            
            
        }
        
        int[] answer = {r, c};
        return answer;
    }
                   
    public static boolean check(String[] park, int r, int c, int dir, int dist) {
        for(int d = 1; d <= dist; d++){
            int rr = r + dr[dir] * d;
            int cc = c + dc[dir] * d;
            // 1) 배열 범위 벗어나는 경우
            if(rr < 0 || rr >= R || cc < 0 || cc >= C){
                return false;
            }
            // 2) 장애물을 만난 경우
            String p = park[rr];
            if(p.charAt(cc) == 'X')
                return false;
        }
        return true;
    }
}
