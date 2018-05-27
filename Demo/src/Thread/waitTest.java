package Thread;

public class waitTest implements Runnable{

    private String name;
    private Object prev;
    private Object self;

    public waitTest(String name, Object prev, Object self){
        this.name = name;
        this.prev = prev;
        this.self = self;
    }
    @Override
    public void run() {
        int count = 10;
        while (count > 0){
            synchronized (prev){
                synchronized (self){
                    System.out.println(name);
                    count --;
                    self.notify();
                }
                try {
                    prev.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        waitTest wa = new waitTest("A", c, a);
        waitTest wb = new waitTest("B", a, b);
        waitTest wc = new waitTest("C", b, c);

        new Thread(wa).start();
        Thread.sleep(1000);
        new Thread(wb).start();
        Thread.sleep(1000);
        new Thread(wc).start();
        Thread.sleep(1000);
    }
}
