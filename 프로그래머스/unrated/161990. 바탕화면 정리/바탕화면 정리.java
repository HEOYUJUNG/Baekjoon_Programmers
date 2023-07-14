class Solution {
    public int[] solution(String[] wallpaper) {
        int smallR = 50;
        int smallC = 50;
        int largeR = 0;
        int largeC = 0;
        for(int r = 0; r < wallpaper.length; r++){
            for(int c = 0; c < wallpaper[0].length(); c++){
                if(wallpaper[r].charAt(c) == '#'){
                    smallR = (r < smallR) ? r : smallR;
                    smallC = (c < smallC) ? c : smallC;
                    largeR = (r > largeR) ? r : largeR;
                    largeC = (c > largeC) ? c : largeC;
                };                
            }
        }
        int[] answer = { smallR, smallC, largeR + 1, largeC + 1 };
        return answer;
    }
}