public class Solution {
    private static final char[] digits = "0123456789abcdef".toCharArray();
	public String toHex(int num) {
		StringBuilder result = new StringBuilder();
		int i = 28;
		while (i > 0 && ((num & (0xf << i)) >>> i) == 0)
			i -= 4;
		for (; i >= 0; i -= 4)
			result.append(digits[(num & (0xf << i)) >>> i]);
		return result.toString();
	}
}


public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        int mask = 15;
        if (num > 0) {
            while (num > 0) {
                char t = '0';
                t += (num & mask) > 9 ? 39 + (num & mask) : (num & mask);
                sb.append(t);
                num >>= 4;
            }
        } else if (num < 0) {
            for (int i = 0; i < 8; i++) {
                char t = '0';
                t += (num & mask) > 9 ? 39 + (num & mask) : (num & mask);
                sb.append(t);
                num >>= 4;
            }
        } else {
            return "0";
        }
        return sb.reverse().toString();
    }
}
