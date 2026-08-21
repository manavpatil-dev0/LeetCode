class Solution {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        flattenList(head);

        return head;
    }

    private Node flattenList(Node head) {

        Node curr = head;
        Node last = null;

        while (curr != null) {

            Node next = curr.next;

            if (curr.child != null) {

                Node childHead = curr.child;
                Node childTail = flattenList(childHead);

                // Connect current node to child list
                curr.next = childHead;
                childHead.prev = curr;

                // Connect child list to original next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Child pointer must be removed
                curr.child = null;

                last = childTail;

            } else {
                last = curr;
            }

            curr = next;
        }

        return last;
    }
}