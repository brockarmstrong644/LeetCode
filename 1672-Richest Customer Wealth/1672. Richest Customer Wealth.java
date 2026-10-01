class Solution {
    public int maximumWealth(int[][] accounts) {
            int m = accounts.length;
            int richestCustomer = 0;
        for (int i = 0; i < m; i++){
                int customerSum = 0; 
                int n = accounts[i].length;
            for (int j=0; j < n ; j++){
                customerSum += accounts[i][j]; 
            }
            if (richestCustomer < customerSum){
                richestCustomer = customerSum;
            }
        }
        return richestCustomer;
    }
}
