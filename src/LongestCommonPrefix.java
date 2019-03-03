
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] str1 = new String[]{"flower", "flow", "flight", "flask", "flu"};
        System.out.println(prefix.longestCommonPrefix(str1));

        String[] str2 = new String[]{"hello"};
        System.out.println(prefix.longestCommonPrefix(str2));

        String[] str3 = new String[]{"aca","cba"};
        System.out.println(prefix.longestCommonPrefix(str3));

        String[] str4 = new String[]{"dog", "racecar", "car"};
        System.out.println(prefix.longestCommonPrefix(str4));

        String[] str5 = new String[]{"hello", "hell"};
        System.out.println(prefix.longestCommonPrefix(str5));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }

        int size = strs.length;

        if (size == 0) {
            return "";
        }

        if (size == 1) {
            return strs[0];
        }

        StringBuilder stringBuilder = new StringBuilder();
        getCommonPrefix(strs[0], strs[1], stringBuilder);

        for (int i = 2; i < size; i++) {
            getCommonPrefix(stringBuilder.toString(), strs[i], stringBuilder);
            if (stringBuilder.toString().equals("")) {
                return "";
            }
        }

        return stringBuilder.toString();
    }

    private void getCommonPrefix(String first, String second, StringBuilder builder) {
        builder.delete(0, builder.length());

        int traverse = Math.min(first.length(), second.length());
        int i = 0;
        while (i < traverse) {
            if (first.charAt(i) == second.charAt(i)) {
                builder.append(first.charAt(i));
                i++;
            } else {
                break;
            }
        }
    }
}
