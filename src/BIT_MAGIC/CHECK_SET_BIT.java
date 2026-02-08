package BIT_MAGIC;

public class CHECK_SET_BIT {
    public static void main(String[] args) {
        System.out.println(isBitSet(0));
    }

    static int isBitSet(int N) {
        if(N==0) return N;
        while(N>0){
            if((N & 1) == 0){
                return 0;
            }
            N=N>>1;
        }
       return 1;
    }
}
