package scratch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    static class Inner{
        private class Private{
            private String powerof2(int num){
                return ((num&num-1)==0)?"power of 2":"not a power of 2";
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        try {
            Inner.Private aPrivate = Inner.Private.class.newInstance();
            System.out.println(aPrivate.powerof2(2));

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        String input = "Goodbye bye bye world world world";

        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
//            input = input.replaceAll("(?i)(\\w+\\s)(\\1+)", "$1");
            input = input.replaceAll(m.group(), m.group(1));
        }

        // Prints the modified sentence.
        System.out.println(input);
        
//        in.close();
    }
}