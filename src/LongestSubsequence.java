import java.util.HashSet;

public class LongestSubsequence {
    public static void main(String[] args) {
        LongestSubsequence longestSubsequence = new LongestSubsequence();
        String[] strings = new String[]{"abcabcbb", "bbbbb", "pwwkew", "dvdf"};
        for (String s : strings) {
            System.out.println(longestSubsequence.lengthOfLongestSubstring(s));
        }
    }

    public int lengthOfLongestSubstringIncorrect(String s) {
        int oldSubstringLength = 0;
        int currentSubstringLength = 0;
        HashSet<Character> substring = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            if (!substring.contains(c)) {
                substring.add(c);
            } else {

                substring.clear();
                substring.add(c);
                if (currentSubstringLength >= oldSubstringLength) {
                    oldSubstringLength = currentSubstringLength;
                    currentSubstringLength = 0;
                }
            }
            currentSubstringLength++;
        }

        return oldSubstringLength > currentSubstringLength ? oldSubstringLength : currentSubstringLength;
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 1;
        int count = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            Character c = s.charAt(i);
            System.out.println("i = " + c);
            for (int j = i+1; j < s.length(); j++) {
                System.out.println(" j = " + s.charAt(j));
                if (c.equals(s.charAt(j))) {
                    System.out.println("count = " + count);
                    if (count > maxLen) {
                        maxLen = count;
                    }

                    count = 1;
                    break;
                } else {
                    count++;
                }
            }
        }
        return maxLen;
    }
}
