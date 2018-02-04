package ru.geekbrains.java2.lesson3;

import java.util.*;

public class MainClass {

    static class PhoneBook{
        HashMap<String, HashSet<String>> hm;

        public PhoneBook() {
            this.hm = new HashMap<>();

        }
        public void add(String name, String phone){
         if (!hm.containsKey(name)) hm.put(name, new HashSet<>());
         hm.get(name).add(phone);
        }

        public HashSet<String> get(String name){

            return hm.get(name);
        }
    }

    public static void main(String[] args) {
        String[] arr = {"A", "B", "B", "C", "A", "B", "C"};
        HashSet<String> hs = new HashSet<>(Arrays.asList(arr));
        System.out.println(hs);

        HashMap<String, Integer> hm = new HashMap<>();
        for (String o: arr){
            hm.put(o, hm.getOrDefault(o,0)+1);
        }
        System.out.println(hm.keySet());
        System.out.println(hm);
    }
}
