package Thread;

public class assertTest {
    public static void main(String[] args) {
        int i = 0;
        for (i=0; i<5; i++){
            System.out.println(i);
        }
        --i;
        assert i == 5;
    }
}
