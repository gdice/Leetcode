import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> counts = new ArrayList<List<List<Integer>>>();
        for (int i = 0; i <= target; ++i)
            counts.add(new ArrayList<List<Integer>>());
        counts.get(0).add(new ArrayList<Integer>());
        for (int i = 0; i < candidates.length; ++i)
            counts.get(0).get(0).add(0);
        for (int i = 0; i <= target; ++i) {
            if (counts.get(i).size() == 0)
                continue;
            for (int j = 0; j < candidates.length; ++j) {
                int n = i + candidates[j];
                if (n > target)
                    break;
                for (int k = 0; k < counts.get(i).size(); ++k) {
                    ArrayList<Integer> next = new ArrayList<Integer>(counts.get(i).get(k));
                    next.set(j, next.get(j) + 1);
                    counts.get(n).add(next);
                }
            }
        }
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < counts.get(target).size(); ++i) {
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int p = 0; p < counts.get(target).get(i).size(); ++p)
                for (int q = 0; q < counts.get(target).get(i).get(p); ++q) {
                    a.add(candidates[p]);
                }
            if (set.contains(a))
                continue;
            set.add(a);
            ret.add(a);
        }
        return ret;
    }

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        int[] v = {2,3,6,7};
        ArrayList<ArrayList<Integer>> res = c.combinationSum(v, 7);
        for (int i = 0; i < res.size(); ++i) {
            for (int j = 0; j < res.get(i).size(); ++j)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
    }
}
