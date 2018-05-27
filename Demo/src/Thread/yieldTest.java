package Thread;

public class yieldTest extends Thread{
    public yieldTest(String name){
        super(name);
    }

    public void run(){
        for (int i = 1; i<=10; i++){
            System.out.println(" "+this.getName()+"#########"+i);
            if(i==5){
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        yieldTest yt1 = new yieldTest("Tom");
        yieldTest yt2 = new yieldTest("Jack");
        yt1.start();
        yt2.start();
    }
}
