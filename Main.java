import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double[] list = new double[20];

        int index = 0;

        Scanner UserInput = new Scanner(System.in);

        while (index < 20) {
            System.out.println("Please enter a number or enter 99999 to quit entering numbers: ");
            double Input = UserInput.nextDouble();
            list[index] = Input;
            index++;

            for (int x = 0; x < index; x ++) {
                System.out.println(list[x]);
            }

            if (Input == 99999) {
                for (int x = 0; x < index; x ++) {
                    System.out.println(list[x]);
                }
                break;
            }

        }
    }
}
