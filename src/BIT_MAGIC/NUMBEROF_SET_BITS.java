package BIT_MAGIC;

public class NUMBEROF_SET_BITS
{
//    Given a number N. You have to check whether every bit in the binary representation of the given number is set or not.
//    Kernighan's Algorithm
    static int checkBitSet(int n) {
        int count =0;
        while(n>0){
            n= n&(n-1);
            count++;
        }
        return count;
    }
}
