package Thread;

public class threadObject extends Thread{
    private String name;
    public threadObject(String _name){
        this.name = _name;
    }

    public void run(){
        super.run();

        for(int i = 0; i<100; i++){
            System.out.println(name+":"+i);
            try {
                sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
