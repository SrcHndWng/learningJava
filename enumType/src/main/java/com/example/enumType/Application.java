package com.example.enumType;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public enum Operation {
        PLUS("+"){
            int apply(int x, int y) {
                return x + y;
            }
        },
        MINUS("-"){
            int apply(int x, int y) {
                return x - y;
            }
        },
        TIMES("*"){
            int apply(int x, int y) {
                return x * y;
            }
        },
        DEVIDE("/"){
            int apply(int x, int y) {
                return x / y;
            }
        };

        private final String symbol;
        Operation(String symbol) {
            this.symbol = symbol;
        }
        @Override public String toString() {
            return symbol;
        }
        abstract int apply(int x, int y);
    }

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
        int x = 10;
        int y = 2;

        Stream.of(Operation.values()).forEach(op -> {
            System.out.printf("%d %s %d = %d%n", x, op, y, op.apply(x, y));
        });
    }
}
