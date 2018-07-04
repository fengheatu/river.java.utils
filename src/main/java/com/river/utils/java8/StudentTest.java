package com.river.utils.java8;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author he.feng
 * @2018/6/15
 * @desc
 */
public class StudentTest {

    public static void main(String[] args) throws InterruptedException {
        Person student = new Student();
        String name = student.getName("he.feng");
        System.out.println(name);

       /* new Thread(() -> {
            for (int i= 0;i<100;i++) {
                System.out.println(i);
            }
        }).start();*/




        String[] strArr = { "Java8", "new", "feature", "Stream", "API" };
        int count = 0;
        for (String s : strArr) {
            if (s.length() > 3) {
                count++;
            }
        }
        System.out.println(count);

        Long  aLong = Stream.of(strArr).filter(w -> w.length() > 3).count();
        System.out.println(aLong);

        long count1 = Arrays.asList(strArr).parallelStream().filter(w -> w.length() > 3).count();

        System.out.println(count1);


        System.out.println("-------------------------------------------");

        Instant start = Instant.now();
        Thread.sleep(1000);
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println(duration.toMillis());

        System.out.println(Instant.now().toEpochMilli());


    }


}
