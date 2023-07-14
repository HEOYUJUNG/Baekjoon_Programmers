class Solution
{
    public int solution(int n, int a, int b)
    {
        int cnt = 0;
        while( n > 0 ){
            a = (a+1)/2;
            b = (b+1)/2;
            cnt++;
            if ( a == b ) break;            
            n /= 2;            
        }
        return cnt;
    }
}