import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> rank = new HashMap<>();
        for(int j = 0; j < players.length; j++){
            rank.put(players[j], j);
        }
        for(int i = 0; i < callings.length; i++){
            String name = callings[i];
            int r = rank.get(name);
            rank.replace(players[r], r-1);
            rank.replace(players[r-1], r);
            String tmp = players[r-1];
            players[r-1] = players[r];
            players[r] = tmp;
        }
        return players;
    }
}