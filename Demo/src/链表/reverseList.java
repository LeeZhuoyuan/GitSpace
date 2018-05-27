package 链表;

/**
 * 单链表反转
 * 比如链表为1-2-3-4-5  得到结果为   5-4-3-2-1
 */
public class reverseList {
    public ListNode solution(ListNode head){
        ListNode pre = null;//前一个节点
        ListNode tmp = null;//下一个节点
        //ListNode cur = head;//当前节点
        while(head != null){
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    /**
     * 递归反转
     */
    public ListNode reverseNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
