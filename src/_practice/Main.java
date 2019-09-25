package _practice;

import java.util.Stack;

/**
 * Created by devesh on 12/08/19.
 */
public class Main {


    static class ParkingService{

        Stack<Integer> parkingLot = new Stack<>();
        Stack<Integer> biLane = new Stack<>();


        public void parkCar(Integer i){
            parkingLot.add(i);
        }


        private void addCarInBiLane(Integer car){
            this.biLane.add(car);
        }

        public Integer takeOutCar(Integer i){
            if(biLane.size() > 0 && biLane.peek().equals(i)){
                return biLane.pop();
            }

            Integer parked = null;
            while(parkingLot.size() > 0 && (parked = parkingLot.pop()) != i){
                addCarInBiLane(parked);
            }
            return i.equals(parked) ? parked : -1;
        }

        public boolean canGetCarInOrder(){
            int expected = 1;
            while (parkingLot.size() > 0 || biLane.size() > 0){
                Integer takenOutCar = takeOutCar(expected);
                if(takenOutCar == -1){
                    return false;
                }
                expected++;
            }
            return true;
        }

    }

    public static void main(String ar[]){

        ParkingService parkingService = new ParkingService();
        parkingService.parkCar(5);
        parkingService.parkCar(4);
        parkingService.parkCar(3);
        parkingService.parkCar(2);
        parkingService.parkCar(1);

        boolean b = parkingService.canGetCarInOrder();
        System.out.println(b);

        int[]arr = new int[]{33,2};
//        Arrays.sort(arr, new Comparator<>());

    }

}
