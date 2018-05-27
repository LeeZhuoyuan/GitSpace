package Thread;

/**
 * 四个线程，其中两个线程每次对j增加1，两个线程每次对j减1
 */
public class threadDemo {
    private int j;
    private synchronized void inc(){
        j++;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    private synchronized void dec(){
        j--;
        System.out.println(Thread.currentThread().getName()+"-inc:"+j);
    }
    class inc implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i<100; i++){
                inc();
            }
        }
    }
    class dec implements Runnable{

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                dec();
            }
        }
    }

    public static void main(String[] args) {
        threadDemo td = new threadDemo();
        inc ic = td.new inc();
        dec dc = td.new dec();
        for (int i=0; i<2; i++){
            Thread t = new Thread(ic);
            try {
                t.start();
                t.sleep(1000);
                t = new Thread(dc);
                t.start();
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
