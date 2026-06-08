//Row with max 1s in Sorted Matrix

class row_With_Max_1s_Sorted_Matrix {

    public static void main(String[] args) {
        
        //CASE 1:
        //int arr[][]={{0,1,1,1},{1,1,1,1},{0,1,1,1},{0,0,0,0}};
        //CASE 2:
        int arr[][]={{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        int rows = arr.length;        
        int cols = arr[0].length;     
        int i = 0, j = cols - 1;     
        int count= 0;
        
        int maxRow = -1;  

        while (i < rows && j >= 0) {
            if (arr[i][j] == 1) {
                maxRow = i;   // this row has at least as many 1s as before
                j--;
            } else {
                i++;
            }
        }
        if(maxRow==-1){
            System.out.println("row: None ");
        }else{
            System.out.println("row: "+(maxRow+1));
        }
    }
}