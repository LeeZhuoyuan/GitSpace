package 链表;

import java.util.Arrays;

public class listNodeTest {
    /*List<Integer> list = new ArrayList<>();
    int num = 1;
    public List creatList(){
        for(int i=0; i<5; i++){
            list.add(num);
            num++;
        }
        return list;
    }*/

    public static void main(String[] args) {
        //listNodeTest test = new listNodeTest();
        ListNode listnode = new ListNode();
        reverseList list = new reverseList();
        //ListNode node = listnode.creatListNode(Arrays.asList(1));
        ListNode node = list.reverseNode(listnode.creatListNode(Arrays.asList(1,2,3,4,5)));
        while (node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

}
