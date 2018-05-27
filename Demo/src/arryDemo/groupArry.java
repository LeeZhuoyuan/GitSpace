package arryDemo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class groupArry {

    public void group(List<Integer> selected, List<Integer> data, int n){
        if(n == 0){
            //输出所选的组合
            for(Integer i : selected){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;//输出空
        }
        if(data.isEmpty()){
            return;//否则不输出
        }

        //当选择第0个元素情况下
        selected.add(data.get(0));
        group(selected,data.subList(1,data.size()), n-1);

        //不选择第0号元素
        selected.remove(selected.size()-1);
        group(selected,data.subList(1,data.size()), n);
    }

    public static void main(String[] args) {
        groupArry arry = new groupArry();
        arry.group(new ArrayList<>(), Arrays.asList(1,2,3,4,5), 2);
    }
}
