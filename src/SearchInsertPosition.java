import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 8:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchInsertPosition {
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

    public int searchInsert(int[] A, int target) {
        return lowerBound(A, target);
    }

    public static void main(String[] args) throws IOException {
        SearchInsertPosition s = new SearchInsertPosition();
        int[] a = {0, 1, 1, 1, 5, 6, 7};
        for (int i = 0; i< 8; ++i) {
            int r = s.searchInsert(a, i);
            System.out.println(r);
        }
    }
}
