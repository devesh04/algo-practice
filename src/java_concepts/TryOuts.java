package java_concepts;

/**
 * Created by devesh on 03/07/19.
 */
public class TryOuts {

    {
        System.out.println("inint 1");
    }

    public TryOuts(){
        System.out.println("consutrutor");
    }

    static {
        System.out.println("inint 2");
    }

    {
        System.out.println("init 3");
    }

    static void printAsBinary(int i){
        System.out.println(i + " " + Integer.toBinaryString(i));
    }

    static void bitwise(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 13;

        printAsBinary(a);
        printAsBinary(a << 1);
        printAsBinary(a << 2);
        printAsBinary(a << 3);
        printAsBinary(a << 4);
        printAsBinary(a << 5);

        System.out.println();

        printAsBinary(c);
        printAsBinary(c >> 1);
        printAsBinary(c >> 2);
        printAsBinary(c >> 3);
        printAsBinary(c >> 4);
        printAsBinary(c >> 5);

        System.out.println();

        printAsBinary(c);
        printAsBinary(c >>> 1);
        printAsBinary(c >>> 2);
        printAsBinary(c >>> 3);
        printAsBinary(c >>> 4);
        printAsBinary(c >>> 5);
    }

    interface Sayable{
        void say(String ss, String bb);
    }

    public void saySomething(String ss){
        System.out.println(ss);
    }


    public static void main(String ar[]){

        TryOuts tryOuts = new TryOuts();

//        Sayable sayable = tryOuts::saySomething;
        Sayable sayable = (s, bb) -> tryOuts.saySomething(s);


//        Sayable sayable = (s) -> System.out::println;

        sayable.say("aaaa", "bbb");


//        Consumer<String> consumer = s -> System.out.println(s);




//        TryOuts tryOuts = new TryOuts();
        //arra rota
        //bitwise
        //

//        Reader reader = System.console().reader();
//        System.out.println(s);


//        float f = 1.0 /3;






//       int a = 120;
//       byte s = a;





//        ------------------



//        double a = 10d;
//
//        switch (a){
//            case 1:
//                System.out.println(a);
//            case 2:
//                System.out.println(a);
//        }

    }
}
