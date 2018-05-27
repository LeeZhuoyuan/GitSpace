package 链表;

/**
 * 判断链表是否是循环链表
 */
public class hasCycle {
    public boolean solution(ListNode head){
        if(head == null){
            return false;
        }else{
            ListNode slow = head;//设置满指针
            ListNode quick = head.next;//设置快指针
            while(slow != quick){
                if(quick == null || quick.next == null){
                    return false;
                }else{
                    slow = slow.next;
                    quick = quick.next.next;//这里如果不考虑时间问题，quick.next也可以，但是有时间限制，所以加快款指针的步伐。
                }
            }
            return true;
        }
    }
}
