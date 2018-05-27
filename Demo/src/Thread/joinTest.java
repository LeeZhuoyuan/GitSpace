package Thread;

public class joinTest extends Thread{
    private String name;
    public joinTest(String name){
        super(name);
        this.name = name;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+"线程运行开始！");
        for (int i = 0; i<5; i++){
            System.out.println("子线程"+name+"运行:"+ i);
            try {
                sleep((int)Math.random()*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程运行结束！");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程运行开始！");
        joinTest t1 = new joinTest("A");
        joinTest t2 = new joinTest("B");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"主线程运行结束！");
    }
}
