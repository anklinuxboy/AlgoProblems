import java.util.Deque;
import java.util.LinkedList;

public class ParanthesesMatching {
    public static void main(String[] args) {
        String sentence1 = "Hey man, how ((are you) I meant waht(up wi(th) you))";
        // sentence1 = 14, sentence1.lenght()
        String sentence2 = "";
        // null
        String sentence3 = "(((((())))))";
        // 1, sentence3.length()
        String sentence4 = "(((((())";
        // null
        String sentence5 = "))))))";
        // null
        String sentence6 = "(())))))";
        // null
        String sentence7 = "And this is my story (I'm Ankit). The guy who had big dreams. (I always had big dreams). And I never gave up.";
        // 63, 87

        ParanthesesMatching paranthesesMatching = new ParanthesesMatching();
        ParansPosition position1 = paranthesesMatching.getParansPosition(sentence1);
        System.out.println("Open Position: " + position1.openParanPosition + " Close Position: " + position1.closeParanPosition +
                " Sentence Length: " + sentence1.length());

        ParansPosition position2 = paranthesesMatching.getParansPosition(sentence2);
        System.out.println(position2 == null);

        ParansPosition position3 = paranthesesMatching.getParansPosition(sentence3);
        System.out.println("Open Position: " + position3.openParanPosition + " Close Position: " + position3.closeParanPosition +
                " Sentence Length: " + sentence3.length());

        ParansPosition position4 = paranthesesMatching.getParansPosition(sentence4);
        System.out.println(position4 == null);

        ParansPosition position5 = paranthesesMatching.getParansPosition(sentence5);
        System.out.println(position5 == null);

        ParansPosition position6 = paranthesesMatching.getParansPosition(sentence6);
        System.out.println(position6 == null);

        ParansPosition position7 = paranthesesMatching.getParansPosition(sentence7);
        System.out.println("Open Position: " + position7.openParanPosition + " Close Position: " + position7.closeParanPosition +
                " Sentence Length: " + sentence7.length());
    }

    public ParansPosition getParansPosition(String sentence) {
        int openParansCount = 0;
        int closeParansCount = 0;
        ParansPosition paransPosition = null;
        Deque<ParansPosition> paransStack = new LinkedList<>();

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                openParansCount++;
                ParansPosition paransPosition1 = new ParansPosition();
                paransPosition1.openParanPosition = i + 1;
                paransStack.addFirst(paransPosition1);
            }

            if (sentence.charAt(i) == ')') {
                closeParansCount++;
                if (paransStack.size() > 0) {
                    paransPosition = paransStack.removeFirst();
                    paransPosition.closeParanPosition = i + 1;
                }
            }
        }

        if (openParansCount == closeParansCount) {
            return paransPosition;
        } else {
            return null;
        }
    }

    private static class ParansPosition {
        int openParanPosition;
        int closeParanPosition;
    }
}
