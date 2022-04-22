package eu.vojtechsisma;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if ((i % 3) == 0 && (i % 5) == 0) {
                System.out.println("bumbác");
                continue;
            }
            if ((i % 3) == 0) {
                System.out.println("bum");
                continue;
            }
            if ((i % 5) == 0) {
                System.out.println("bác");
                continue;
            }
            System.out.println(i);
        }
    }
}
