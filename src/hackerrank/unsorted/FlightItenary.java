package hackerrank.unsorted;

import java.util.*;

public class FlightItenary {

    static class Flight {
        String source;
        String dest;

        public Flight(String source, String dest){
            this.source = source;
            this.dest = dest;
        }
    }

//    public static List<String> getIt(List<Flight> flights, String source){
//        List<String> path = new ArrayList<>();
//        path.add(source);
//        path = backtrack(flights, path);
//        return path;
//    }
//
//    private static List<String> backtrack(List<Flight> flights, List<String> path){
//        if(flights.size() == 0){
//            return path;
//        }
//        String source = path.get(path.size()-1);
//        for(int i = 0; i < flights.size(); i++){
//
//            if(flights.get(i).source.equals(source)){
//                path.add(flights.get(i).dest);
//                List<Flight> newList = new ArrayList<>(flights);
//                newList.remove(i);
//                List<String> backtrack = backtrack(newList, path);
//                if(backtrack != null){
//                    return backtrack;
//                }
//                path.remove(path.size()-1);
//            }
//        }
//        return null;
//    }


    public static List<String> getIt(List<Flight> flights, String source){

        Map<String, TreeSet<String>> map = new HashMap<>();
        for(Flight f : flights){
            TreeSet<String> orDefault = map.getOrDefault(f.source, new TreeSet<>());
            orDefault.add(f.dest);
            map.put(f.source, orDefault);
        }

        List<String> path = new ArrayList<>();
        path.add(source);
        path = backtrack(map, path);
        return path;
    }

    private static List<String> backtrack(Map<String, TreeSet<String>> map, List<String> path){
//        boolean allZero = true;
//        for(Set<String> set : map.values()){
//            if(set.size() != 0){
//                allZero = false;
//                break;
//            }
//        }
//        if(allZero){
//            return path;
//        }
        if(map.size() == 0){
            return path;
        }
        String source = path.get(path.size()-1);

        TreeSet<String> strings = map.get(source);
        if(strings == null || strings.size() == 0){
            return null;
        }


        for(String s : strings){
            TreeSet<String> copy = new TreeSet<>(strings);
            path.add(s);
            Map<String, TreeSet<String>> newMap = new HashMap<>(map);
            newMap.put(source, copy);
            newMap.get(source).remove(s);
            if(newMap.get(source).size() == 0){
                newMap.remove(source);
            }
            List<String> backtrack = backtrack(newMap, path);
            if(backtrack != null){
                return backtrack;
            }
            TreeSet<String> orDefault = newMap.getOrDefault(source, new TreeSet<>());
            orDefault.add(s);
            newMap.put(source, orDefault);
            path.remove(s);
        }


//        for(int i = 0; i < flights.size(); i++){
//
//            if(flights.get(i).source.equals(source)){
//                path.add(flights.get(i).dest);
//                List<Flight> newList = new ArrayList<>(flights);
//                newList.remove(i);
//                List<String> backtrack = backtrack(newList, path);
//                if(backtrack != null){
//                    return backtrack;
//                }
//                path.remove(path.size()-1);
//            }
//        }
        return null;
    }


    public static void main(String ar[]){
        //[('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')]

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("B", "Z"));
        flights.add(new Flight("C", "D"));
        flights.add(new Flight("D", "A"));
        flights.add(new Flight("A", "C"));
        flights.add(new Flight("A", "B"));

        List<String> a = getIt(flights, "A");

        for(String s : a){
            System.out.print(s + " ");
        }
        System.out.println();

    }

}
