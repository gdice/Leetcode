/**
 * Created with IntelliJ IDEA.
 * User: Tyler Sun
 * Date: 9/9/13
 * Time: 9:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String cur = "1";
        for (int t = 1; t < n; ++t) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            char c = cur.charAt(0);
            for (int i = 1; i < cur.length(); ++i) {
                if (cur.charAt(i) != c) {
                    sb.append(cnt).append(c);
                    cnt = 1;
                    c = cur.charAt(i);
                } else
                    ++cnt;
            }
            if (cnt > 0)
                sb.append(cnt).append(c);
            cur = sb.toString();
        }
        return cur;
    }

    public static void main(String[] args) {
        CountAndSay s = new CountAndSay();
        for (int i = 1; i <= 10; ++i)
            System.out.println(s.countAndSay(i));
    }
}
