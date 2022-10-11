class Solution {
    public int smallestEvenMultiple(int n) {
        int val = gcd(n, 2);
        return (2 * n) / val;
    }
    
    public int gcd(int a,int b) {
        if(b == 0) return a;
		if(b > a) return gcd(b,a);
		return gcd(b,a%b);
    }
}