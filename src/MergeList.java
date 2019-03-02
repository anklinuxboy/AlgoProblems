public class MergeList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }

        int carry = 0;
        int localSum = l1.val + l2.val;
        if (localSum > 9) {
            localSum -= 10;
            carry = 1;
        }

        ListNode sum = new ListNode(localSum);
        ListNode currentDigit = sum;
        l1 = l1.next;
        l2 = l2.next;

        while (l1 != null || l2 != null) {
            localSum = l1.val + l2.val + carry;
            if (localSum > 9) {
                localSum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(localSum);
            currentDigit.next = node;
            currentDigit = node;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            localSum = l1.val + carry;
            if (localSum > 9) {
                localSum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(localSum);
            currentDigit.next = node;
            currentDigit = node;
            l1 = l1.next;
        }

        while (l2 != null) {
            localSum = l2.val + carry;
            if (localSum > 9) {
                localSum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(localSum);
            currentDigit.next = node;
            currentDigit = node;
            l2 = l2.next;
        }

        if (carry == 1) {
            ListNode node = new ListNode(carry);
            currentDigit.next = node;
            currentDigit = node;
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
