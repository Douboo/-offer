public class CopyRandomList {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    /**
     * https://www.lintcode.com/problem/copy-list-with-random-pointer/description?_from=ladder&&fromId=6
     *
     * 复制带随机指针的链表
     * 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。
     * 返回一个深拷贝的链表。
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        RandomListNode node = head;
        while (node != null) {
            RandomListNode p = new RandomListNode(node.label);
            p.next = node.next;
            node.next = p;
            node = p.next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        RandomListNode root = head.next;
        node = head;
        RandomListNode p = root;
        while (node.next.next != null) {
            node.next = p.next;
            node = node.next;
            p.next = node.next;
            p = p.next;
        }

        return root;
    }
}
