package dynamic_prog;

/**
 * Created by devesh on 12/07/19.
 */
public class NumWaysFb {


    public static int logic(String data){
        char[] chars = data.toCharArray();
        int numways = numways(chars, 0);
        return numways;
    }

    private static int numways(char[] chars, int i){

        if(i > chars.length){
            return 0;
        }
        if(i == chars.length){
            return 1;
        }

        int num = Integer.parseInt(String.valueOf(chars[i]));
        if(num == 0){
            return 0;
        }
        else if((num == 1 || num == 2)
                && i + 1 < chars.length && Integer.parseInt(String.valueOf(chars[i+1])) < 7
                &&  Integer.parseInt(String.valueOf(chars[i+1])) > 0){
            return numways(chars, i+1) + numways(chars, i+2);
        }
        else{
            return numways(chars, i+1);
        }
    }

//    public static int logic(String data){
//        char[] chars = data.toCharArray();
//        int count = 1;
//        for(int i = 0; i < chars.length; i++){
//            int j = Integer.parseInt(String.valueOf(chars[i]));
//            if(j < 1){
//                return 0;
//            }
//            else if(j == 1 || j == 2){
//                if(i + 1 < chars.length){
//                    int z = Integer.parseInt(String.valueOf(chars[i+1]));
//                    if(z >= 1 && z <= 6){
//                        count*=2;
////                        i++;
//                    }
//                }
//            }
//            else{
//                count = count*1;
//            }
//        }
//
//        return count;
//    }

    public static void main(String []st){

        int logic = logic("111111");
        System.out.println(logic);

    }
}
