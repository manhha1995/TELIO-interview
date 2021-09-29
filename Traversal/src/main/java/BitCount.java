import java.util.BitSet;
import java.util.Scanner;

public class BitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
    public static int Count(long[] arr) {
        BitSet bitSet = new BitSet(64);
        long[] longs = bitSet.toLongArray();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (longs == (bitSet.length()+63)/64 && longs.get(arr.length) == ((longs[n/64]) & (1L << (n%64))) != 0) {
                index ++;
            }
            else assert (bitSet.get(i) == false);
        }
        System.out.println(index);
    }
}