package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyMap {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {

        Map<Integer, Integer> itemMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();

        List<Integer> res = new ArrayList();
        for(int [] query : queries){
            Integer command = query[0];
            Integer value = query[1];

            switch(command){
                case 1:

                    int freq = itemMap.getOrDefault(value, 0);
                    itemMap.put(value, freq +1 );

                    int i = freqMap.getOrDefault(freq, 1) - 1;
                    freqMap.put(freq, i >= 0 ? i : 0);
                    freqMap.put(freq+1, freqMap.getOrDefault(freq+1, 0) + 1);

                    break;
                case 2:


                    Integer frequency = itemMap.getOrDefault(value, 0);
                    if(frequency >= 0){
                        itemMap.put(value, frequency -1 > 0 ? frequency -1 : 0);

                        int j = freqMap.getOrDefault(frequency, 1) - 1;
                        freqMap.put(frequency, j >= 0 ? j : 0);
                        freqMap.put(frequency - 1, freqMap.getOrDefault(frequency - 1, 0) + 1);
                    }

                    break;
                case 3:
                    if(freqMap.containsKey(value) && freqMap.get(value) > 0){
                        res.add(1);
                    }
                    else {
                        res.add(0);
                    }
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }
            List<Integer> ans = freqQuery(queries);

            for(Integer i : ans) {
                System.out.println(i);

//            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
//                bufferedWriter.write(
//                        ans.stream()
//                                .map(Object::toString)
//                                .collect(joining("\n"))
//                                + "\n");
            }
        }
    }
}
