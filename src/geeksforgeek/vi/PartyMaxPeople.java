package geeksforgeek.vi;

import java.util.Arrays;

/**
 * Created by devesh on 19/06/19.
 */
public class PartyMaxPeople {

    static int maxPeopleInParty(int [] entry, int [] exit){
        Arrays.sort(entry);
        Arrays.sort(exit);

        int p1 = 0; int p2 = 0;
        int count = 0; int maxCount = 0;
        int time = -1;

        while(p1 < entry.length && p2 < exit.length){

            if(entry[p1] <= exit[p2]){
                count++;
                if(maxCount < count){
                    maxCount = count;
                    time = entry[p1];
                }
                p1++;
            }
            else{
                count--;
                p2++;
            }
        }
        return time;
    }

    public static void main(String ar[]){
        int a [] = new int[]{ 1, 2, 9, 5, 5};
        int b [] = new int[]{ 4, 5, 12, 9, 12};

        System.out.println(maxPeopleInParty(a, b));
    }

}
