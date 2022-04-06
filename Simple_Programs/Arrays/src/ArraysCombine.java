import java.util.Arrays;

public class ArraysCombine {

    public static void main(String[] args) {
        int[] a = {2, 6, 11, 13, 15, 30, 60, 100};
        int[] b = {1, 7, 9, 18, 22};

        int[] merged = new int[a.length + b.length];

        int aPosition = 0, bPosition = 0, mergedPosition = 0;

        while(aPosition < a.length && bPosition < b.length) {
            if(a[aPosition] < b[bPosition]) {
                merged[mergedPosition++] = a[aPosition++];
            } else {
                merged[mergedPosition++] = b[bPosition++];
            }
        }
        while (aPosition < a.length) {
            merged[mergedPosition++] = a[aPosition++];
        }
        while (bPosition < b.length) {
            merged[mergedPosition++] = b[bPosition++];
        }

        System.out.println(Arrays.toString(merged));
    }
}
