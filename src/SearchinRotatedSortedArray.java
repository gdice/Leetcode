import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 8:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchinRotatedSortedArray {
    public static int search(int[] A, int target) {
        int low = 0;
        int high = A.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (A[mid] == target)
                return mid;
            if (A[low] == target)
                return low;
            if (A[mid] > A[low]) {
                if (target > A[mid] || target < A[low])
                    low = mid + 1;
                else
                    high = mid;
            } else {
                if (target > A[mid]) {
                    if (target > A[low])
                        high = mid;
                    else
                        low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        if (low == A.length || A[low] != target)
            return -1;
        return low;
    }

    public static void main(String[] args) throws IOException {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        for (int i = 0; i< 8; ++i)
            System.out.println(search(a, i));
    }
}
