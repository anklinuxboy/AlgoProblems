public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        fourth.next = fifth;
        third.next = fourth;
        second.next = third;
        head.next = second;

        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        head = oddEvenLinkedList.oddEvenList(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            int temp = fast.val;
            fast.val = slow.val;
            slow.val = temp;

            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        while (slow.next != null && slow.next.next != null) {
            slow = slow.next;
        }

        if (slow.next != null) {
            int temp = slow.val;
            slow.val = slow.next.val;
            slow.next.val = temp;
        }

        return head;
    }
}
