import java.io.IOException;

public class Main {

    public static class Runner implements Runnable{

        public void run() {
            System.out.println("dhehe");
        }
    }

    public static void main(String[] args) throws IOException {
	// write your code here
//        Program.POLICE_AND_THEIF.execute();

        Runnable hello = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        hello.run();

        String s = "aaassa";

        hello = new Runner();

        hello.run();




    }
}
