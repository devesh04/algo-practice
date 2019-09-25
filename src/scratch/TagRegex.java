package scratch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagRegex {
    public static void main(String[] args){

        int testCases = 1;
        while(testCases>0){

            String line = "<>hello</><h>dim</h>";

            //Write your code here
            String regex = "<(.+)>([^/<>]+)</\\1>";
            Pattern pattern = Pattern.compile(regex);

            boolean found = false;
            Matcher m = pattern.matcher(line);

            while(m.find()){
                found = true;
                process(m.group(2), pattern);
            }
            if(!found){
                System.out.println("None");
            }
            testCases--;
        }
    }

    public static void process(String input, Pattern pattern){
        Matcher m = pattern.matcher(input);
        boolean b = m.find();
        if(b){
            process(m.group(2), pattern);
        }
        else{
            System.out.println(input);
        }
    }
}



