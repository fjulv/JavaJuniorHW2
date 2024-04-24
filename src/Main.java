import randomDate.RandomDateProcessor;

public class Main {
    public static void main(String[] args) {

        Homework2 homework2 = new Homework2();
        RandomDateProcessor.processRandomDate(homework2);
        System.out.println(homework2.date);
        System.out.println(homework2.localDate);
        System.out.println(homework2.localDateTime);
    }
}

