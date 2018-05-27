package 链表;

/**
 * 删除链表中的元素  已知链表 1-2-6-4-5-6  输入val=6  输出结果  1-2-4-5
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 链表算法.删除链表中的指定数字
 */
public class RemoveLinkedNum {
    public ListNode removeElements(ListNode head, int val){
        if(head == null){
            return head;
        }

        while (head != null && head.val == val){
            head = head.next;
        }

        ListNode current = head;
        while (current.next != null){
            if(current.next.val == val){
                current.next = current.next.next;
            }
        }
        return head;
    }
}
