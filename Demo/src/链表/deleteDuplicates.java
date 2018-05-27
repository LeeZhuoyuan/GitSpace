package 链表;

/**
 * 给定一个排序链表，删除所有重复项，以便每个元素只出现一次
 * Definition for singly-linked list.
 * public class ListNode {
 *  int val;
 *  ListNode next;
 *  ListNode(int x) { val = x; }
 * }
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = head.next;
        while (pre != null){
            if(cur.val == pre.val){
                cur.next = pre.next;
            }else {
                cur = cur.next;
            }
            pre = pre.next;
        }
        return head;
    }
}
