package scratch;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {

    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        int i = s.nextInt();
//        List<Integer> list = new ArrayList<>();
//
//        while(i > 0){
//            list.add(s.nextInt());
//            i--;
//        }
//
//        int k = s.nextInt();
//        while (k > 0){
//
//            String s1 = s.next();
//            if(s1.equals("Insert")){
//                list.add(s.nextInt(), s.nextInt());
//            }
//            else if(s1.equals("Delete")){
//                Integer a = s.nextInt();
//                Integer _ = list.remove((int)a);
//            }
//            k--;
//        }
//
//        for(Integer integer: list){
//            System.out.print(integer + " ");
//        }


        String [] strings = new String[]{"12.99", "12.213123"};

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return new BigDecimal(o1).compareTo(new BigDecimal(o2));
            }
        });



        System.out.println(strings[0]);
        System.out.println(strings[1]);





    }
}



