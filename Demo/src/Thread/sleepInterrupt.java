package Thread;

public class sleepInterrupt extends Thread{
    public void run(){
        System.out.println("Tom猫要睡20秒");
        try {
            Thread.sleep(20000);
            System.out.println("Tom猫醒了");
        } catch (InterruptedException e) {
            System.out.println("出问题啦！");
            e.printStackTrace();
            //return;
        }
        System.out.println("Tom猫离开了");
    }

    public static void main(String[] args) {
        sleepInterrupt si = new sleepInterrupt();
        si.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("在main方法里开始中断线程");
        si.interrupt();
        System.out.println("main方法结束");
    }
}
