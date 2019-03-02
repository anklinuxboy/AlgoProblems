import java.util.HashMap;
import java.util.HashSet;

public class LinkedListCycles {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        HashSet<ListNode> nodesSeen = new HashSet<>();
        ListNode traverse = head;

        while (traverse != null) {
            if (nodesSeen.contains(traverse.next)) {
                return true;
            }

            nodesSeen.add(traverse);
            traverse = traverse.next;
        }

        return false;
    }
}
