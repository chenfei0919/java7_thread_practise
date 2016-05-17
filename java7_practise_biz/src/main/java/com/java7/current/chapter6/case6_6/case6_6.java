package com.java7.current.chapter6.case6_6;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by jackeyChen on 2016/5/19.
 */
public class Case6_6 {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map;
        map = new ConcurrentSkipListMap<>();
        Thread threads[] = new Thread[25];
        int counter = 0;

        for (char i = 'A'; i < 'Z'; i++) {
            Task task = new Task(map, String.valueOf(i));
            threads[counter] = new Thread(task);
            threads[counter].start();
            counter++;
        }

        for (int i = 0; i < 25; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: size of the map: %d\n", map.size());
        Map.Entry<String, Contact> element;
        Contact contact;
        element = map.firstEntry();
        contact = element.getValue();
        System.out.printf("Main: First Entry: %s: %s\n", contact.getName(), contact.getPhone());
        element = map.lastEntry();
        contact = element.getValue();
        System.out.printf("Main Last Entry: %s: %s\n", contact.getName(), contact.getPhone());
        System.out.printf("Main: Submap from A1996 to B1002:\n");
        ConcurrentNavigableMap<String, Contact> submap = map.subMap("A1996", "B1002");
        do{
            element = submap.pollFirstEntry();
            if(element != null) {
                contact = element.getValue();
                System.out.printf("%s: %s\n", contact.getName(), contact.getPhone());
            }
        }while(element != null);
    }
}
