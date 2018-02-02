package ru.geekbrains.java2.lesson3;

import java.util.*;

public class MainClass {
    static class Box{
        int size;

        public Box(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Box: " + size;
        }
//        box1.compareTo(box2);
//        @Override
//        public int compareTo(Object o) {
//            Box another = (Box)o;
//            if (this.size > another.size) return 1;
//            if (this.size < another.size) return -1;
//            return 0;
//        }
    }

    public static void main(String[] args) {
        TreeSet<Box> boxes = new TreeSet<>((o1, o2) -> o1.size - o2.size);

        boxes.add(new Box(5));
        boxes.add(new Box(2));
        boxes.add(new Box(4));
        System.out.println(boxes);

//        TreeSet<Box> boxes =  new TreeSet<>(Arrays.asList(new Box(5), new Box(2), new Box(4)));
//        System.out.println(boxes);



//        HashMap<String, Integer> hm = new HashMap<>();
//        hm.put("A", 1);
//        Iterator<Map.Entry<String, Integer>> iter = hm.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry<String, Integer> e = iter.next();
//            System.out.println(e.getKey() + " " + e.getValue());
//        }


//        ArrayList<Integer> ali = new ArrayList<>(Arrays.asList(2,2,2,1,1,1));
//        Iterator<Integer> iter = ali.iterator();
//        while(iter.hasNext()){
//            Integer temp = iter.next();
//            if (temp == 2) iter.remove();
//        }
//        System.out.println(ali);




        //        HashMap<String, Integer> hmi = new HashMap<>();
////        hmi.put("A", 1);
//        System.out.println(hmi.getOrDefault("A", 9));



//        HashSet<String> hs = new HashSet<>();
//        hs.add("A");
//        hs.add("A");
//        hs.add("A");
//        hs.add("B");
//        hs.add("B");
//        hs.add("C");
//        System.out.println(hs);
//
//        TreeSet<String> ts = new TreeSet<>(Arrays.asList("A","W", "Q", "C", "D", "W", "Q"));
//        System.out.println(ts);






//        String[] str = new String[16];
//        str[(str.length - 1) & "Java".hashCode()] = "Java";
//        str[(str.length - 1) & "Home".hashCode()] = "Home";
//        System.out.println(Arrays.toString(str));


////        ArrayList<String> al = new ArrayList<>();
////        for (int i = 0; i < 1_000_000; i++) {
////            al.add("Entry #" + i);
////        }
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (int i = 0; i < 1_000_000; i++) {
//            hm.put("Entry #" + i, i );
//        }
////        long time = System.currentTimeMillis();
////        for (int i = 0; i < 1000; i++) {
////            al.contains("Entry #522462");
////        }
////        System.out.println(System.currentTimeMillis() - time);
//
//        long time = System.currentTimeMillis();
//        for (int i = 0; i < 500_000_000; i++) {
//            hm.containsKey("Entry #522462");
////            hm.get("Entry #522462");
//        }
//        System.out.println(System.currentTimeMillis() - time);


//        HashMap<String, String> hm = new HashMap<>();
//        hm.put("France", "Paris");
//        hm.put("Russia", "Moscow");
//        hm.put("England", "London");
//        System.out.println(hm.get("France"));
//        System.out.println(hm.get("England"));
//



//        ArrayList<String> ali = new ArrayList<>(100_000);
//        ArrayList<String> ali2 = new ArrayList<>();
//        ali.add("A");
//        ali.add("A");
//        ali.add("A");
//        ali.add("C");
//        ali2.add("D");
//        ali2.add("E");
//        ali.addAll(1, ali2);
//        System.out.println(ali.lastIndexOf("A"));
//        System.out.println(ali);



//        int e = 10;
//        Integer x = e;
//        x++;
//        System.out.println(x);
//        int z = x;

//        ArrayList<String> als = new ArrayList<>(Arrays.asList("A","@", "Core", "Java", "Home"));
//        als.remove("@");
//        als.remove(2);
//        als.set(0, "Q");
//        System.out.println(als);
//        System.out.println(als.get(1));




//        ArrayList<String> al = new ArrayList<>();
//        al.add("A");
//        al.add("2");
//        al.add("Core");
//        al.add("Java");
//        al.add("Home");
//        System.out.println(al);
    }
}
