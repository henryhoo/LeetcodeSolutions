public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0) {
                if (i%5 == 0) {
                    res.add("FizzBuzz");
                } else {
                res.add("Fizz");
                }

            } else if (i%5 == 0) {
                res.add("Buzz");
            } else {
                res.add(""+i);
            }
        }
        return res;
    }
}
//2nd solution
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.toString().equals("")) {
                sb.append(i);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
