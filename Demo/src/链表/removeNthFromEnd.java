package 链表;

/**
 * leetcode  中等
 * 给定一个链表，从列表末尾移除第n个节点并返回其头部。
 * 例如 给定链表 1-2-3-4   n=2
 * 那么得到的结果为 1-2-4，即删掉倒数第二个节点
 */
public class removeNthFromEnd {
    public ListNode solution(ListNode head, int n){
        int num = 0;
        int number = 0;
        ListNode current = head;
        while(current != null){//遍历  链表长度
            num ++;
            current = current.next;
        }
        current = head;
        while (current != null){
            number++;
            if(number == num - n){//找到要删除元素的位置
                current.next = current.next.next;
            }else if(num - n == 0){//等于0的时候  意味着删除头节点，所以直接将当前头节点的下一个节点定义为头节点并返回
                return head.next;
            }else {
                current = current.next;
            }
        }
        return head;
    }
}
