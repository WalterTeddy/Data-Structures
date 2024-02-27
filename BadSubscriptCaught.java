import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {

        String[] names = {"Michael", "James", "Bond", "Max", "Jack", "Frank", "Bob", "Sarah", "Lily", "Barbra", "Eliot"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number:");
        int IndexOfName = scanner.nextInt();

        try {
            System.out.println("The name at the index of " + IndexOfName + " is " + names[IndexOfName]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You cannot have " + IndexOfName + " elements, as there is there is only 10 names");

        }
    }
}
