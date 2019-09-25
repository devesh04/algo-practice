package _practice.ex;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minimumSwaps' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY popularity as parameter.
     */



    public static int minimumSwaps(List<Integer> popularity) {

//        int size = popularity.size();
//
//        ArrayList <Pair<Integer, Integer>> arrpos = new ArrayList<>();
//        for (int i = 0; i < size; i++)
//            arrpos.add(new Pair<>(popularity.get(i), i));
//
//        arrpos.sort((o1, o2) -> o1.getKey() > o2.getKey() ? -1 : 1);
//
//        Boolean[] checked = new Boolean[size];
//        Arrays.fill(checked, false);
//
//        int swaps = 0;
//
//        for (int i = 0; i < size; i++)
//        {
//            if (checked[i] || arrpos.get(i).getValue() == i)
//                continue;
//
//            int currSize = 0;
//            int j = i;
//            while (!checked[j])
//            {
//                checked[j] = true;
//                j = arrpos.get(j).getValue();
//                currSize++;
//            }
//
//            if(currSize > 0)
//            {
//                swaps+= (currSize - 1);
//            }
//        }
//
//        return swaps;

        // Write your code here
        int slow = 0;
        int fast = 1;
        int swaps = 0;
        while(slow < popularity.size() && fast < popularity.size()){
            if(popularity.get(slow) >= popularity.get(fast)){
                fast++;
                slow++;
            }
            else{
                int temp = popularity.get(fast);
                popularity.set(fast, popularity.get(slow));
                popularity.set(slow, temp);
//                fast++;
//                slow++;
                swaps++;
            }
        }

        return swaps;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int popularityCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> popularity = IntStream.range(0, popularityCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumSwaps(popularity);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
