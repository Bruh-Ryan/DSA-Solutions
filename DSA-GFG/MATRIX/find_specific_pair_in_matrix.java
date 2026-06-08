public class find_specific_pair_in_matrix {
    public static void main(String[]args){
        int q[][] = {{ 1, 2, -1, -4, -20 },
                      { -8, -3, 4, 2, 1 },
                      { 3, 8, 6, 1, 3 },
                      { -4, -1, 1, 7, -6 },
                      { 0, -4, 10, -5, 1 }};

    int max_val = Integer.MIN_VALUE;
    for(int a = 0; a<q.length-1;a++){
        for(int b = 0; b<q.length-1;b++)
            for(int c = a+1; c<q.length;c++)
                for(int d = b+1; d<q.length;d++){
                    if(max_val <q[c][d]-q[a][b]){
                        max_val = q[c][d]-q[a][b];
                    }
            }
        }
    System.out.println("MAX dis: "+max_val);
    }
}
