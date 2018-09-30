package com.example.unboxingCompare;

import java.util.Comparator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
            Application app = ctx.getBean(Application.class);
            app.run();
        } catch (Exception e) {
            System.out.println("Application Error!");
            e.printStackTrace();
        }
    }

    private void run() throws Exception {
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                int f = first;  // Unboxing
                int s = second; // Unboxing
                return f < s ? -1 : (f == s ? 0 : 1);
            }
        };

        System.out.println("compare(2, 3) = " + naturalOrder.compare(2, 3));
        System.out.println("compare(2, 2) = " + naturalOrder.compare(2, 2));
        System.out.println("compare(3, 2) = " + naturalOrder.compare(3, 2));
    }
}
