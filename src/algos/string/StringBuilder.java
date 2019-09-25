package algos.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devesh on 03/03/19.
 */
public class StringBuilder {

    private List<String> list = new ArrayList<>();
    private int totalSize = 0;

    public StringBuilder(){}

    public void append(String s){
        if(s != null){
            list.add(s);
            totalSize = totalSize + s.length();
        }

    }

    @Override
    public String toString(){
        char [] chars = new char[totalSize];
        int c = 0;
        for(String string : list){
            for(int i = 0; i < string.length(); i++){
                chars[c] = string.charAt(i);
                c++;
            }
        }
        return new String(chars);
    }



    public static void main(String a[]){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello ");
        stringBuilder.append("doreamon ");
        stringBuilder.append(", bye!");
        System.out.println(stringBuilder.toString());
    }

}
