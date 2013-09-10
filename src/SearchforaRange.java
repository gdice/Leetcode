import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 8:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchforaRange {
    int upperBound(int[] A, int v) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] <= v)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    int lowerBound(int[] A, int v) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] < v)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public int[] searchRange(int[] A, int target) {
        int low = lowerBound(A, target);
        int high = upperBound(A, target);
        if (low < high) {
            return new int[]{low, high - 1};
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) throws IOException {
        SearchforaRange s = new SearchforaRange();
        int[] a = {0, 1, 1, 1, 5, 6, 7};
        for (int i = 0; i< 8; ++i) {
            int[] r = s.searchRange(a, i);
            System.out.println(r[0] + " " + r[1]);
        }
    }
}
