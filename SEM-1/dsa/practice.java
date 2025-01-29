
class practice {
    public Node<Integer> deleteDuplicates(Node<Integer> head) {
        Node<Integer> prev, curr;
        prev = null;
        curr = head;
        while (curr != null && curr.next != null) {
            int value = curr.value;
            int i = 0;
            while (curr != null && curr.value == value) {
                curr = curr.next;
                i++;
            }
            if (i == 1) {
                if (prev == null) {
                    head = prev;
                }
                prev = curr;
                curr = curr.next;
            } else {
                if (curr == null) {
                    if (prev == null)
                        return null;
                    else {
                        prev.next = null;
                        return head;
                    }
                } else {
                    if (prev != null) {
                        prev.next = curr;
                    }
                }
            }
        }
        if (prev == null) {
            if (curr != null)
                head = curr;
        }
        return head;
    }
}