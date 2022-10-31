class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        boolean flag = false;
        for(int i = 1 ; i < N ; i++) {
            for(int j = 1 ; j < M ; j++) {
                if(i-1 < 0 || j-1 < 0) continue;
                if(matrix[i-1][j-1] != matrix[i][j]) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        
        if(!flag) return true;
        else return false;
        
    }
}