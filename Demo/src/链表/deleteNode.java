package 链表;

/**
 * 写一个函数，删除一个单向链表中的节点（除了该节点是末级节点），但是只给出当前要删除的节点，请问怎么删除当前节点。
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class deleteNode {
    public void solution(ListNode node){
        if(node == null){
            return;
        }else{
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
