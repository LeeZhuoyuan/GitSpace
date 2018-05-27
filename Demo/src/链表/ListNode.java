package 链表;

import java.util.List;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode creatListNode(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        ListNode firstNode = new ListNode(data.get(0));
        firstNode.next = creatListNode(data.subList(1,data.size()));
        return firstNode;
    }
}
