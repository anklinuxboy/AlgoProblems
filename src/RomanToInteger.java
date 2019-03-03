import java.util.HashMap;

public class RomanToInteger {
    private static final HashMap<Character, Integer> romanIntegerMap = new HashMap<>();
    private static final char I = 'I';
    private static final char V = 'V';
    private static final char X = 'X';
    private static final char L = 'L';
    private static final char C = 'C';
    private static final char D = 'D';
    private static final char M = 'M';

    static {
        romanIntegerMap.put(I, 1);
        romanIntegerMap.put(V, 5);
        romanIntegerMap.put(X, 10);
        romanIntegerMap.put(L, 50);
        romanIntegerMap.put(C, 100);
        romanIntegerMap.put(D, 500);
        romanIntegerMap.put(M, 1000);
    }

    public int romanToInt(String s) {
        int value = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);

            switch (c) {
                case I:
                    if (i + 1 < size) {
                        char next = s.charAt(i + 1);
                        if (next == V) {
                            value += 4;
                            i++;
                        } else if (next == X) {
                            value += 9;
                            i++;
                        } else {
                            value += romanIntegerMap.get(I);
                        }
                    } else {
                        value += romanIntegerMap.get(I);
                    }
                    break;
                case V:
                    value += romanIntegerMap.get(V);
                    break;
                case X:
                    if (i + 1 < size) {
                        char next = s.charAt(i + 1);
                        if (next == L) {
                            value += 40;
                            i++;
                        } else if (next == C) {
                            value += 90;
                            i++;
                        } else {
                            value += romanIntegerMap.get(X);
                        }
                    } else {
                        value += romanIntegerMap.get(X);
                    }
                    break;
                case L:
                    value += romanIntegerMap.get(L);
                    break;
                case C:
                    if (i + 1 < size) {
                        char next = s.charAt(i + 1);
                        if (next == D) {
                            value += 400;
                            i++;
                        } else if (next == M) {
                            value += 900;
                            i++;
                        } else {
                            value += romanIntegerMap.get(C);
                        }
                    } else {
                        value += romanIntegerMap.get(C);
                    }
                    break;
                case D:
                    value += romanIntegerMap.get(D);
                    break;
                case M:
                    value += romanIntegerMap.get(M);
                    break;
            }
        }

        return value;
    }
}
