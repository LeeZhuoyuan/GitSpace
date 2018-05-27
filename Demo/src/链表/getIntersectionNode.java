package 链表;

/**
 * 编写一个程序来查找两个单独链接列表的交集开始的节点。
 * 例如：
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗
 * B:     b1 → b2 → b3
 * 则A与B的交集开始于 c1
 */
public class getIntersectionNode {
    public ListNode solution(ListNode headA, ListNode headB){
        if(headA == null && headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
}
